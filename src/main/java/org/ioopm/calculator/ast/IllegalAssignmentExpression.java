package org.ioopm.calculator.ast;

public class IllegalAssignmentExpression extends RuntimeException {
    public IllegalAssignmentExpression(){
        super();
    }

    public IllegalAssignmentExpression(String msg){
        super(msg);
    }
}
