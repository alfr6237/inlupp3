package org.ioopm.calculator.ast;

public class Vars extends Command{
    private static final Vars INSTANCE = new Vars();

    private Vars() {
    }

    public static Vars instance() {
        return INSTANCE;
    }

    @Override
    public String toString(){
        return "Vars";
    }
}
