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
    public boolean equals(Object object){
        if(object instanceof Sin){
            Sin s = (Sin)object;
            return argument.equals(s.argument);
        }
        return false;
    }
    
    @Override 
    public SymbolicExpression eval(){
        SymbolicExpression arg_eval = super.argument.eval();
        if(arg_eval.isConstant()){
            return new Constant(Math.sin(arg_eval.getValue()));
        }
        return new Sin(arg_eval);
    }
}
