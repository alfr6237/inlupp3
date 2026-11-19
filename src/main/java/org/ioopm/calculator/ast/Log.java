package org.ioopm.calculator.ast;

public class Log extends Unary {
    public Log(SymbolicExpression expression) {
        super(expression);
    }

    @Override
    public String getName() {
        return "log";
    }

    @Override 
    public boolean equals(Object object){
        if(object instanceof Log){
            Log l = (Log)object;
            return super.argument == l.argument;
        }
        return false;
    }

    @Override 
    public SymbolicExpression eval(Environment vars){
        SymbolicExpression arg_eval = super.argument.eval(vars);
        if(arg_eval.isConstant()){
            return new Constant(Math.log(arg_eval.getValue()));
        }
        return new Log(arg_eval);
    }
}
