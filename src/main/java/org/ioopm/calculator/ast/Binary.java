package org.ioopm.calculator.ast;

public abstract class Binary extends MathematicalExpression{
    protected  SymbolicExpression _lhs;
    protected  SymbolicExpression _rhs;

    protected Binary(SymbolicExpression lhs, SymbolicExpression rhs){
        _lhs = lhs;
        _rhs = rhs;
    }


    public abstract String toString();
}
