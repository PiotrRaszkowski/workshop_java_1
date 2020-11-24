package team.jit.workshop;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.multi.MultiButtonUI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

    @Test
    public void test1() {
        List<String> names = Arrays.asList("Piotr", "Łukasz", "Andrzej");

        names.sort(new NamesComparator());

        for (String name : names) {
            System.out.println(name);
        }
    }

    public static class NamesComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    @Test
    public void test2() {
        List<String> names = Arrays.asList("Piotr", "Łukasz", "Andrzej");

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test3() {
        List<String> names = Arrays.asList("Piotr", "Łukasz", "Andrzej");

        names.sort((String a, String b) -> {
            return a.compareTo(b);
        });

        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test4() {
        List<String> names = Arrays.asList("Piotr", "Łukasz", "Andrzej");

        names.sort((String a, String b) -> a.compareTo(b));

        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test5() {
        List<String> names = Arrays.asList("Piotr", "Łukasz", "Andrzej");

        names.sort((a, b) -> a.compareTo(b));

        for (String name : names) {
            System.out.println(name);
        }
    }

    @FunctionalInterface
    public interface Transformer<T, Z> {
        Z transform(T from);
    }

    public static class StringToLongTransformer {

        public Long transform(String content, Transformer<String, Long> transformer) {
            return transformer.transform(content);
        }
    }

    @Test
    public void test6() {
        StringToLongTransformer stringToLongTransformer = new StringToLongTransformer();

        Long transformed = stringToLongTransformer.transform("123", (from) -> Long.valueOf(from));

        System.out.println(transformed);
    }

    @Test
    public void test7() {
        Transformer<String, Long> transformer = (from) -> Long.valueOf(from);

        System.out.println(transformer.transform("432"));
    }

    @Test
    public void test8() {
        Transformer<String, Long> transformer = Long::valueOf;

        System.out.println(transformer.transform("999"));
    }

    @Test
    public void test9() {
        List<String> names = Arrays.asList("Piotr", "Łukasz", "Andrzej");

        names.sort(Comparator.reverseOrder());

        for (String name : names) {
            System.out.println(name);
        }
    }

}
