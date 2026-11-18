package org.ioopm.calculator.ast;

public class Sin extends Unary {
    public Sin(SymbolicExpression expression) {
        super(expression);
    }

    @Override
    public String getName() {
        return "sin";
    }

    @Override 
    public boolean equals(Object object){
        if(object instanceof Sin){
            Sin s = (Sin)object;
            return super.argument == s.argument;
        }
        return false;
            
    }
}
