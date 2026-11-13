package org.ioopm.calculator.ast;

public class Constant extends Atom {
    private final double _value;

    public Constant(double value) {
        _value = value;
    }


    @Override
    public String toString() {
        return Double.toString(_value);
    }


};
