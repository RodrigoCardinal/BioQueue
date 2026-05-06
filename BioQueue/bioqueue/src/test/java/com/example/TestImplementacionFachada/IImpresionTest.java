package com.example.TestImplementacionFachada;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.ImplementacionFachada.IImpresion;
import com.example.ImplementacionFachada.Impresion;

public class IImpresionTest {
    private static class IImpresionStub implements IImpresion {
        private final StringBuilder textoImpreso = new StringBuilder();

        @Override
        public void imprimir(String s) {
            textoImpreso.append(s);
        }

        public String getTextoImpreso() {
            return textoImpreso.toString();
        }
    }

    @Test
    public void testInterfazPermiteImplementacionCustom() {
        IImpresionStub stub = new IImpresionStub();
        stub.imprimir("Hola Mundo");
        assertEquals("Hola Mundo", stub.getTextoImpreso());
    }

    @Test
    public void testInterfazPermiteVariasImpresiones() {
        IImpresionStub stub = new IImpresionStub();
        stub.imprimir("Linea 1.\r\n");
        stub.imprimir("Linea 2.\r\n");
        stub.imprimir("Linea 3.\r\n");
        assertEquals("Linea 1.\r\nLinea 2.\r\nLinea 3.\r\n", stub.getTextoImpreso());
    }

    @Test
    public void testInterfazPermiteImprimirCadenaVacia() {
        IImpresionStub stub = new IImpresionStub();
        stub.imprimir("");
        assertEquals("", stub.getTextoImpreso());
    }

    @Test
    public void testImpresionImplementaInterfaz() {
        Impresion impresion = new Impresion();
        assertTrue(impresion instanceof IImpresion);
    }

    @Test
    public void testStubImplementaInterfaz() {
        IImpresionStub stub = new IImpresionStub();
        assertTrue(stub instanceof IImpresion);
    }

    @Test
    public void testPolimorfismoConImpresion() {
        IImpresion impresion = new Impresion();
        assertNotNull(impresion);
    }

    @Test
    public void testPolimorfismoConStub() {
        IImpresion impresion = new IImpresionStub();
        impresion.imprimir("Texto polimórfico");
        assertEquals("Texto polimórfico", ((IImpresionStub) impresion).getTextoImpreso());
    }

    @Test
    public void testInterfazPermiteImprimirCaracteresEspeciales() {
        IImpresionStub stub = new IImpresionStub();
        stub.imprimir("ñáéíóú ÑÁÉÍÓÚ");
        assertEquals("ñáéíóú ÑÁÉÍÓÚ", stub.getTextoImpreso());
    }
}
