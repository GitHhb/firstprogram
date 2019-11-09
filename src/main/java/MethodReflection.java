import java.lang.reflect.Method;

public class MethodReflection {
    public static void main(String[] args) {
        MethodReflection mrefl = new MethodReflection();

        A a = new A();
        B b = new B();
        C c = new C();

        mrefl.meth(a);
        mrefl.meth(b);
        mrefl.meth(c);
        mrefl.withrefl(c);
    }

    public void withrefl(Object o) {
        meth(o);
        try {
            Method method = MethodReflection.class.getMethod("meth", o.getClass());
            method.invoke(new MethodReflection(), o);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void meth(Object o) {
        System.out.println("Method Object");
    }

    public void meth(A o) {
        System.out.println("Method A");
    }

    public void meth(B o) {
        System.out.println("Method B");
    }
}

class A {
}

class B extends A {
}

class C extends B {
}
