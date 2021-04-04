/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req.backing;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Size;
import req.constraint.groups.AddRequestInfo;
import req.entities.Request;
import req.facade.RequestFacadeLocal;

/**
 *
 * @author woodpecker
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {
    
    @Inject
    private RequestFacadeLocal requestFacade;

    @Size(min = 3, max = 60, message = "{request.size}", groups = AddRequestInfo.class)
    private String newRequest;
    
    private HtmlInputText newReqInputText;
    
    private HtmlDataTable requestsDataTable;

    /**
     * Creates a new instance of RequestsList
     */
    public RequestsList() {
    }

    /**
     * Get the value of newRequest
     *
     * @return the value of newRequest
     */
    public String getNewRequest() {
        return newRequest;
    }

    /**
     * Set the value of newRequest
     *
     * @param newRequest new value of newRequest
     */
    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    /**
     * Get the value of requestsDataTable
     *
     * @return the value of requestsDataTable
     */
    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    /**
     * Set the value of requestsDataTable
     *
     * @param requestsDataTable new value of requestsDataTable
     */
    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

    
    public List<Request> getAllRequests() {
        return requestFacade.findAll();
    }
    
    public String addRequest() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<RequestsList>> validateProperty = validator.validateProperty(this, "newRequest", AddRequestInfo.class);
        if (!validateProperty.isEmpty()) {
            String message = validateProperty.iterator().next().getMessage();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(getNewReqInputText().getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return null;
        }
        
        Request request = new Request();
        
        request.setRequestDate(LocalDate.now());
        request.setRequestText(getNewRequest());
        
        requestFacade.create(request);
        
        setNewRequest("");
        return null;
    }
    
    public String deleteRequest() {
        Request req = (Request) getRequestsDataTable().getRowData();
        requestFacade.remove(req);
        return null;
    }

    /**
     * @return the newReqInputText
     */
    public HtmlInputText getNewReqInputText() {
        return newReqInputText;
    }

    /**
     * @param newReqInputText the newReqInputText to set
     */
    public void setNewReqInputText(HtmlInputText newReqInputText) {
        this.newReqInputText = newReqInputText;
    }
    
}
