package team.jit.workshop.data;

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
