package com.sheriaapp.dennis.sheriaapp.models;

/**
 * Created by charles on 10/12/17.
 */

import java.util.List;

public class Police {

    private List<String> arrested = null;
    private List<String> arrestedRights = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Police() {
    }

    /**
     *
     * @param arrested
     * @param arrestedRights
     */
    public Police(List<String> arrested, List<String> arrestedRights) {
        super();
        this.arrested = arrested;
        this.arrestedRights = arrestedRights;
    }

    public List<String> getArrested() {
        return arrested;
    }

    public void setArrested(List<String> arrested) {
        this.arrested = arrested;
    }

    public List<String> getArrestedRights() {
        return arrestedRights;
    }

    public void setArrestedRights(List<String> arrestedRights) {
        this.arrestedRights = arrestedRights;
    }

}
