package org.ioopm.calculator.ast;

public class Negation extends Unary{

    public Negation(SymbolicExpression expression){
        super(expression);
    }

    @Override
    public String toString(){
        return "-" + _expression;
    }
}
