package com.sezzle.calculator.parser.operators;

import java.math.RoundingMode;

public class Divide implements Operator {
    public Double apply(Double a, Double b) {
        if (b == 0){
            throw new UnsupportedOperationException("Cannot divide by zero");
        }

        return a/b;
    }

    public Character getOperator() {
        return '/';
    }

}
