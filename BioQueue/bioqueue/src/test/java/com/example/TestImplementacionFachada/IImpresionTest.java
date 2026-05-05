package com.example.TestImplementacionFachada;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.ImplementacionFachada.IImpresion;
import com.example.ImplementacionFachada.Impresion;

/**
 * Tests para la interfaz IImpresion.
 * Como las interfaces no tienen implementación, verificamos:
 *  1. Que el contrato se pueda implementar correctamente (con un stub).
 *  2. Que la clase Impresion respeta el contrato.
 *  3. Que se puede usar polimorfismo sobre IImpresion.
 */
public class IImpresionTest {

    /**
     * Implementación stub de IImpresion para verificar el contrato.
     * En lugar de imprimir por consola, almacena el texto en un buffer.
     */
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
        // La clase concreta Impresion debe implementar IImpresion
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
        // Una variable de tipo IImpresion puede contener cualquier implementación
        IImpresion impresion = new Impresion();
        assertNotNull(impresion);
    }

    @Test
    public void testPolimorfismoConStub() {
        IImpresion impresion = new IImpresionStub();
        impresion.imprimir("Texto polimórfico");
        // Hacemos cast para acceder al método propio del stub
        assertEquals("Texto polimórfico", ((IImpresionStub) impresion).getTextoImpreso());
    }

    @Test
    public void testInterfazPermiteImprimirCaracteresEspeciales() {
        IImpresionStub stub = new IImpresionStub();
        stub.imprimir("ñáéíóú ÑÁÉÍÓÚ");
        assertEquals("ñáéíóú ÑÁÉÍÓÚ", stub.getTextoImpreso());
    }
}
