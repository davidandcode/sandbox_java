package typical.hashequal;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Monkey
 * Description:
 *
 *  This is a negative example!!!!
 *
 *  the default hashcode is the object's memory address
 *
 * @Author David
 * @Create 11/7/24 9:49 PM
 * @Version 1.0
 */
public class Monkey {
    private String name;
    private int age;

    public Monkey(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Monkey monkey = (Monkey) obj;
        return monkey.name.equals(name) && monkey.age == age;
    }

//    @Override
//    public int hashCode(){
//        return name.hashCode() + age;
//    }

    public static void main(String[] args){
        Monkey m1 = new Monkey("tom", 5);
        Monkey m2 = new Monkey("tom", 5);

        Set<Monkey> monkeySet = new HashSet<>();
        monkeySet.add(m1);
        System.out.println(monkeySet.contains(m2)); // false, which is wrong because same monkey

    }

}
