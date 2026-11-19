package org.ioopm.calculator.ast;

public class Assignment extends Binary {
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
        assert(rhs instanceof Variable);
        
    }

    @Override
    public String getName() {
        return "=";
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Assignment a)
            return lhs.equals(a.lhs) && rhs.equals(a.rhs);
        return false;
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        vars.put((Variable)rhs, lhs);
        return lhs.eval(vars);    }
}
