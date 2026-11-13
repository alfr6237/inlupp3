package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression{
    protected final SymbolicExpression _expression;

    public Unary(SymbolicExpression operand){
        _expression = operand;
    }

}