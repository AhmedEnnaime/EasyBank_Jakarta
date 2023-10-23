package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.dao.EmployeeDao;
import com.youcode.easybank_jee.entities.Simulation;
import jakarta.inject.Inject;

public class SimulationService {

    public double createSimulation(Simulation simulation) throws Exception {
        if (simulation.getBorrowed_capital() == null || simulation.getProportional_annual_rate() == null || simulation.getMonthly_payment_num() == null) {
            throw new Exception("All fields need to be mentioned");
        } else {
            return (simulation.getBorrowed_capital() * simulation.getProportional_annual_rate() / 12) / (1 - Math.pow(1 + simulation.getProportional_annual_rate() / 12, -simulation.getMonthly_payment_num()));
        }
    }

}
