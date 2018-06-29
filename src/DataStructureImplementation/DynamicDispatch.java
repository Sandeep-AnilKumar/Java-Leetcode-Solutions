package DataStructureImplementation;

public class DynamicDispatch {
    
    static interface A {
        void foo();
    }
    
    static class B implements A {
        public void foo() {
            System.out.println("I am in B");
        }
    }
    
    public static void main(String[] args) {
        A a = new B();
        a.foo();
    }
}
