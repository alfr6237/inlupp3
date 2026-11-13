package org.ioopm.calculator.ast;

public class Quit extends Command {
    private static final Quit INSTANCE = new Quit();

    private Quit() {
    }

    public static Quit instance() {
        return INSTANCE;
    }

    @Override
    public String toString(){
        return "QUIT";
    }
}
