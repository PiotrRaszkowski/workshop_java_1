package team.jit.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import team.jit.workshop.data.Car;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {

    public class Cars implements Iterable<Car> {

        private List<Car> cars = new ArrayList<>();

        public void addCar(Car car) {
            this.cars.add(car);
        }

        @Override
        public Iterator<Car> iterator() {
            return cars.iterator();
        }
    }

    @Test
    public void customCollectionTest() {
        //GIVEN
        Cars cars = new Cars();
        cars.addCar(Car.builder().model("Tesla 3").build());
        cars.addCar(Car.builder().model("BMW X3").build());
        cars.addCar(Car.builder().model("Ferrari").build());

        //WHEN
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void mapTest() {
        Map<Car, String> cars = new HashMap<>();

        Car car1 = Car.builder().model("Audi A4").build();
        Car car2 = Car.builder().model("Audi A6").build();
        Car car3 = Car.builder().model("Citroen C3").build();

        cars.put(car1, "Piotr Raszkowski");
        cars.put(car2, "Jacek Kowalski");
        cars.put(car3, "Jan Nowak");

        assertEquals(3, cars.size());
    }

    public void queueTest() {
        Queue<Car> cars = new LinkedList<>();
    }

    @Test
    public void setTest() {
        Car car1 = Car.builder().model("Audi A4").build();
        Car car2 = Car.builder().model("Audi A4").build();
        Car car3 = Car.builder().model("Citroen C3").build();

        Set<Car> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        for (Car car : cars) {
            System.out.println(car);
        }

        assertEquals(3, cars.size());
    }
}
