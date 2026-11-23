package org.ioopm.calculator;

import java.io.IOException;
import java.util.Queue;

import org.ioopm.calculator.ast.Environment;
import org.ioopm.calculator.ast.Quit;
import org.ioopm.calculator.ast.SymbolicExpression;
import org.ioopm.calculator.ast.Vars;
import org.ioopm.calculator.parser.CalculatorParser;
import org.ioopm.calculator.ast.Clear;

public class Calculator {

    public static void main(String[] args) {
        final Environment vars = new Environment();
        final CalculatorParser parser = new CalculatorParser();

        while (true) {
            String input = System.console().readLine();
            try {
                SymbolicExpression expression = parser.parse(input, vars);
                if (expression.isCommand()) {
                    if (expression.equals(Quit.instance())) {
                        break;
                    }
                    if (expression.equals(Vars.instance())) {
                        vars.forEach((k, v) -> {
                            System.out.println(v + " = " + k);
                        });
                    }
                    if (expression.equals(Clear.instance())) {
                        vars.clear();
                    }
                } else {

                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
