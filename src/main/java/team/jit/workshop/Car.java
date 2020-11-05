package team.jit.workshop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Car {

    private String model;

    private boolean engineStarted;

    private boolean lightsOn;
}
