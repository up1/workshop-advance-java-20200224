public class XXX {
    public static void main(String[] args) {
        B b = new B();
        A a = new A(b); // constructor injection
        a.setB(b); // Field injection
        a.callA(b); // Method injection
    }
}
class A {
    B b;

    public A(B b) {
        this.b = b;
    }

    public void callA(B b) {
        this.b.callB();
    }

    public void setB(B b) {
        this.b = b;
    }
}
class B {
    public void callB() {
    }
}
