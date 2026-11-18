package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression{
    protected final SymbolicExpression argument;

    public Unary(SymbolicExpression argument){
        this.argument = argument;
    }

    @Override 
    public int getPriority() {
        return 2;
    }

    @Override 
    public String toString(){
        return this.getName() + "(" + argument.toString() + ")";
    }

    
}