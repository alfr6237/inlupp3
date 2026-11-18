package org.ioopm.calculator.ast;

public class Cos extends Unary{
    public Cos(SymbolicExpression expression){
        super(expression);
    }

    @Override
    public String getName(){
        return "cos";
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Cos) {
            Cos c= (Cos) object;
            return super.argument == c.argument;
        }
        return false;
    }
}
