package org.ioopm.calculator.ast;


public class NamedConstant extends Constant {
    private final String name;

    public NamedConstant(String name, double value) {
        super(value);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    

}