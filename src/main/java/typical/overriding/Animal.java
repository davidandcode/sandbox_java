package typical.overriding;

/**
 * ClassName: Animal
 * Description:
 * 1.Must have the same method signature (name, parameters, and return type).
 * 2.The method in the subclass should have the same or a more accessible access modifier.
 *
 * @Author David
 * @Create 11/7/24 9:23 PM
 * @Version 1.0
 */
public class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("Dog barks");
    }
}
