public class HelloAll {
    public static void main(String[] args) {
        System.out.println("Hello All");
        AMain aMain = new AMain();
        AChild aChild = new AChild();

        AMain.printitStatic();
        aMain.printitInstance();
        AChild.printitStatic();
        aChild.printitInstance();

        aMain = aChild;
        aMain.printitStatic();
        aMain.printitInstance();
        AChild.printitStatic();
        aChild.printitInstance();
    }
}

class AMain {
    static void printitStatic(){
        System.out.println("class AMain - Static");
    }
    void printitInstance(){
        System.out.println("class AMain - Instance");
    }
}

class AChild extends AMain {
    static void printitStatic(){
        System.out.println("class AChild - Static");
    }
    void printitInstance(){
        System.out.println("class AChild - Instance");
    }
}


