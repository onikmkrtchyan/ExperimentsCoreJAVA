/**
 * Interesting example done with Artak
 */
class Main2 {
    public static void main(String[] args) {
     new Child();
    }
}

public class Parent {
    public Parent() {
        System.out.println("Parents constructor");
//        if (this instanceof Child) {
//            ((Child) this).init2();
//            System.out.println("This is child in parent constructor");
//        }
        init();
    }

     void init() {
        System.out.println("Parent init");
    }
}

class Child extends Parent {
     Child() {
        super();
        System.out.println("Child constructor");
        init();
    }

     void init() {
//        System.out.print("super.init();");
//        super.init();
        System.out.println("Child init");
    }

    void init2() {
        System.out.println("This is init2 method");
    }

    //This just else experiments
    static void staticFunction() {
        Child.staticInit();//    you can, because method is static and it belongs to CLASS (not Object)
        staticInit();//          you can, because method is static and it belongs to CLASS (not Object)
        new Child().init2();//   you can, because you call via object
        //          init2();//  you can't, because non-static methods belongs to OBJECT (not Class)
    }

    void nonStaticFunction(){
        init2();
        staticFunction();
    }

    static void staticInit(){
        System.out.println("hii");
    }
}