package com.sezzle.calculator.parser.operators;

public class OperatorIndentifier {

    public Operator indentify(Character character){
        switch (character){
            case '+':
                return new Add();
            case '-':
                return new Subtract();
            case '/':
                return new Divide();
            case '*':
                return new Multiply();
            default:
                throw  new IllegalArgumentException("Invalid operator");
        }
    }

    public boolean checkPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

}
