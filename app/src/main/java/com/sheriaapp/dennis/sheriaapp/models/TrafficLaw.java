package com.sheriaapp.dennis.sheriaapp.models;

/**
 * Created by charles on 10/12/17.
 */

import java.util.List;

public class TrafficLaw {

    private List<Object> essentialRules = null;
    private List<String> majorOffences = null;
    private List<String> minorNtsaOffences = null;

    public TrafficLaw() {
    }

    public TrafficLaw(List<Object> essentialRules, List<String> majorOffences, List<String> minorNtsaOffences) {
        super();
        this.essentialRules = essentialRules;
        this.majorOffences = majorOffences;
        this.minorNtsaOffences = minorNtsaOffences;

    }

    public List<Object> getEssentialRules() {
        return essentialRules;
    }

    public List<String> getMajorOffences() {
        return majorOffences;
    }

    public List<String> getMinorNtsaOffences() {
        return minorNtsaOffences;
    }



}
