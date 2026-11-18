package org.ioopm.calculator.ast;

public class Division extends Binary {
    public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "/";
    }

    @Override 
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Division)
            return lhs.equals(object) && rhs.equals(object);
        return false;
    }
}
