package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.entities.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationServiceTest {

    private SimulationService simulationService;

    @BeforeEach
    public void setUp() {
        simulationService = new SimulationService();
    }

    @Test
    public void testCreateSimulation() {
        Simulation simulation = new Simulation();
        simulation.setBorrowed_capital(10000.0);
        simulation.setProportional_annual_rate(0.05);
        simulation.setMonthly_payment_num(12);

        try {
            double result = simulationService.createSimulation(simulation);

            assertNotEquals(0.0, result);

            double expectedValue = 856.0748178846737;
            double delta = 0.01;
            assertEquals(expectedValue, result, delta);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCreateSimulationWithMissingFields() {
        Simulation simulation = new Simulation();

        try {
            double result = simulationService.createSimulation(simulation);
            fail("Exception should be thrown for missing fields");

        } catch (Exception e) {
            assertEquals("All fields need to be mentioned", e.getMessage());
        }
    }
}
