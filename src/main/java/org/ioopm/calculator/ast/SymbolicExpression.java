package org.ioopm.calculator.ast;

public abstract class SymbolicExpression {


    public boolean isConstant() {
        return false;
    }

    public boolean isCommand() {
        return false;
    }

    public String getName() throws RuntimeException {
        throw new RuntimeException("getName() called on expression with no operator");
    }

    public int getPriority() {
        return 1;
    }

    public double getValue() {
        throw new RuntimeException("getValue called on expression that is not constant");
    }

    public abstract boolean equals(Object object);

    public abstract SymbolicExpression eval(Environment vars) throws IllegalAssignmentException;

}






