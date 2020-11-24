package team.jit.workshop;

import org.junit.jupiter.api.Test;

public class UseNestedClassTest {

    @Test
    public void testBook() {
        NestedClassesTest nestedClassesTest = new NestedClassesTest();

        NestedClassesTest.Book book = nestedClassesTest.new Book();
        book.setTitle("Alicja w Krainie Czarów");
        book.setAuthor("Jan Kochanowski");
    }

    @Test
    public void testBike() {
        NestedClassesTest.Bike bike = new NestedClassesTest.Bike();
        bike.setManufacturer("Canyon");
    }

    @Test
    public void testLocalClass () {

        class MyComparator implements Comparable<NestedClassesTest.Bike> {

            @Override
            public int compareTo(NestedClassesTest.Bike o) {
                return 0;
            }
        }

        MyComparator myComparator = new MyComparator();

//        new Comparable<NestedClassesTest.Bike>() {
//
//        }
    }
}
