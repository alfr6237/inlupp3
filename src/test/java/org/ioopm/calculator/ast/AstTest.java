package org.ioopm.calculator.ast;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class AstTest {

    public void testPrinting(String expected, SymbolicExpression e) {
        assertEquals(expected.toString(), e.toString());
        // if (expected.equals("" + e)) {
        //     System.out.println("Passed: " + e);
        // } else {
        //     System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        // }
    }

    public void testEvaluating(SymbolicExpression expected, SymbolicExpression e, Environment vars) {
        assertEquals(expected.eval(vars), e.eval(vars));
        // if (r.equals(expected)) {
        //     System.out.println("Passed: " + e);
        // } else {
        //     System.out.println("Error: expected '" + expected + "' but got '" + r + "'");
        // }
    }

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void simpleAst() {
        Constant c1 = new Constant(5);
        Constant c2 = new Constant(2);
        Variable v = new Variable("x");
        Addition a = new Addition(c1, v);
        Multiplication m = new Multiplication(a, c2);
        testPrinting("(5 + x) * 2", m);

        Environment vars = new Environment();
        Constant expected = new Constant(26);
        vars.put(v, new Constant(8));
        testEvaluating(expected, m, vars);
    }

    @Test
    void divisionAst() {
        Constant d1 = new Constant(4);
        Constant d2 = new Constant(2);
        Division division = new Division(d1, d2);
        Constant result = new Constant(2);
        Environment vars = new Environment();

        testPrinting("4 / 2", division);
        testEvaluating(result, division, vars);
    }

    @Test
    void constantAst() {
        Constant c = new Constant(42);
        testPrinting("42", c);

        Constant d = new Constant(42.24);
        testPrinting("42.24", d);
    }

    @Test
    void expAst() {
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
        Environment vars = new Environment();

        testPrinting("5 - 1", sub);
        testEvaluating(result, sub, vars);
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
        Environment vars = new Environment();
        testEvaluating(expected, a, vars); // tests if reducing a returns b (it should!)
    }

    @Test
    void evalVars() {
        Variable x1 = new Variable("x");
        Variable x2 = new Variable("x");
        Environment vars = new Environment();

        testEvaluating(x1, x2, vars);
    }

    @Test
    void evalMultDiv() {
        Constant a = new Constant(2);
        Constant b = new Constant(8);

        Multiplication m = new Multiplication(a, a);
        Division d = new Division(b, a);

        Constant expected = new Constant(4);
        Environment vars = new Environment();

        testEvaluating(expected, d, vars);
        testEvaluating(expected, m, vars);

    }

    @Test
    void evalMultiplication() {
        Constant multiplicand = new Constant(2);
        Constant multiplier = new Constant(8);
        Multiplication product = new Multiplication(multiplicand, multiplier);
        Constant expected = new Constant(16);
        Environment vars = new Environment();

        testEvaluating(expected, product, vars);

    }

    @Test
    void evalVariable() {

        Addition a = new Addition(new Constant(2), new Constant(3));
        Variable x = new Variable("x");

        Constant expected = new Constant(5);
        Environment vars = new Environment();
        //vars.put(x, a);
        Assignment assign = new Assignment(a, x);

        testEvaluating(expected, assign, vars);
        Variable x2 = new Variable("x");
        Variable y = new Variable("y");
    }

    @Test
    void evalSinCosLog() {
        Sin sin90 = new Sin(new Constant(Math.PI / 2));
        Cos cos90 = new Cos(new Constant(Math.PI / 2));
        Log logE = new Log(new Constant(Math.E));
        Environment vars = new Environment();
        testEvaluating(new Constant(1), sin90, vars);
        testEvaluating(new Constant(0), cos90, vars);
        testEvaluating(new Constant(1), logE, vars);
    }

    @Test
    void illegalAssignment() {
        Environment vars = new Environment();

        NamedConstant PI = new NamedConstant("pi", Math.PI);
        Constant three = new Constant(3);
        Assignment a = new Assignment(three, PI);

        try {
            a.eval(vars);
            System.out.println("expected exception not thrown");
        } catch (IllegalAssignmentException e) {
            System.out.println("expected exception: " + e.getMessage());
        }
    }


    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}