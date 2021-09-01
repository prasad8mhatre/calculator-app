package com.sezzle.calculator.parser.operators;


public class Multiply implements Operator {
    public Double apply(Double a, Double b) {
        return a*b;
    }

    public Character getOperator() {
        return '*';
    }

}
