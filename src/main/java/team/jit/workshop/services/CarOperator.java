package team.jit.workshop.services;

import team.jit.workshop.data.EngineState;
import team.jit.workshop.data.Car;
import team.jit.workshop.exceptions.ModelIsEmptyException;
import team.jit.workshop.exceptions.NoModelProvidedException;
import team.jit.workshop.exceptions.UnableToStartEngineException;

public class CarOperator {

    private Car car;

    private EngineManager engineManager = new EngineManager();

    public CarOperator(Car car) {
        this.car = car;
    }

    public void printCarInfo() throws UnableToStartEngineException, NoModelProvidedException  {
        if (car.getModel() == null) {
            throw new NoModelProvidedException();
        }

        if (car.getModel().isEmpty()) {
            throw new ModelIsEmptyException();
        }

        System.out.println("Car operates on model = " + car.getModel());
    }

    public void engineStart() throws UnableToStartEngineException {
        System.out.println("Engine state = " + engineManager.getEngineState());

        if (engineManager.getEngineState() == EngineState.FAILURE) {
           throw new UnableToStartEngineException();
        } else {
            car.setEngineStarted(true);

            engineManager.afterEngineStarted();
        }
    }

    public void engineStop() {
        car.setEngineStarted(false);

        engineManager.afterEngineStopped();
    }

    public void lightsOn() {
        car.setLightsOn(true);
    }

    public void lightsOff() {
        car.setLightsOn(false);
    }
}
