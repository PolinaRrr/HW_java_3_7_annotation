import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        Class testClass = TestClass.class;
        Object testObject = testClass.newInstance();

        Method[] methods = testClass.getDeclaredMethods();
        ArrayList<Method> listMethods = new ArrayList<>();

        Method beforeSuite = null;
        Method afterSuite = null;

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                listMethods.add(m);
            }
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuite == null) {
                    beforeSuite = m;
                } else throw new RuntimeException("The code contains several methods with the @BeforeSuite annotation");
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuite == null) {
                    afterSuite = m;
                } else throw new RuntimeException("The code contains several methods with the @AfterSuite annotation");
            }
            listMethods.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
                }
            });

        }
        if (beforeSuite != null) {
            beforeSuite.invoke(testObject, null);
        }
        for (Method m : listMethods) {
            m.invoke(testObject, null);
        }
        if (afterSuite != null) {
            afterSuite.invoke(testObject, null);
        }
    }
}
