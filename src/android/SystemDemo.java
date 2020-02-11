package android;

import java.lang.*;

public class SystemDemo {

    public static void main(String[] args) throws Exception {

        // gets the value of the specified environment variable "PATH"
        System.out.println("System.getenv(\"JAVA_HOME\") = ");
        System.out.println(System.getenv("JAVA_HOME"));

    }
} 