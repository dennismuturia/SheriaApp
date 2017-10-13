package com.sheriaapp.dennis.sheriaapp.models;

/**
 * Created by charles on 10/12/17.
 */

import java.util.List;

public class ChristianMarriage {

    private List<String> requirements = null;
    private List<String> registryAndCost = null;
    private List<String> marriageAge = null;
    private List<String> ceremony = null;
    private List<String> witnesses = null;
    private List<String> marriageCertificate = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ChristianMarriage() {
    }

    /**
     *
     * @param witnesses
     * @param marriageCertificate
     * @param marriageAge
     * @param registryAndCost
     * @param ceremony
     * @param requirements
     */
    public ChristianMarriage(List<String> requirements, List<String> registryAndCost, List<String> marriageAge, List<String> ceremony, List<String> witnesses, List<String> marriageCertificate) {
        super();
        this.requirements = requirements;
        this.registryAndCost = registryAndCost;
        this.marriageAge = marriageAge;
        this.ceremony = ceremony;
        this.witnesses = witnesses;
        this.marriageCertificate = marriageCertificate;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public List<String> getRegistryAndCost() {
        return registryAndCost;
    }

    public List<String> getMarriageAge() {
        return marriageAge;
    }

    public List<String> getCeremony() {
        return ceremony;
    }

    public List<String> getWitnesses() {
        return witnesses;
    }


    public List<String> getMarriageCertificate() {
        return marriageCertificate;
    }


}
