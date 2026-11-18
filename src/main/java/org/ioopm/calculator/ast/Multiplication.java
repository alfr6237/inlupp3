package org.ioopm.calculator.ast;

public class Multiplication extends Binary {
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "*";
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Multiplication)
            return lhs.equals(object) && rhs.equals(object);

        return false;
    }
}
