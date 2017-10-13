package com.sheriaapp.dennis.sheriaapp.models;

/**
 * Created by charles on 10/12/17.
 */

import java.util.List;

public class HinduMarriage {

    private List<String> conditions = null;
    private List<String> ceremony = null;
    private List<String> groundForDivorce = null;

    public HinduMarriage() {
    }

    public HinduMarriage(List<String> conditions, List<String> ceremony, List<String> groundForDivorce) {
        super();
        this.conditions = conditions;
        this.ceremony = ceremony;
        this.groundForDivorce = groundForDivorce;
    }

    public List<String> getConditions() {
        return conditions;
    }

    public List<String> getCeremony() {
        return ceremony;
    }
    public List<String> getGroundForDivorce() {
        return groundForDivorce;
    }
}
