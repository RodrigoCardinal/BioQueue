package com.example.TestImplementacionFachada;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.ImplementacionFachada.Facade;
import com.example.ImplementacionFachada.ILector;

public class FacadeTest {

    private Facade facade;

    /**
     * Mock de ILector que devuelve entradas predefinidas en orden,
     * simulando lo que un usuario escribiría por consola.
     */
    private static class LectorMock implements ILector {
        private final String[] entradas;
        private int indice;

        public LectorMock(String... entradas) {
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

    // ============================================================
    // MENU
    // ============================================================

    @Test
    public void testMostrarMenu() {
        facade = new Facade(new LectorMock());
        String menu = facade.mostrarMenu();
        assertNotNull(menu);
        assertTrue(menu.contains("-1"));
        assertTrue(menu.contains("registrar un donante"));
        assertTrue(menu.contains("registrar un receptor"));
        assertTrue(menu.contains("trasplantes"));
    }

    @Test
    public void testMostrarMenuContieneTodasLasOpciones() {
        facade = new Facade(new LectorMock());
        String menu = facade.mostrarMenu();
        // Debe contener las 12 opciones del menú
        for (int i = 1; i <= 12; i++) {
            assertTrue("El menú debe contener la opción " + i,
                    menu.contains("Ingrese " + i));
        }
    }

    // ============================================================
    // DONANTES
    // ============================================================

    @Test
    public void testRegistrarDonanteCorrecto() {
        facade = new Facade(new LectorMock("12345678|Juan Perez|Riñon|O+"));
        String resultado = facade.registrarDonante();
        assertTrue(resultado.toLowerCase().contains("correctamente"));
    }

    @Test
    public void testRegistrarDonanteFormatoIncorrecto() {
        facade = new Facade(new LectorMock("datos_mal_formados"));
        String resultado = facade.registrarDonante();
        assertTrue(resultado.toLowerCase().contains("error"));
    }

    @Test
    public void testBuscarDonanteEncontrado() {
        facade = new Facade(new LectorMock(
                "12345678|Juan Perez|Riñon|O+",  // input para registrar
                "12345678"                        // input para buscar
        ));
        facade.registrarDonante();
        String resultado = facade.buscarDonante();
        assertTrue(resultado.contains("Juan Perez"));
        assertTrue(resultado.contains("Riñon"));
        assertTrue(resultado.contains("O+"));
    }

    @Test
    public void testBuscarDonanteNoEncontrado() {
        facade = new Facade(new LectorMock("99999999"));
        String resultado = facade.buscarDonante();
        assertTrue(resultado.toLowerCase().contains("no encontrado"));
    }

    @Test
    public void testEliminarDonanteEncontrado() {
        facade = new Facade(new LectorMock(
                "12345678|Juan Perez|Riñon|O+",
                "12345678"
        ));
        facade.registrarDonante();
        String resultado = facade.eliminarDonante();
        assertTrue(resultado.toLowerCase().contains("correctamente"));
    }

    @Test
    public void testEliminarDonanteNoEncontrado() {
        facade = new Facade(new LectorMock("99999999"));
        String resultado = facade.eliminarDonante();
        assertTrue(resultado.toLowerCase().contains("no encontrado"));
    }

    @Test
    public void testMostrarDonantesVacio() {
        facade = new Facade(new LectorMock());
        String resultado = facade.mostrarDonantes();
        assertTrue(resultado.contains("0 donantes"));
    }

    @Test
    public void testMostrarDonantesConDatos() {
        facade = new Facade(new LectorMock(
                "12345678|Juan Perez|Riñon|O+",
                "87654321|Maria Lopez|Corazon|A+"
        ));
        facade.registrarDonante();
        facade.registrarDonante();
        String resultado = facade.mostrarDonantes();
        assertTrue(resultado.contains("2 donantes"));
        assertTrue(resultado.contains("Juan Perez"));
        assertTrue(resultado.contains("Maria Lopez"));
    }

    @Test
    public void testCargarDonantesArchivoInexistente() {
        facade = new Facade(new LectorMock("ruta/inexistente.csv"));
        String resultado = facade.cargarDonantesDesdeArchivo();
        assertTrue(resultado.toLowerCase().contains("error"));
    }

    // ============================================================
    // RECEPTORES
    // ============================================================

    @Test
    public void testRegistrarReceptorCorrecto() {
        facade = new Facade(new LectorMock("12345678|Maria Diaz|Riñon|B+|30|1"));
        String resultado = facade.registrarReceptor();
        assertTrue(resultado.toLowerCase().contains("correctamente"));
    }

    @Test
    public void testRegistrarReceptorFormatoIncorrecto() {
        facade = new Facade(new LectorMock("datos|mal|formados"));
        String resultado = facade.registrarReceptor();
        assertTrue(resultado.toLowerCase().contains("error"));
    }

    @Test
    public void testRegistrarReceptorPrioridadInvalida() {
        // Prioridad no es número
        facade = new Facade(new LectorMock("12345678|Maria Diaz|Riñon|B+|30|abc"));
        String resultado = facade.registrarReceptor();
        assertTrue(resultado.toLowerCase().contains("error"));
    }

    @Test
    public void testBuscarReceptorEncontrado() {
        facade = new Facade(new LectorMock(
                "12345678|Maria Diaz|Riñon|B+|30|1",
                "12345678"
        ));
        facade.registrarReceptor();
        String resultado = facade.buscarReceptor();
        assertTrue(resultado.contains("Maria Diaz"));
        assertTrue(resultado.contains("Riñon"));
        assertTrue(resultado.contains("B+"));
    }

    @Test
    public void testBuscarReceptorNoEncontrado() {
        facade = new Facade(new LectorMock("99999999"));
        String resultado = facade.buscarReceptor();
        assertTrue(resultado.toLowerCase().contains("no encontrado"));
    }

    @Test
    public void testEliminarReceptorEncontrado() {
        facade = new Facade(new LectorMock(
                "12345678|Maria Diaz|Riñon|B+|30|1",
                "12345678"
        ));
        facade.registrarReceptor();
        String resultado = facade.eliminarReceptor();
        assertTrue(resultado.toLowerCase().contains("correctamente"));
    }

    @Test
    public void testEliminarReceptorNoEncontrado() {
        facade = new Facade(new LectorMock("99999999"));
        String resultado = facade.eliminarReceptor();
        assertTrue(resultado.toLowerCase().contains("no encontrado"));
    }

    @Test
    public void testMostrarReceptoresConDatos() {
        facade = new Facade(new LectorMock("12345678|Maria Diaz|Riñon|B+|30|1"));
        facade.registrarReceptor();
        String resultado = facade.mostrarReceptores();
        assertTrue(resultado.contains("Maria Diaz"));
        assertTrue(resultado.contains("1 receptores"));
    }

    @Test
    public void testCargarReceptoresArchivoInexistente() {
        facade = new Facade(new LectorMock("ruta/inexistente.csv"));
        String resultado = facade.cargarReceptoresDesdeArchivo();
        assertTrue(resultado.toLowerCase().contains("error"));
    }

    // ============================================================
    // PROCESO MATCH / TRASPLANTES
    // ============================================================

    @Test
    public void testProcesoMatchSinDatos() {
        facade = new Facade(new LectorMock());
        String resultado = facade.procesoMatch();
        // No debe lanzar excepciones aunque no haya donantes ni receptores
        assertNotNull(resultado);
    }

    @Test
    public void testProcesoMatchConCompatibles() {
        facade = new Facade(new LectorMock(
                "12345678|Maria Diaz|Riñon|O+|30|1",  // receptor: necesita Riñon, O+
                "87654321|Juan Perez|Riñon|O+"        // donante: dona Riñon, O+ (compatible)
        ));
        facade.registrarReceptor();
        facade.registrarDonante();
        String resultado = facade.procesoMatch();
        assertTrue(resultado.toLowerCase().contains("trasplante"));
        assertTrue(resultado.contains("Juan Perez"));
        assertTrue(resultado.contains("Maria Diaz"));
    }

    @Test
    public void testProcesoMatchSinCompatiblesPorOrgano() {
        // Donante con órgano distinto al que necesita el receptor
        facade = new Facade(new LectorMock(
                "12345678|Maria Diaz|Riñon|O+|30|1",
                "87654321|Juan Perez|Corazon|O+"
        ));
        facade.registrarReceptor();
        facade.registrarDonante();
        String resultado = facade.procesoMatch();
        assertTrue(resultado.toLowerCase().contains("no hay receptores compatibles"));
    }

    @Test
    public void testProcesoMatchSinCompatiblesPorSangre() {
        // Donante con sangre incompatible (A+ no puede donar a O+)
        facade = new Facade(new LectorMock(
                "12345678|Maria Diaz|Riñon|O+|30|1",
                "87654321|Juan Perez|Riñon|A+"
        ));
        facade.registrarReceptor();
        facade.registrarDonante();
        String resultado = facade.procesoMatch();
        assertTrue(resultado.toLowerCase().contains("no hay receptores compatibles"));
    }

    @Test
    public void testProcesoMatchPriorizaPorPrioridad() {
        // Dos receptores compatibles, debe elegir el de prioridad menor (más urgente)
        facade = new Facade(new LectorMock(
                "11111111|Receptor Baja|Riñon|O+|30|3",  // prioridad 3 (menos urgente)
                "22222222|Receptor Alta|Riñon|O+|30|1",  // prioridad 1 (más urgente)
                "87654321|Donante Uno|Riñon|O+"
        ));
        facade.registrarReceptor();
        facade.registrarReceptor();
        facade.registrarDonante();
        String resultado = facade.procesoMatch();
        // El receptor con prioridad 1 debe recibir el órgano
        assertTrue(resultado.contains("Receptor Alta"));
    }

    @Test
    public void testMostrarTrasplantesVacio() {
        facade = new Facade(new LectorMock());
        String resultado = facade.mostrarTrasplantes();
        assertTrue(resultado.contains("0 transplantes"));
    }

    @Test
    public void testMostrarTrasplantesDespuesDeMatch() {
        facade = new Facade(new LectorMock(
                "12345678|Maria Diaz|Riñon|O+|30|1",
                "87654321|Juan Perez|Riñon|O+"
        ));
        facade.registrarReceptor();
        facade.registrarDonante();
        facade.procesoMatch();
        String resultado = facade.mostrarTrasplantes();
        assertTrue(resultado.contains("1 transplantes"));
        assertTrue(resultado.contains("12345678"));
        assertTrue(resultado.contains("87654321"));
    }

    // ============================================================
    // INTEGRACIÓN
    // ============================================================

    @Test
    public void testFlujoCompletoRegistroYMatch() {
        facade = new Facade(new LectorMock(
                // 3 receptores
                "11111111|Pedro|Riñon|O+|10|2",
                "22222222|Ana|Corazon|A+|20|1",
                "33333333|Luis|Riñon|A-|5|1",
                // 2 donantes
                "44444444|Donante1|Riñon|O-|",
                "55555555|Donante2|Corazon|A-|"
        ));
        facade.registrarReceptor();
        facade.registrarReceptor();
        facade.registrarReceptor();
        facade.registrarDonante();
        facade.registrarDonante();

        String matchResult = facade.procesoMatch();
        assertNotNull(matchResult);
        // Después del match, debería haber al menos un trasplante
        String trasplantes = facade.mostrarTrasplantes();
        assertFalse(trasplantes.contains("0 transplantes"));
    }
}
