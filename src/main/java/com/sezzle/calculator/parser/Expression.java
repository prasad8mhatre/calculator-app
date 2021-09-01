package com.sezzle.calculator.parser;

import com.sezzle.calculator.exceptions.ParseException;
import com.sezzle.calculator.parser.operators.Operator;
import com.sezzle.calculator.parser.operators.OperatorIndentifier;

import java.util.Stack;

public class Expression {

    String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    static OperatorIndentifier operatorIndentifier = new OperatorIndentifier();

    public Double evaluate() throws ParseException {
        char[] tokens = this.expression.toCharArray();

        Stack<Double> values = new Stack<Double>();
        Stack<Operator> operators = new Stack<Operator>();

        try{
            for (int i = 0; i < tokens.length; i++) {

                if (tokens[i] == ' ')
                    continue;
                if (tokens[i] >= '0' && tokens[i] <= '9') {
                    i = checkForDigits(tokens, values, i);
                } else {
                    checkForOperators(tokens[i], values, operators);
                }
            }
        }catch (Exception ex){
            throw new ParseException("Invalid Expression");
        }

        //Evaluate Stack
        while (!operators.empty()) {
            Double b = values.pop();
            Double a = values.pop();
            values.push(operators.pop().apply(a, b));
        }

        return values.pop();
    }


    private void checkForOperators(char token, Stack<Double> values, Stack<Operator> operators) {
        Operator operator = operatorIndentifier.indentify(token);
        if (operator != null) {
            while (!operators.empty() && operatorIndentifier.checkPrecedence(token, operators.peek().getOperator())) {
                Double b = values.pop();
                Double a = values.pop();
                values.push(operators.pop().apply(a, b));
            }

            operators.push(operator);
        }
    }

    private int checkForDigits(char[] tokens, Stack<Double> values, int i) {
        StringBuffer buffer = new StringBuffer();

        while ((i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.'))) {
            buffer.append(tokens[i++]);
        }

        values.push(Double.parseDouble(buffer.toString()));
        i--;
        return i;
    }
}
