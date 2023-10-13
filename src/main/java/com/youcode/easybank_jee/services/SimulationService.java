package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.dao.EmployeeDao;
import com.youcode.easybank_jee.entities.Simulation;
import jakarta.inject.Inject;

public class SimulationService {

    @Inject
    private EmployeeDao employeeDao;

    public double createSimulation(Simulation simulation) {
        double result = 0;
        try {
            if (simulation.getBorrowed_capital().toString().isEmpty() || simulation.getMonthly_payment_num().toString().isEmpty()) {
                throw new Exception("All fields need to be mentioned");
            } else {
                result = (simulation.getBorrowed_capital() * simulation.getProportional_annual_rate()/12) / (1 - Math.pow(1 + simulation.getProportional_annual_rate()/12, -simulation.getMonthly_payment_num()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
