package team.jit.workshop;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

public class NestedClassesTest {

    private String field;

    @Getter
    @Setter
    public class Book {
        private String title;

        private String author;
    }

    @Setter
    @Getter
    public static class Bike {

        private String manufacturer;
    }

    @Test
    public void test() {

        Book book = new Book();
        book.author = "Henryk Sienkiewicz";
        book.title = "Potop";

        Bike bike = new Bike();
        bike.manufacturer = "Canyon";
    }

}
