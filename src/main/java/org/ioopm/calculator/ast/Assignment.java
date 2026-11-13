package org.ioopm.calculator.ast;

public class Assignment extends Binary{
    public Assignment(Constant constant, Variable variable){
        super(constant, variable);
    }
    @Override
    public String toString(){

    }
}
