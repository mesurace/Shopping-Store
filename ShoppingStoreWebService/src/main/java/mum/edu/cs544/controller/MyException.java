package mum.edu.cs544.controller;

public class MyException extends Exception {
	 //Parameterless Constructor
    public MyException() {}

    public MyException(String message)
    {
       super(message);
    }
}
