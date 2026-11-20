package org.ioopm.calculator.parser;

import java.io.IOException;

import org.ioopm.calculator.ast.Environment;
import org.ioopm.calculator.ast.SymbolicExpression;
import org.junit.jupiter.api.*;

public class ParsingTest {

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void testingParser() {
        Environment vars = new Environment();
        CalculatorParser parser = new CalculatorParser();
        try {
            SymbolicExpression exp1 = parser.parse("x + 3 = y", vars);
            try {
                SymbolicExpression epx2 = parser.parse("3 = pi", vars);
            } catch (SyntaxErrorException e) {
                System.out.println("expected exception: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}