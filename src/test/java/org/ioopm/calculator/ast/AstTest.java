package org.ioopm.calculator.ast;

import org.ioopm.calculator.ast.*;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AstTest {
    
    public void testPrinting(String expected, SymbolicExpression e) {
        // assertTrue(expected.equals("" + e));
        if (expected.equals("" + e)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }

    public void testEvaluating(SymbolicExpression expected, SymbolicExpression e) {
        SymbolicExpression r = e.eval();
        if (r.equals(expected)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }
    
    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void simpleAst(){
        Constant c1 = new Constant(5);
        Constant c2 = new Constant(2);
        Variable v = new Variable("x");
        Addition a = new Addition(c1, v);
        Multiplication m = new Multiplication(a, c2);
        
        testPrinting("(5 + x) * 2", m);
    }

    @Test 
    void divisionAst() {
        Constant d1 = new Constant(4);
        Constant d2 = new Constant(2);
        Division division = new Division(d1, d2);
        Constant result = new Constant(2);
        
        testPrinting("4 / 2", division);
        testEvaluating(division, result);
    }

    @Test 
    void constantAst(){
        Constant c = new Constant(42);
        testPrinting("42", c);
        
        Constant d = new Constant(42.24);
        testPrinting("42.24", d);
    }

    @Test 
    void expAst(){
        Constant c = new Constant(42);
        Exp e1 = new Exp(c);
        Exp e2 = new Exp(e1);
        
        testPrinting("e^e^42", e2);
    }
    
    @Test 
    void unaryAst() {
        Constant c = new Constant(42);
        Sin s = new Sin(c);
        Cos cos = new Cos(s);
        Log l = new Log(cos);
        
        testPrinting("log(cos(sin(42)))", l);
    }
    
    @Test
    void subtractionAst() {
        Constant f1 = new Constant(5);
        Constant f2 = new Constant(1);
        Subtraction sub = new Subtraction(f1, f2);
        Constant result = new Constant(4);
        
        testPrinting("5 - 1", sub);
        testEvaluating(sub, result);
    }

    @Test
    void negationAst() {
        Constant g = new Constant(9);
        Negation neg = new Negation(g);

        testPrinting("-(9)", neg);
    }

    @Test 
    void assignmentAst() {
        Constant h = new Constant(10);
        Variable y = new Variable("y"); 
        Assignment yValue = new Assignment(y, h);

        testPrinting("y = 10", yValue);
    }

    @Test
    void evaluatingAst() {
        SymbolicExpression a = new Addition(new Constant(5), new Constant(37));
        SymbolicExpression b = new Constant(42);
        testEvaluating(b, a); // tests if reducing a returns b (it should!)
    }

    @Test 
    void evalVars(){
        Variable x1 = new Variable("x");
        
        Variable x2 = new Variable("x");
        testEvaluating(x1, x2);
    }

    @Test
    void evalMultDiv(){
        Constant a = new Constant(2);
        Constant b = new Constant(8);

        Multiplication m = new Multiplication(a, a);
        Division d = new Division(b, a);
        
        testEvaluating(d, m);
        
    }

    @Test 
    void evalMultiplication() {
        Constant multiplicand = new Constant(2);
        Constant multiplier = new Constant(8);
        Multiplication product = new Multiplication(multiplicand, multiplier);
        Constant result = new Constant(16);
        
        testEvaluating(product, result);     
    }
    
    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}