package org.ioopm.calculator.ast;

public class Exp extends Unary{
    public Exp(SymbolicExpression expression){
        super(expression);
    }

    @Override
    public String toString(){
        return "e^" + _expression;

    }
}
