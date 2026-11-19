package org.ioopm.calculator.ast;

public class Negation extends Unary {

    public Negation(SymbolicExpression expression) {
        super(expression);
    }

    @Override
    public String getName() {
        return "-";
    }

    @Override 
    public boolean equals(Object object){
        if(object instanceof Negation){
            Negation l = (Negation)object;
            return super.argument == l.argument;
        }
        return false;
    }

    @Override 
    public SymbolicExpression eval(Environment vars){
        SymbolicExpression arg_eval = super.argument.eval(vars);
        if(arg_eval.isConstant()){
            return new Constant(arg_eval.getValue());
        }
        return new Negation(arg_eval);
    }
}
