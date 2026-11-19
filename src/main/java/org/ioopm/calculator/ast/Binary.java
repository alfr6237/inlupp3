package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
    protected SymbolicExpression lhs;
    protected SymbolicExpression rhs;

    protected Binary(SymbolicExpression lhs, SymbolicExpression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public String toString() {
        String stringToPrint = "";
        if (lhs.getPriority() > this.getPriority()) {
            stringToPrint += "(" + lhs.toString() + ")";
        } else {
            stringToPrint += lhs.toString();
        }

        stringToPrint += " " + getName() + " ";

        if (rhs.getPriority() > this.getPriority()) {
            stringToPrint += "(" + " " + rhs.toString() + ")";
        } else {
            stringToPrint += rhs.toString();
        }
        return stringToPrint;
    }


}
