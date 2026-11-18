package org.ioopm.calculator.ast;

public class Constant extends Atom {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public boolean isConstant(){
        return true;
    }

};
