package com.example.TestImplementacionFachada;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Test;

import com.example.ImplementacionFachada.ILector;
import com.example.ImplementacionFachada.Lector;

public class LectorTest {

    private final InputStream entradaOriginal = System.in;

    @After
    public void tearDown() {
        // Restauramos System.in al original después de cada test
        System.setIn(entradaOriginal);
    }


    private Lector crearLectorConEntrada(String entrada) {
        System.setIn(new ByteArrayInputStream(entrada.getBytes()));
        return new Lector();
    }

    @Test
    public void testLeerLineaSimple() {
        Lector lector = crearLectorConEntrada("Hola Mundo\n");
        assertEquals("Hola Mundo", lector.leerLinea());
    }

    @Test
    public void testLeerVariasLineas() {
        Lector lector = crearLectorConEntrada(
                "Primera linea\nSegunda linea\nTercera linea\n");
        assertEquals("Primera linea", lector.leerLinea());
        assertEquals("Segunda linea", lector.leerLinea());
        assertEquals("Tercera linea", lector.leerLinea());
    }

    @Test
    public void testLeerLineaVacia() {
        Lector lector = crearLectorConEntrada("\n");
        assertEquals("", lector.leerLinea());
    }

    @Test
    public void testLeerLineaConFormatoBioQueueDonante() {
        // Formato esperado para registrar donante: cedula|nombre|organo|tipoSangre
        Lector lector = crearLectorConEntrada("12345678|Juan Perez|Riñon|O+\n");
        assertEquals("12345678|Juan Perez|Riñon|O+", lector.leerLinea());
    }

    @Test
    public void testLeerLineaConFormatoBioQueueReceptor() {
        // Formato esperado para registrar receptor: cedula|nombre|organo|tipoSangre|dias|prioridad
        Lector lector = crearLectorConEntrada("87654321|Maria Diaz|Corazon|A+|30|1\n");
        assertEquals("87654321|Maria Diaz|Corazon|A+|30|1", lector.leerLinea());
    }

    @Test
    public void testLeerLineaConNumero() {
        Lector lector = crearLectorConEntrada("11\n");
        assertEquals("11", lector.leerLinea());
    }

    @Test
    public void testLeerLineaConNumeroNegativo() {
        // Importante: -1 es la opción de salida del menú
        Lector lector = crearLectorConEntrada("-1\n");
        assertEquals("-1", lector.leerLinea());
    }

    @Test
    public void testLeerLineaConCedula() {
        Lector lector = crearLectorConEntrada("100-200-300-1\n");
        assertEquals("100-200-300-1", lector.leerLinea());
    }

    @Test
    public void testLeerLineaConRutaArchivo() {
        Lector lector = crearLectorConEntrada("C:/Datos/Donantes.csv\n");
        assertEquals("C:/Datos/Donantes.csv", lector.leerLinea());
    }

    @Test
    public void testLectorImplementaILector() {
        Lector lector = crearLectorConEntrada("test\n");
        assertTrue(lector instanceof ILector);
    }

    @Test
    public void testLeerLineaPolimorfismo() {
        // Verifica que se pueda usar Lector a través de la interfaz ILector
        ILector lector = crearLectorConEntrada("Polimorfismo\n");
        assertEquals("Polimorfismo", lector.leerLinea());
    }
}
