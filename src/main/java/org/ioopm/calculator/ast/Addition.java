package org.ioopm.calculator.ast;

public class Addition extends Binary {

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "+";
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Addition a)
            return lhs.equals(a.lhs) && rhs.equals(a.rhs);
        return false;
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression rhs_eval = rhs.eval(vars);
        SymbolicExpression lhs_eval = lhs.eval(vars);
        if (lhs_eval.isConstant() && rhs_eval.isConstant()) {
            Constant l = (Constant) lhs_eval;
            Constant r = (Constant) rhs_eval;
            return new Constant(l.getValue() + r.getValue());
        }
        return new Addition(lhs_eval, rhs_eval);

    }
}
