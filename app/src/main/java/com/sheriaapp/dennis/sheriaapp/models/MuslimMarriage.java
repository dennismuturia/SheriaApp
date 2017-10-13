package com.sheriaapp.dennis.sheriaapp.models;

import java.util.List;

/**
 * Created by charles on 10/12/17.
 */

public class MuslimMarriage {

    private List<String> essentialFeatures = null;
    private List<String> requirementsForMarriage = null;
    private List<String> procedureOfMarriage = null;

    public MuslimMarriage() {
    }

    public MuslimMarriage(List<String> essentialFeatures, List<String> requirementsForMarriage, List<String> procedureOfMarriage) {
        super();
        this.essentialFeatures = essentialFeatures;
        this.requirementsForMarriage = requirementsForMarriage;
        this.procedureOfMarriage = procedureOfMarriage;
    }

    public List<String> getEssentialFeatures() {
        return essentialFeatures;
    }

    public void setEssentialFeatures(List<String> essentialFeatures) {
        this.essentialFeatures = essentialFeatures;
    }

    public List<String> getRequirementsForMarriage() {
        return requirementsForMarriage;
    }

    public void setRequirementsForMarriage(List<String> requirementsForMarriage) {
        this.requirementsForMarriage = requirementsForMarriage;
    }

    public List<String> getProcedureOfMarriage() {
        return procedureOfMarriage;
    }

    public void setProcedureOfMarriage(List<String> procedureOfMarriage) {
        this.procedureOfMarriage = procedureOfMarriage;
    }

}
