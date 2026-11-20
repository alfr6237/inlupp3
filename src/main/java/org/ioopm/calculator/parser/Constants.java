package org.ioopm.calculator.parser;

import java.util.HashMap;

public class Constants {
    public static final HashMap<String, Double> namedConstants = new HashMap<>();

    static {
        namedConstants.put("pi", Math.PI);
        namedConstants.put("e", Math.E);
        namedConstants.put("Answer", 42.0);
        namedConstants.put("L", 6.022140857 * Math.pow(10, 23));
    }
}