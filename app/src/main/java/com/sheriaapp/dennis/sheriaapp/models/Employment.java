package com.sheriaapp.dennis.sheriaapp.models;

/**
 * Created by charles on 10/12/17.
 */

import java.util.List;

public class Employment {

    private List<String> contracts = null;
    private List<String> terminationOfContracts = null;

    public Employment() {
    }
    public Employment(List<String> contracts, List<String> terminationOfContracts) {
        super();
        this.contracts = contracts;
        this.terminationOfContracts = terminationOfContracts;
    }

    public List<String> getContracts() {
        return contracts;
    }

    public List<String> getTerminationOfContracts() {
        return terminationOfContracts;
    }


}