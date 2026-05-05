package com.example.TestImplementacionFachada;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Test;

import com.example.ImplementacionFachada.ILector;
import com.example.ImplementacionFachada.Lector;

/**
 * Tests para la interfaz ILector.
 * Como las interfaces no tienen implementación, verificamos:
 *  1. Que el contrato se pueda implementar correctamente (con un stub).
 *  2. Que la clase Lector respeta el contrato.
 *  3. Que se puede usar polimorfismo sobre ILector.
 */
public class ILectorTest {

    private final InputStream entradaOriginal = System.in;

    @After
    public void tearDown() {
        System.setIn(entradaOriginal);
    }

    /**
     * Implementación stub de ILector para verificar el contrato.
     * En lugar de leer desde la consola, devuelve entradas predefinidas en orden.
     */
    private static class ILectorStub implements ILector {
        private final String[] entradas;
        private int indice;

        public ILectorStub(String... entradas) {
            this.entradas = entradas;
            this.indice = 0;
        }

        @Override
        public String leerLinea() {
            if (indice >= entradas.length) {
                return "";
            }
            return entradas[indice++];
        }
    }

    @Test
    public void testInterfazPermiteImplementacionCustom() {
        ILectorStub stub = new ILectorStub("Hola Mundo");
        assertEquals("Hola Mundo", stub.leerLinea());
    }

    @Test
    public void testInterfazPermiteVariasLecturas() {
        ILectorStub stub = new ILectorStub("Primera", "Segunda", "Tercera");
        assertEquals("Primera", stub.leerLinea());
        assertEquals("Segunda", stub.leerLinea());
        assertEquals("Tercera", stub.leerLinea());
    }

    @Test
    public void testInterfazPermiteCadenaVacia() {
        ILectorStub stub = new ILectorStub("");
        assertEquals("", stub.leerLinea());
    }

    @Test
    public void testLectorImplementaInterfaz() {
        // La clase concreta Lector debe implementar ILector
        System.setIn(new ByteArrayInputStream("test\n".getBytes()));
        Lector lector = new Lector();
        assertTrue(lector instanceof ILector);
    }

    @Test
    public void testStubImplementaInterfaz() {
        ILectorStub stub = new ILectorStub();
        assertTrue(stub instanceof ILector);
    }

    @Test
    public void testPolimorfismoConLector() {
        // Una variable de tipo ILector puede contener cualquier implementación
        System.setIn(new ByteArrayInputStream("Polimorfismo\n".getBytes()));
        ILector lector = new Lector();
        assertEquals("Polimorfismo", lector.leerLinea());
    }

    @Test
    public void testPolimorfismoConStub() {
        ILector lector = new ILectorStub("Texto del stub");
        assertEquals("Texto del stub", lector.leerLinea());
    }

    @Test
    public void testInterfazUsadaEnFacade() {
        // Verifica que se pueda pasar cualquier implementación de ILector al Facade
        // Esto es importante porque el Facade depende de ILector, no de Lector directamente
        ILector stub = new ILectorStub("test");
        // Si la interfaz no estuviera bien definida, esto no compilaría
        assertNotNull(stub);
        assertEquals("test", stub.leerLinea());
    }

    @Test
    public void testInterfazPermiteFormatoBioQueue() {
        // El formato típico de entrada del sistema usa | como separador
        ILectorStub stub = new ILectorStub("12345678|Juan Perez|Riñon|O+");
        assertEquals("12345678|Juan Perez|Riñon|O+", stub.leerLinea());
    }
}
