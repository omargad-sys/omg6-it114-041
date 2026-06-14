package app;

import utility.Helper;

public class ChildHelper extends Helper {

    public static void main(String[] args) {

        publicMethod();

        protectedMethod();   // OK (inherited)

        defaultMethod();

        privateMethod();
    }
}
