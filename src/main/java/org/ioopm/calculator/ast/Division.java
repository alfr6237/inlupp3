package org.ioopm.calculator.ast;

public class Division extends Binary {
    public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "/";
    }

    @Override 
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Division)
            return lhs.equals(object) && rhs.equals(object);
        return false;
    }

    @Override
    public SymbolicExpression eval(){
        SymbolicExpression rhs_eval = rhs.eval();
        SymbolicExpression lhs_eval = lhs.eval();
        if(lhs_eval.isConstant() && rhs_eval.isConstant()){
            Constant l = (Constant)lhs_eval;
            Constant r = (Constant)rhs_eval;
            return new Constant(l.getValue() / r.getValue());
        } 
        return new Division(lhs_eval.eval(), rhs_eval.eval());
    }

    
}
