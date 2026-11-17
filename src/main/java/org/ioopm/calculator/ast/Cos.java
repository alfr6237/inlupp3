package org.ioopm.calculator.ast;

public class Cos extends Unary{
    public Cos(SymbolicExpression expression){
        super(expression);
    }

    @Override
    public String getName(){
        return "cos";
    }
}
