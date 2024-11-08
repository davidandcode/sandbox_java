package typical.hashequal;

import java.util.HashSet;
import java.util.Objects;

/**
 * ClassName: Person
 * Description:
 *  1. When overriding equals(), also needs override hashCode()
 *  Objects that are equal according to equals() must have the same hash code.
 *  Overriding equals() without hashCode() leads to unexpected behavior in hash-based collections: hashset or hashmap etc
 *  2. Don't have to override equals() when overriding hashCode(): same hashcode doesn't mean objects are equal
 *
 *
 * @Author David
 * @Create 11/7/24 9:27 PM
 * @Version 1.0
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj){
        /*
        * !!!!!!!!!!!pay attention to these 2 edge cases!!!!!!!!!!!!
        * */
        if(this == obj) return true;
        if(obj ==null || obj.getClass() != this.getClass()) return false;

        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode(){
        return name.hashCode() + age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);

        HashSet<Person> set = new HashSet<>();
        set.add(p1);

        System.out.println(set.contains(p2)); // true
    }
}
