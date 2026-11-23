package org.ioopm.calculator.ast;

public class Assignment extends Binary {
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);

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
    public SymbolicExpression eval(Environment vars) throws IllegalAssignmentException {
        if (rhs instanceof NamedConstant) {
            throw new IllegalAssignmentException("Error: Cannot assign to named constant");
        }
        vars.put((Variable) rhs, lhs);
        return lhs.eval(vars);
    }
}
