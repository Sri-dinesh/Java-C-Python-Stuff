class Exceptions {
  public static void main(String[] args) {

    // java.lang - 5 keywords
    // try --> if we suspect a code having run time error.
    // catch --> catch an exception(catch is always followed by try) one catch or
    // multiple catch blocks.
    // finally --> irrespective of try and catch block runs or not finally block
    // will execute.
    // throw --> within a method(throw a single exception)
    // throws --> multiple exceptions can be thrown,

    // Checked Exceptions: ClassNotFoundException, FileNotFoundException,
    // IOException, InterruptedException.
    // Unchecked Exception: Is an exception that occurs at time of exception, also
    // called as Runtime Exception.
    // Ignored at the time of compilation... ArithmeticException,
    // ArrayIndexOutOfBoundsException, NullPointerException,
    // NumberFormatException, StringOutOfBoundsException.
    //

    // Printing Exception Information --> obj.stackTrace(), obj.toString(),
    // obj.GetMessage().
    //
    // Sytstem generated exceptions are automatically thrown by the java runtime.
    //
    // THROW - used explicity to throw an exception from a method or constructor.
    // Mainly used to throw custom exception. When a trow statement is encountered,
    // program execution is failed, and the nearest catch statement
    // is searched for a matching kind of exception.
    //
    // Syntax --> throw ThrowableInstance(); Ex: throw new ArithmeticException();
    //
    //
    // THROWS - Method may throw exceptions during the execution of program using
    // the throws keyword. is used to declare list of exception
    // that a method may throw during execution.
    //
    //
    // THROW vs THROWS differences:
    //
    // throw an excpetion explicity | used to declare an exception possbile during
    // its excecution.
    // is followed by instance of Throwable class or one of its sub-class | is
    // follewed by one or more exception class names separted by commas.
    // declared inside a method body | is used with method signature(method
    // declaration).
    //
    //
    // FINALLY - used to create a block of code that follows a Try Block, is always
    // executed weather there's an exception or not.
    // lets you run any cleanup type statements that you want to execute.
    //
    //
    // CUSTOM EXCEPTION - Allows us to create our own exception class to provide own
    // exception implementation. create you own exception simply by
    // extending Java Exception Class. We can define our own constructor(default,
    // parameterized).
    //
    //
    //
  }
}
