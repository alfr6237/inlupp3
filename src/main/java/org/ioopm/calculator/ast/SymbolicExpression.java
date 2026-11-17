
package org.ioopm.calculator.ast;

public abstract class SymbolicExpression {

    public boolean isConstant(){
        return false;
    }
    public  String getName() throws RuntimeException{
        throw new RuntimeException("getName() called on expression with no operator");
    }
}






