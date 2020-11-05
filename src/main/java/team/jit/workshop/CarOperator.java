package team.jit.workshop;

public class CarOperator {

    private Car car;

    public CarOperator(Car car) {
        this.car = car;
    }

    public void engineStart() {
        car.setEngineStarted(true);
    }

    public void engineStop() {
        car.setEngineStarted(false);
    }

    public void lightsOn() {
        car.setLightsOn(true);
    }

    public void lightsOff() {
        car.setLightsOn(false);
    }
}
