import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Class testClass = TestClass.class;
        Object testObject = testClass.newInstance();

        Method[] methods = testClass.getDeclaredMethods();
        ArrayList<Method> listMethods = new ArrayList<>();
        
    }
}
