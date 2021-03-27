/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.backing;

/**
 *
 * @author woodpecker
 */
public class Student {
    
    private String firstName;
    private String name;
    private Double avg;

    public Student(String firstName, String name, Double avg) {
        this.firstName = firstName;
        this.name = name;
        this.avg = avg;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the avg
     */
    public Double getAvg() {
        return avg;
    }

    /**
     * @param avg the avg to set
     */
    public void setAvg(Double avg) {
        this.avg = avg;
    }
    
}
