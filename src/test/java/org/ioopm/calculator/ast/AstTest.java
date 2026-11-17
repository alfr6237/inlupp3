package org.ioopm.calculator.ast;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AstTest {

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void succeedingTest() {
        assertTrue(true);
    }

  
    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}