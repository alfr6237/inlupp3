package org.ioopm.calculator.ast;

public class Exp extends Unary {
    public Exp(SymbolicExpression expression) {
        super(expression);
    }

    @Override
    public String getName() {
        return "^";
    }

    @Override
    public String toString() {
        return "e^" + super.argument;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Exp) {
            Exp e = (Exp) object;
            return super.argument == e.argument;
        }
        return false;
    }

    @Override 
    public SymbolicExpression eval(){
        SymbolicExpression arg_eval = super.argument.eval();
        if(arg_eval.isConstant()){
            return new Constant(Math.exp(arg_eval.getValue()));
        }
        return new Exp(arg_eval);
    }

}
