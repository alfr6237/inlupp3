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
        if (object instanceof Division d)
            return lhs.equals(d.lhs) && rhs.equals(d.rhs);
        return false;
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression rhs_eval = rhs.eval(vars);
        SymbolicExpression lhs_eval = lhs.eval(vars);
        if (lhs_eval.isConstant() && rhs_eval.isConstant()) {
            Constant l = (Constant) lhs_eval;
            Constant r = (Constant) rhs_eval;
            return new Constant(l.getValue() / r.getValue());
        }
        return new Division(lhs_eval, rhs_eval);
    }


}
