package com.sezzle.calculator;

import com.sezzle.calculator.exceptions.ParseException;
import com.sezzle.calculator.parser.Expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("Calculator Application!");
        System.out.println("Enter you expression:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();
        Expression expr = new Expression(expression);
        try{
            System.out.println("Result: " + expr.evaluate());
        }catch (ParseException ex){
            System.out.println("Error while parsing expression, Please check your expression, exiting!");
        }
    }

}
