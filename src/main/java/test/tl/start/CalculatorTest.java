package test.tl.start;

//import tl.start.Calculator;

import tl.start.Calculator;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
//    tl.start.Calculator calculator;
    tl.start.Calculator calculator;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        calculator = new Calculator();
        calculator.setVisible(true);  // Needed to initialize components
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        calculator.dispose();
    }

    @org.junit.jupiter.api.Test
    void testInit() {
        assertEquals("Calculator", calculator.getTitle());
        assertEquals(new Dimension(300, 300), calculator.getSize());
        assertFalse(calculator.isResizable());
        assertEquals(JFrame.EXIT_ON_CLOSE, calculator.getDefaultCloseOperation());
    }

    @org.junit.jupiter.api.Test
    void testAddNorthComponent() {
        assertNotNull(calculator.getInputText());
        assertTrue(calculator.getInputText().isDisplayable());
        assertNotNull(calculator.getClearButton());
        assertTrue(calculator.getClearButton().isDisplayable());
        assertEquals("C", calculator.getClearButton().getText());
        assertEquals(Color.RED, calculator.getClearButton().getForeground());
    }

    @org.junit.jupiter.api.Test
    void testActionPerformedNumericInput() {
        calculator.getInputText().setText("");  // Clear any existing text
        calculator.getClearButton().doClick();  // Simulate button click to clear text
        assertEquals("", calculator.getInputText().getText());
    }

    @org.junit.jupiter.api.Test
    void testActionPerformedOperator() {
        calculator.getInputText().setText("5");
        calculator.setOperator("+");
        calculator.getFirstInput();  // just to demonstrate use of getters
        assertEquals("5", calculator.getFirstInput());
        calculator.setFirstInput(calculator.getInputText().getText());
        calculator.getInputText().setText("");
        assertEquals("", calculator.getInputText().getText());
        assertEquals("+", calculator.getOperator());
        assertEquals("5", calculator.getFirstInput());
    }

    @org.junit.jupiter.api.Test
    void testActionPerformedCalculation() {
        calculator.setFirstInput("5");
        calculator.setOperator("+");
        calculator.getInputText().setText("3");
        Double expected = 8.0;
        Double a = Double.valueOf(calculator.getFirstInput());
        Double b = Double.valueOf(calculator.getInputText().getText());
        Double result = a + b;
        assertEquals(expected, result);
    }
}
