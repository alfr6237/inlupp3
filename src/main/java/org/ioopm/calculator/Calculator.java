package org.ioopm.calculator;

import java.io.IOException;


import org.ioopm.calculator.ast.Environment;
import org.ioopm.calculator.ast.IllegalAssignmentException;
import org.ioopm.calculator.ast.Quit;
import org.ioopm.calculator.ast.SymbolicExpression;
import org.ioopm.calculator.ast.Variable;
import org.ioopm.calculator.ast.Vars;
import org.ioopm.calculator.parser.CalculatorParser;
import org.ioopm.calculator.parser.IllegalExpressionException;
import org.ioopm.calculator.parser.SyntaxErrorException;
import org.ioopm.calculator.ast.Assignment;
import org.ioopm.calculator.ast.Clear;

public class Calculator {

    public static void main(String[] args) {
        final Environment vars = new Environment();
        final CalculatorParser parser = new CalculatorParser();
        System.out.println("Welcome to the parser!");
        int expressionsEntered = 0;
        int succesfullyEvaluated = 0;
        int fullyEvaluated = 0;

        while (true) {
            System.out.print("Please enter an expression: ");
            String input = System.console().readLine();
            Variable ans = new Variable("ans");
            try {
                SymbolicExpression expression = parser.parse(input, vars);
                
                if (expression.isCommand()) {
                    if (expression.equals(Quit.instance())) {
                        System.out.println("Goodbye! Here is information about the expressions entered");
                        System.out.println("Expressions entered: " + (expressionsEntered + 1));
                        System.out.println("Successfully evaluated: " + succesfullyEvaluated);
                        System.out.println("Could be fully evaluated: " + fullyEvaluated);
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
                    SymbolicExpression eval = expression.eval(vars);
                    Assignment assign = new Assignment(eval, ans);
                    System.out.println(eval);        
                    succesfullyEvaluated++;   
                    if(eval.isConstant()){
                        fullyEvaluated++;
                    }        
                }
                
            } catch (IOException | IllegalAssignmentException | SyntaxErrorException | IllegalExpressionException e) {
                System.out.println(e.getMessage());
            } 
            expressionsEntered++; 
        }

    }
}
