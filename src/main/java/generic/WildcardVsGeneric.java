package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: WildcardVsGeneric
 * Description:
 *
 *  public static void process(List<? extends Foo> list)
 *      More restrictive. You can read but cannot add elements. Suitable when you don’t need to know the exact type beyond Foo.
 *
 *  public static <T extends Foo> void process(List<T> list)
 *      More flexible. You can both read and add elements of the exact type T, making it better when the exact subtype of Foo is important for the method’s logic.
 *
 * @Author David
 * @Create 11/8/24 2:29 PM
 * @Version 1.0
 */
public class WildcardVsGeneric {

    public static void processOne(List<? extends Foo> list) {
        for (Foo foo : list) {
            foo.print();  // Allowed because we know it's at least a Foo
        }

        // list.add(new Bar());  // Not allowed, you cannot add any elements
    }

    public static <T extends Foo> void processTwo(List<T> list) {
        for (T item : list) {
            item.print();  // Allowed, T is known
        }

        // You can also add elements of type T to the list
        // list.add(new Bar());  // This would work only if T is Bar
    }

    public static void main(String[] args) {

        List<Bar> barsOne = List.of(new Bar(), new Bar());
        List<Baz> bazsOne = List.of(new Baz(), new Baz());

        processOne(barsOne);  // Works
        processOne(bazsOne);  // Also works



        //use array list as it is mutable
        List<Bar> bars = new ArrayList<>(List.of(new Bar(), new Bar()));
        List<Baz> bazs = new ArrayList<>(List.of(new Baz(), new Baz()));

        processTwo(bars);  // Works
        WildcardVsGeneric.<Bar>processTwo(bars);  // Works

        processTwo(bazs);  // Also works
        WildcardVsGeneric.<Baz>processTwo(bazs);  // Also works


        // You could add specific type elements inside the method if needed

    }
}

class Foo {
    void print() {
        System.out.println("I am a Foo");
    }
}

class Bar extends Foo {
    void print() {
        System.out.println("I am a Bar");
    }
}

class Baz extends Foo {
    void print() {
        System.out.println("I am a Baz");
    }
}
