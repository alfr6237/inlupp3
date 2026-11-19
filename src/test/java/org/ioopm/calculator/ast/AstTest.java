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
        testEvaluating(result, division);
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
        testEvaluating(result, sub);
    }

    @Test
    void negationAst() {
        Constant g = new Constant(9);
        Negation neg = new Negation(g);

        testPrinting("-(9)", neg);
    }

    @Test 
    void assignmentAst() {
        Constant c = new Constant(10);
        Variable y = new Variable("y"); 
        Assignment yValue = new Assignment(c, y);

        testPrinting("10 = y", yValue);
    }

    @Test
    void evaluatingAst() {
        SymbolicExpression a = new Addition(new Constant(5), new Constant(37));
        SymbolicExpression expected = new Constant(42);
        testEvaluating(expected, a); // tests if reducing a returns b (it should!)
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

        Constant expected = new Constant(4);
        
        testEvaluating(expected, d);
        testEvaluating(expected, m);
        
    }

    @Test 
    void evalMultiplication() {
        Constant multiplicand = new Constant(2);
        Constant multiplier = new Constant(8);
        Multiplication product = new Multiplication(multiplicand, multiplier);
        Constant expected = new Constant(16);
        
        testEvaluating(expected, product);     
    }


    @Test
    void evalVariable(){

        Addition a = new Addition(new Constant(2), new Constant(3));
        Variable x = new Variable("x");
        Constant expected = new Constant(5);


        testEvaluating(expected, x);    
    
    }

    @Test 
    void evalSinCosLog() {
        Sin sin90 = new Sin(new Constant(Math.PI/2));
        Cos cos90 = new Cos(new Constant(Math.PI/2));
        Log logE = new Log(new Constant(Math.E));
        testEvaluating(new Constant(1), sin90);
        testEvaluating(new Constant(0), cos90);
        testEvaluating(new Constant(1), logE);        
    }
    
    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}