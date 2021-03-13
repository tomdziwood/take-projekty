/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.beans;

import java.util.ArrayList;

/**
 *
 * @author woodpecker
 */
public class MembersBean {
    
    private ArrayList members;
    private Boolean isVisibleEdges;

    public MembersBean() {
    }

    /**
     * @return the members
     */
    public ArrayList getMembers() {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers(ArrayList members) {
        this.members = members;
    }

    /**
     * @return the isVisibleEdges
     */
    public Boolean getIsVisibleEdges() {
        return isVisibleEdges;
    }

    /**
     * @param isVisibleEdges the isVisibleEdges to set
     */
    public void setIsVisibleEdges(Boolean isVisibleEdges) {
        this.isVisibleEdges = isVisibleEdges;
    }
}
