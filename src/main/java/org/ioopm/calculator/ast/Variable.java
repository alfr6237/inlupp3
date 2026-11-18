package org.ioopm.calculator.ast;

public class Variable extends Atom {
    private final String identifier;

    public Variable(String identifier) {
        this.identifier = identifier;
    }

    @Override 
    public String toString(){
        return this.identifier;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Variable) {
            String s = object.toString();
            if (identifier.equals(s)) {
                return true;
            }
        }
        return false;

    }

}
