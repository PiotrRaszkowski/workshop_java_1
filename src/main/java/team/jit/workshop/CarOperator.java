package team.jit.workshop;

public class CarOperator {

    private Car car;

    private EngineManager engineManager = new EngineManager();

    public CarOperator(Car car) {
        this.car = car;
    }

    public void engineStart() {
        car.setEngineStarted(true);

        engineManager.afterEngineStarted();
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
