package com.sezzle.calculator.parser.operators;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperatorIndentifierTest {

    OperatorIndentifier operatorIndentifier = new OperatorIndentifier();

    @Test
    public void testIndentify() {
        Character character = operatorIndentifier.indentify('+').getOperator();
        assertEquals("+", character.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndentifyInvalidOperation() {
        Character character = operatorIndentifier.indentify('$').getOperator();
    }

    @Test
    public void testCheckPrecedence() {
        assertEquals(true,operatorIndentifier.checkPrecedence('+','*'));
        assertEquals(true,operatorIndentifier.checkPrecedence('*','*'));
        assertEquals(false,operatorIndentifier.checkPrecedence('*','+'));
    }
}