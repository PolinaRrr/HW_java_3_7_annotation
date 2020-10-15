public class TestClass {

    @BeforeSuite
    public static void startOfTesting(){
        System.out.println("Testing started.");
    }

    @Test(priority = 9)
    public static void test1(){
        System.out.println("test1");
    }
    @Test(priority = 8)
    public static void test2(){
        System.out.println("test2");
    }
    @Test(priority = 7)
    public static void test3(){
        System.out.println("test3");
    }
    @Test(priority = 6)
    public static void test4(){
        System.out.println("test4");
    }
    @Test
    public static void test5(){
        System.out.println("test5");
    }
    @Test
    public static void test6(){
        System.out.println("test6");
    }
    @Test(priority = 4)
    public static void test7(){
        System.out.println("test7");
    }
    @Test(priority = 3)
    public static void test8(){
        System.out.println("test8");
    }

    @AfterSuite
    public static void endOfTesting(){
        System.out.println("Testing completed.");
    }


}
