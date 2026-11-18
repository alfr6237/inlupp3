package org.ioopm.calculator.ast;

public class Negation extends Unary {

    public Negation(SymbolicExpression expression) {
        super(expression);
    }

    @Override
    public String getName() {
        return "-";
    }

    @Override 
    public boolean equals(Object object){
        if(object instanceof Negation){
            Negation l = (Negation)object;
            return super.argument == l.argument;
        }
        return false;
    }
}
