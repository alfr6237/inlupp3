package org.ioopm.calculator.ast;

public class Clear extends Command {
    private static final Clear theInstnance = new Clear();

    private Clear() {
    }

    public static Clear instance() {
        return theInstnance;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Clear;
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        return theInstnance;
    }

}
