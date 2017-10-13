package com.sheriaapp.dennis.sheriaapp.models;

/**
 * Created by charles on 10/12/17.
 */


import java.util.List;

public class Business {

    private List<String> procedureOfRegistrationOfCompany = null;
    private List<String> licencingOfPremisesAndTrades = null;

    public Business() {
    }
    public Business(List<String> procedureOfRegistrationOfCompany, List<String> licencingOfPremisesAndTrades) {
        super();
        this.procedureOfRegistrationOfCompany = procedureOfRegistrationOfCompany;
        this.licencingOfPremisesAndTrades = licencingOfPremisesAndTrades;
    }

    public List<String> getProcedureOfRegistrationOfCompany() {
        return procedureOfRegistrationOfCompany;
    }

    public List<String> getLicencingOfPremisesAndTrades() {
        return licencingOfPremisesAndTrades;
    }


}
