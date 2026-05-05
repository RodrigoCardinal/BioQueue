package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AnalisisDeSangreTests {
    
    private AnalisisDeSangre analisis;
    
    @Before
    public void setUp() {
        analisis = new AnalisisDeSangre();
    }

@Test
    public void testAPositivoCompConANegativo() {
        assertTrue(analisis.esCompatible("A+", "A-"));
    }

    @Test
    public void testAPositivoIncompConBPositivo() {
        assertFalse(analisis.esCompatible("A+", "B+"));
    }

    @Test
    public void testOPositivoCompConONegativo() {
        assertTrue(analisis.esCompatible("O+", "O-"));
    }

    @Test
    public void testOPositivoCompConOPositivo() {
        assertTrue(analisis.esCompatible("O+", "O+"));
    }

    @Test
    public void testOPositivoIncompConAPositivo() {
        assertFalse(analisis.esCompatible("O+", "A+"));
    }
    @Test
    public void testONegativoCompConONegativo() {
        assertTrue(analisis.esCompatible("O-", "O-"));
    }

    @Test
    public void testONegativoIncompConOPositivo() {
        assertFalse(analisis.esCompatible("O-", "O+"));
    }
    
    @Test
    public void testABPositivoCompConTodos() {
        assertTrue(analisis.esCompatible("AB+", "O-"));
        assertTrue(analisis.esCompatible("AB+", "O+"));
        assertTrue(analisis.esCompatible("AB+", "A-"));
        assertTrue(analisis.esCompatible("AB+", "A+"));
        assertTrue(analisis.esCompatible("AB+", "B-"));
        assertTrue(analisis.esCompatible("AB+", "B+"));
        assertTrue(analisis.esCompatible("AB+", "AB-"));
        assertTrue(analisis.esCompatible("AB+", "AB+"));
    }

    @Test
    public void testONegativoDonanteCompConTodos() {
        assertTrue(analisis.esCompatible("O-",  "O-"));
        assertTrue(analisis.esCompatible("O+",  "O-"));
        assertTrue(analisis.esCompatible("A-",  "O-"));
        assertTrue(analisis.esCompatible("A+",  "O-"));
        assertTrue(analisis.esCompatible("B-",  "O-"));
        assertTrue(analisis.esCompatible("B+",  "O-"));
        assertTrue(analisis.esCompatible("AB-", "O-"));
        assertTrue(analisis.esCompatible("AB+", "O-"));
    }

}
