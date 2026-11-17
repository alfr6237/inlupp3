package org.ioopm.calculator.ast;

public class Constant extends Atom {
    private final double _value;

    public Constant(double value) {
        _value = value;
    }

    @Override
    public boolean isConstant(){
        return true;
    }




};
