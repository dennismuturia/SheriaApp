package com.sheriaapp.dennis.sheriaapp.models;

import java.util.List;

/**
 * Created by charles on 10/12/17.
 */

public class LandModel {

    private List<String> landAcquistion = null;
    private List<String> landInterests = null;
    private List<String> landLordRights = null;
    private List<String> tenantRight = null;
    private List<String> titleAquistion = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public LandModel() {
    }

    public LandModel(List<String> landAcquistion, List<String> landInterests, List<String> landLordRights, List<String> tenantRight, List<String> titleAquistion) {
        super();
        this.landAcquistion = landAcquistion;
        this.landInterests = landInterests;
        this.landLordRights = landLordRights;
        this.tenantRight = tenantRight;
        this.titleAquistion = titleAquistion;
    }

    public List<String> getLandAcquistion() {
        return landAcquistion;
    }


    public List<String> getLandInterests() {
        return landInterests;
    }


    public List<String> getLandLordRights() {
        return landLordRights;
    }


    public List<String> getTenantRight() {
        return tenantRight;
    }


    public List<String> getTitleAquistion() {
        return titleAquistion;
    }

}
