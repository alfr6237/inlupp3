package org.ioopm.calculator.ast;

public class Sin extends Unary {
    public Sin(SymbolicExpression expression) {
        super(expression);
    }

    @Override
    public String getName() {
        return "sin";
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Sin s) {
            return argument.equals(s.argument);
        }
        return false;
    }

    @Override 
    public SymbolicExpression eval(Environment vars){
    SymbolicExpression arg = super.argument.eval(vars);
    if (arg.isConstant()) {
        return new Constant(Math.sin(arg.getValue()));
    } else {
        return new Sin(arg);
    }
}
}
