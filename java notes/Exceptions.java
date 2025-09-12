import java.util.*;
import java.io.*;

class Exceptions {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    // Exceptions --> continue the flow of execution.Try, catch, finally, throw, throws.    
    // an exception is an abonormal condition that arises in a code at run time. --> run time error... when an exception occurs the normal flow of the program is
    // disrupted and the program terminates abnormally, which is not recommended. 
    // Ex: DivisionByZero, ArrayIndexOutOfBoundsException, Invalid data, file that needs to be openend cannot be found, network connection lost
    // some of these exceptions are caused by user, others by programmer error, and others are physical resources that have failed in some manner.
    // "exception handling is a mechanism to handle the runtime error, so that the normal flow of application can be maintained."
    // 3 Types of exceptions --> 1. User Defined Exception | 2. Built-In Excpetions > 2.1 Checked Exception; 2.2 Unchecked Exception | 3. Error


    // Types of Exception

    //   userDefined         Built-In
                              
    //                    Checked           Unchecked
    //                classnotfound     arithmatic, classCast, NullPointer, ArrayStore, IllegalThreadState, 
    //                interrupted
    //                io
    //                sql
    //                fileNotFound

    // Checked Exception --> An exception that occurs at the compile time. Exceptions cannot be ignored, the programmer should take care of those exceptions.



    System.out.println("Enter any 2 numbers: ");
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();

    int arr[] = {0, 1, 2, 3, 4};

    try {
      int num3 = num1 / num2;
      System.out.println(num3);
     } catch(Exception e) {
      System.out.println(e);
    }

    try {
      System.out.println(arr[8]);
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println(e);
    } finally {
      System.out.println("End of the Try - Catch");
    }


    for(int i = 0 ; i<arr.length; i++) {
      System.out.println(arr[i]);
    }

  }
}
