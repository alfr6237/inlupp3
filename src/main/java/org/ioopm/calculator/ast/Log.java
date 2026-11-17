package org.ioopm.calculator.ast;

public class Log extends Unary {
    public Log(SymbolicExpression expression) {
        super(expression);
    }

    @Override
    public String getName() {
        return "log";
    }
}
