package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression{
    private final SymbolicExpression _operand;

    public Unary(SymbolicExpression operand){
        _operand = operand;
    }

}