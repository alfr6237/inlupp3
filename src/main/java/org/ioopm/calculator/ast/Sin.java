package org.ioopm.calculator.ast;

public class Sin extends Unary{
    public Sin(SymbolicExpression expression){
        super(expression);
    }

    @Override
    public String toString(){
        return "sin(" + _expression + ")";
    }
}
