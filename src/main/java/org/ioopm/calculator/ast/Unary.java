package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression{
    protected final SymbolicExpression _operand;

    public Unary(SymbolicExpression operand){
        _operand = operand;
    }

}