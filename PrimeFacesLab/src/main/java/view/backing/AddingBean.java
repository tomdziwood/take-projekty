/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author woodpecker
 */
@Named(value = "addingBean")
@RequestScoped
public class AddingBean {
    
    private Integer firstAdd;
    private Integer secondAdd;
    private Integer resultAdd;
    private Date date;

    /**
     * Creates a new instance of AddingBean
     */
    public AddingBean() {
        date = new Date();
    }

    /**
     * @return the firstAdd
     */
    public Integer getFirstAdd() {
        return firstAdd;
    }

    /**
     * @param firstAdd the firstAdd to set
     */
    public void setFirstAdd(Integer firstAdd) {
        this.firstAdd = firstAdd;
    }

    /**
     * @return the secondAdd
     */
    public Integer getSecondAdd() {
        return secondAdd;
    }

    /**
     * @param secondAdd the secondAdd to set
     */
    public void setSecondAdd(Integer secondAdd) {
        this.secondAdd = secondAdd;
    }

    /**
     * @return the resultAdd
     */
    public Integer getResultAdd() {
        return resultAdd;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void add() {
        resultAdd = firstAdd + secondAdd;
        date = new Date();
        
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Executed expression",
                        String.format("%d + %d = %d", firstAdd, secondAdd, resultAdd)));
    }
}
