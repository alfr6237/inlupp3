package org.ioopm.calculator;

import java.io.IOException;

import org.ioopm.calculator.ast.Environment;
import org.ioopm.calculator.ast.SymbolicExpression;
import org.ioopm.calculator.parser.CalculatorParser;

public class Calculator {

    
    public static void main(String[] args){
        final Environment vars = new Environment();
        final CalculatorParser parser = new CalculatorParser();

        
        while(true){
            String input = System.console().readLine();
            try { 
                SymbolicExpression expression = parser.parse(input, vars);
                if(expression.isCommand())

            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        
    }
}
