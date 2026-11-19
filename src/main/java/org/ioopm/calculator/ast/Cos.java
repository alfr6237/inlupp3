package org.ioopm.calculator.ast;

public class Cos extends Unary {
    public Cos(SymbolicExpression expression) {
        super(expression);
    }

    @Override
    public String getName() {
        return "cos";
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Cos c) {
            return argument.equals(c.argument);
        }
        return false;
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg_eval = super.argument.eval(vars);
        if (arg_eval.isConstant()) {
            return new Constant(Math.cos(arg_eval.getValue()));
        }
        return new Cos(arg_eval);
    }
}
