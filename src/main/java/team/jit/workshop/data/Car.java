package team.jit.workshop.data;

import lombok.*;

import java.util.Objects;

@Getter
//@Setter
@ToString
@Builder
public class Car {

    private String model;

    private boolean engineStarted;

    private boolean lightsOn;

    @Override
    public boolean equals(Object o) {
        System.out.println("Equals check " + model + " vs " + ((Car) o).model );
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        System.out.println("HashCode check " + model + " " + Objects.hash(model));
        return 1;
    }
}
