package com.sezzle.calculator.parser.operators;


public class Subtract implements Operator {
    public Double apply(Double a, Double b) {
        return a-b;
    }

    public Character getOperator() {
        return '-';
    }

}
