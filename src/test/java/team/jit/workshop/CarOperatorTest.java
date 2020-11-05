package team.jit.workshop;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

class CarOperatorTest {

    private Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car();
        car.setModel("default model!");

        System.out.println(car);
    }

    @BeforeAll
    static void setupClass() {
        System.out.println("Before class!");
    }

    @AfterEach
    void afterEach() {
        car = null;

        System.out.println("Car deleted!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After my test class!");
    }

    @Test
    public void engineStopWhenEngineStarted() {
        //GIVEN
        car.setEngineStarted(true);

        CarOperator carOperator = new CarOperator(car);

        //WHEN
        carOperator.engineStop();

        //THEN
        assertFalse(car.isEngineStarted());
    }
}