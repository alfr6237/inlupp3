package org.ioopm.calculator.ast;

public class Clear extends Command{
    private static final Clear INSTANCE = new Clear();

    private Clear() {
    }

    public static Clear instance() {
        return INSTANCE;
    }

    @Override
    public String toString(){
        return "QUIT";
    }
}
