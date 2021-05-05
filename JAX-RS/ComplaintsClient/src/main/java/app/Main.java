/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author woodpecker
 */
public class Main {
    
    public static void findAll(Client client) throws JsonProcessingException {
        String json = client
                .target("http://localhost:8080/Complaints/resources/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        
        String prettyString = jsonNode.toPrettyString();        
        System.out.println("All complaints: " + prettyString);
    }
    
    public static String find(Client client, Long id) throws JsonProcessingException {
        String json = client
                .target("http://localhost:8080/Complaints/resources/complaints/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        
        String prettyString = jsonNode.toPrettyString();        
        System.out.println("Chosen complaint: " + prettyString);
        
        return json;
    }
    
    public static void edit(Client client, String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        
        ((ObjectNode)jsonNode).put("status", "closed");
        
        Response response = client
                .target("http://localhost:8080/Complaints/resources/complaints/" + jsonNode.get("id"))
                .request()
                .put(Entity.json(jsonNode.toString()));
             
        System.out.println("Response of editing: " + response);
    }
    
    public static void findAllOpened(Client client) throws JsonProcessingException {
        String json = client
                .target("http://localhost:8080/Complaints/resources/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        
        String prettyString = jsonNode.toPrettyString();        
        System.out.println("Opened complaints: " + prettyString);
    }
    
    public static void main(String[] args) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        String count = client
                .target("http://localhost:8080/Complaints/resources/complaints/count")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        
        System.out.println("Count: " + count);
        
        findAll(client);
        
        String openedComplaint = find(client, 2L);
        
        edit(client, openedComplaint);
        
        findAllOpened(client);
        
        client.close();
    }
}
