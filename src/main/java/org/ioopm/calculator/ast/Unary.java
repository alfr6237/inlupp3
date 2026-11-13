package org.ioopm.calculator.ast;

public abstract class Unary extends MathematicalExpression {
    private final MathematicalExpression _operand;

    public Unary(MathematicalExpression operand){
        _operand = operand;
    }
}