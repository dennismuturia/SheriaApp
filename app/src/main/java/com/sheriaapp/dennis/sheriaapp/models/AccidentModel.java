package com.sheriaapp.dennis.sheriaapp.models;

import java.util.List;

/**
 * Created by charles on 10/12/17.
 */

public class AccidentModel {
    private List<String> carOnCar = null;
    private List<String> carPedstrian = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public AccidentModel() {
    }

    /**
     *
     * @param carOnCar
     * @param carPedstrian
     */
    public AccidentModel(List<String> carOnCar, List<String> carPedstrian) {
        super();
        this.carOnCar = carOnCar;
        this.carPedstrian = carPedstrian;
    }

    public List<String> getCarOnCar() {
        return carOnCar;
    }

    public List<String> getCarPedstrian() {
        return carPedstrian;
    }

}
