package org.ioopm.calculator.ast;

public class Assignment extends Binary {
    public Assignment(SymbolicExpression a, SymbolicExpression b) {
        super(a, b);
    }

    @Override
    public String getName() {
        return "=";
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Assignment)
            return lhs.equals(object) && rhs.equals(object);
        return false;
    }

    @Override 
    public SymbolicExpression eval(){
        return new Assignment(lhs.eval(), rhs);
    }
}
