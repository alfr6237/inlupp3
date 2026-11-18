package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression{
    protected  SymbolicExpression lhs;
    protected  SymbolicExpression rhs;

    protected Binary(SymbolicExpression lhs, SymbolicExpression rhs){
        this.lhs = lhs;
        this.rhs = rhs;
    }



}
