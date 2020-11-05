package team.jit.workshop;

public class CarOperator {

    private Car car;

    private EngineManager engineManager = new EngineManager();

    public CarOperator(Car car) {
        this.car = car;
    }

    public void engineStart() {
        System.out.println("Engine state = " + engineManager.getEngineState());

        if (engineManager.getEngineState() == EngineState.FAILURE) {
            System.out.println("SYSTEM FAILURE! UNABLE TO START!");
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
