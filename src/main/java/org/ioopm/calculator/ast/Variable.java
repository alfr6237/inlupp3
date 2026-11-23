package org.ioopm.calculator.ast;

public class Variable extends Atom {
    private final String identifier;

    public Variable(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return this.identifier;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Variable v) {
            return identifier.equals(v.toString());
        }
        return false;

    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        if (vars.containsKey(this)) {
            return vars.get(this).eval(vars);
        }
        return this;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

}
