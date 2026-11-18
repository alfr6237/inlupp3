package org.ioopm.calculator.ast;

public abstract class SymbolicExpression {

    protected int _priority;

    public SymbolicExpression() {
        _priority = 1;
    }

    public boolean isConstant() {
        return false;
    }
    
    public  String getName() throws RuntimeException{
        throw new RuntimeException("getName() called on expression with no operator");
    }

    public int getPriority() {
        return _priority;
    }
}






