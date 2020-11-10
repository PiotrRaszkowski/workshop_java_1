package team.jit.workshop.services;

import team.jit.workshop.data.EngineState;

public class EngineManager {

    public EngineState getEngineState() {
        return EngineState.FAILURE;
    }

    public void afterEngineStarted() {
        System.out.println("after engine started!");
    }

    public void afterEngineStopped() {
        System.out.println("after engine stopped!");
    }
}
