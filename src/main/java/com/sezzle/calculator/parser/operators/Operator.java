package com.sezzle.calculator.parser.operators;


public interface Operator {
    Double apply(Double a, Double b);
    Character getOperator();

}
