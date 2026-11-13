package org.ioopm.calculator.ast;

public class Addition extends Binary{

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs){
        super(lhs, rhs);
    }
    @Override
    public String toString(){
        return _lhs + " + " + _rhs;
    }
}
