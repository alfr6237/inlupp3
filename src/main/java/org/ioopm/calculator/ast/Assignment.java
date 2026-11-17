package org.ioopm.calculator.ast;

public class Assignment extends Binary {
    public Assignment(SymbolicExpression a, SymbolicExpression b) {
        super(a, b);
    }

    @Override
    public String getName() {
        return "=";
    }
}
