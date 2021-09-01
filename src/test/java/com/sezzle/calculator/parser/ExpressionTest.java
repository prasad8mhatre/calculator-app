package com.sezzle.calculator.parser;

import com.sezzle.calculator.exceptions.ParseException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTest {


    @Test
    public void testForSingleExpression() {
        Expression expression = new Expression("55/3");
        assertEquals(new Double(18.333333333333332),expression.evaluate());
    }

    @Test
    public void testForMultipleExpression() {
        Expression expression = new Expression("55/3-66*4+3");
        assertEquals(new Double(-242.66666666666666),expression.evaluate());
    }

    @Test
    public void testForMultipleExpressionformultipleOperatore() {
        Expression expression = new Expression("55*3/66/4+3");
        assertEquals(new Double(3.625),expression.evaluate());
    }

    @Test
    public void testForDecimalExpression() {
        Expression expression = new Expression("55.4/3.1-66*4.3+3");
        assertEquals(new Double(-262.9290322580645),expression.evaluate());
    }

    @Test(expected = ParseException.class)
    public void testForInvalidExpression() {
        Double result = new Expression("55.4//3.1-66*4.3+3").evaluate();
    }
}