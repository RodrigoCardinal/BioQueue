package com.example.TestImplementacionFachada;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.ImplementacionFachada.IImpresion;
import com.example.ImplementacionFachada.Impresion;

public class ImpresionTest {

    private final ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
    private final PrintStream salidaOriginal = System.out;
    private IImpresion impresion;

    @Before
    public void setUp() {
        // Redirigimos System.out para capturar lo que se imprime
        System.setOut(new PrintStream(salidaCapturada));
        impresion = new Impresion();
    }

    @After
    public void tearDown() {
        // Restauramos System.out al original
        System.setOut(salidaOriginal);
    }

    @Test
    public void testImprimirTexto() {
        impresion.imprimir("Hola Mundo");
        assertEquals("Hola Mundo", salidaCapturada.toString());
    }

    @Test
    public void testImprimirCadenaVacia() {
        impresion.imprimir("");
        assertEquals("", salidaCapturada.toString());
    }

    @Test
    public void testImprimirConSaltoLinea() {
        impresion.imprimir("Linea 1\r\nLinea 2");
        assertEquals("Linea 1\r\nLinea 2", salidaCapturada.toString());
    }

    @Test
    public void testImprimirVariosTextos() {
        impresion.imprimir("Primer texto. ");
        impresion.imprimir("Segundo texto.");
        assertEquals("Primer texto. Segundo texto.", salidaCapturada.toString());
    }

    @Test
    public void testImprimirNoAgregaNuevaLinea() {
        // Impresion usa System.out.print, no println, por lo que NO debe agregar \n
        impresion.imprimir("Sin salto");
        assertEquals("Sin salto", salidaCapturada.toString());
        assertFalse(salidaCapturada.toString().endsWith("\n"));
    }

    @Test
    public void testImprimirCaracteresEspeciales() {
        impresion.imprimir("ñáéíóú");
        assertEquals("ñáéíóú", salidaCapturada.toString());
    }

    @Test
    public void testImprimirNumeros() {
        impresion.imprimir("12345");
        assertEquals("12345", salidaCapturada.toString());
    }

    @Test
    public void testImpresionImplementaIImpresion() {
        // Verifica que Impresion respeta el contrato de IImpresion
        assertTrue(impresion instanceof IImpresion);
    }

    @Test
    public void testImprimirMensajeFormatoBioQueue() {
        // Mensajes típicos del sistema BioQueue terminan con \r\n
        impresion.imprimir("Donante registrado correctamente.\r\n");
        assertEquals("Donante registrado correctamente.\r\n", salidaCapturada.toString());
    }

    @Test
    public void testImprimirTextoLargo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("a");
        }
        String textoLargo = sb.toString();
        impresion.imprimir(textoLargo);
        assertEquals(textoLargo, salidaCapturada.toString());
        assertEquals(1000, salidaCapturada.toString().length());
    }
}
