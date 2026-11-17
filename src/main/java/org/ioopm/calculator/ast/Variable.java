package org.ioopm.calculator.ast;

public class Variable extends Atom {
    private final String _identifier;

    public Variable(String identifier) {
        this._identifier = identifier;
    }

}
