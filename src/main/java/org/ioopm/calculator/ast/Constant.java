package org.ioopm.calculator.ast;

import java.text.DecimalFormat;

public class Constant extends Atom {
    private final double value;
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return df.format(this.value);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Constant) {
            Constant c = (Constant) object;
            if (c.value == this.value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public SymbolicExpression eval(){
        return this;
    }    

};
