package typical.overloading;


/**
 * ClassName: Calculator
 * Description:
 *
 * Overloading:
 *  1.same function name in the same class;
 *  2.different parameter list;
 *  3.return type can be same or different
 *
 *
 * @Author David
 * @Create 11/7/24 8:49 PM
 * @Version 1.0
 */
public class Calculator {
    public int add(int a, int b){
        int result = a + b;
        return result;
    }

    public float add(float m, float n){
        return m + n;
    }

    public static void main(String[] args){

    }
}
