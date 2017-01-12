package miscs;

/**
 * Created by zhaocw on 2017-1-12.
 *
 * @author zhaocw
 */
public class TestTryWithResource {
    public static void main(String[] args) {
        try {
            try(MyResource myResource = new MyResource("testex")) {
                myResource.doSomething2();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyResource implements AutoCloseable {
        private final String name;

        public MyResource(String name) throws Exception {
            this.name = name;
            if(name.equals("testex")) {
                throw new Exception("ex in cons");
            }
        }
        @Override
        public void close() throws Exception {
            System.out.println(name+" closed");
        }

        public void doSomething() {
            System.out.println(name+" doing");
        }
        public void doSomething2() throws Exception {
            System.out.println(name+" doing");
            throw new Exception("test2");
        }
    }
}


