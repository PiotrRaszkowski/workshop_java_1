package team.jit.workshop.services;

import team.jit.workshop.data.Car;
import team.jit.workshop.exceptions.ModelIsEmptyException;
import team.jit.workshop.exceptions.NoModelProvidedException;
import team.jit.workshop.exceptions.UnableToStartEngineException;

public class CarInfoPrinter {

    private Car car;

    public CarInfoPrinter(Car car) {
        this.car = car;
    }

    public void printCarInfo() throws UnableToStartEngineException, NoModelProvidedException {
        if (car.getModel() == null) {
            throw new NoModelProvidedException();
        }

        if (car.getModel().isEmpty()) {
            throw new ModelIsEmptyException();
        }

        System.out.println("Car operates on model = " + car.getModel());
    }
}
