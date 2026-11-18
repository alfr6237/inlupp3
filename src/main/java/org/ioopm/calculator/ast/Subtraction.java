package org.ioopm.calculator.ast;

public class Subtraction extends Binary {
    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "-";
    }

    @Override 
    public int getPriority() {
        return 4;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Subtraction)
            return lhs.equals(object) && rhs.equals(object);
        return false;
    }
}
