package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.example.ImplementacionesTDA.ListaEnlazada;
import com.example.ImplementacionesTDA.TDANodo;

public class ReceptorTest {
    
    private Receptor receptor;
    private GestorReceptores gestor;
    
    @Before
    public void setUp() {
        gestor = new GestorReceptores();}
    
    @Test
    public void testGetOrganoNecesitado() {
        receptor = new Receptor("63378546", "Maria Diaz", "Riñon", "B+", 30, 1);
        assertEquals("Riñon", receptor.getOrganoNecesitado());
    }
    
    @Test
    public void testGetDiasEnEspera() {
        receptor = new Receptor("63378546", "Maria Diaz", "Riñon", "B+", 30, 1);
        assertEquals(30, receptor.getDiasEnEspera());
    }
    
    @Test
    public void testGetPrioridad() {
        receptor = new Receptor("63378546", "Maria Diaz", "Riñon", "B+", 30, 1);
        assertEquals(1, receptor.getPrioridad());
    }
    
    @Test
    public void testAgregarReceptor() {
        boolean resultado = gestor.agregarReceptor("8837384937", "Juan Carlos", "Riñon", "B+", 30, 1);
        assertTrue(resultado);
        assertEquals(1, gestor.getListaReceptores().tamaño());
    }
    
    @Test
    public void testBuscarReceptor() {
        gestor.agregarReceptor("8837384937", "Juan Carlos", "Riñon", "B+", 30, 1);
        
        Receptor receptorEncontrado = gestor.buscarReceptor("8837384937");
        assertNotNull(receptorEncontrado);
        assertEquals("Juan Carlos", receptorEncontrado.getNombre());
        assertEquals("Riñon", receptorEncontrado.getOrganoNecesitado());
    }
    
    @Test
    public void testBuscarReceptorInexistente() {
        gestor.agregarReceptor("8837384937", "Juan Carlos", "Riñon", "B+", 30, 1);
        
        Receptor receptor = gestor.buscarReceptor("11111111");
        assertNull(receptor);
    }
    
    @Test
    public void testEliminarReceptor() {
        gestor.agregarReceptor("8837384937", "Juan Carlos", "Riñon", "B+", 30, 1);
        
        assertEquals(1, gestor.getListaReceptores().tamaño());
        boolean resultado = gestor.eliminarReceptor("8837384937");
        assertTrue(resultado);
        assertEquals(0, gestor.getListaReceptores().tamaño());
    }
    
    @Test
    public void testEliminarReceptorInexistente() {
        gestor.agregarReceptor("8837384937", "Juan Carlos", "Riñon", "B+", 30, 1);
        
        boolean resultado = gestor.eliminarReceptor("99999999");
        assertFalse(resultado);
        assertEquals(1, gestor.getListaReceptores().tamaño());
    }
    
    @Test
    public void testMostrarReceptores() {
        gestor.agregarReceptor("12345678", "Juan Perez", "Riñon", "B+", 30, 1);
        
        String resultado = gestor.MostrarReceptores();
        assertTrue(resultado.contains("Juan Perez"));
    }

    @Test
    public void testInsertarOrdenadoPorPrioridad() {
        gestor.agregarReceptor("11111111", "Carlos Lopez", "Higado", "A+", 30, 3);
        gestor.agregarReceptor("22222222", "Ana Rodriguez", "Riñon", "B+", 45, 1);
        gestor.agregarReceptor("33333333", "Pedro Martinez", "Corazon", "O+", 60, 2);
        
        ListaEnlazada<Receptor> lista = gestor.getListaReceptores();
        TDANodo<Receptor> nodo = lista.getPrimero();
        
        assertNotNull(nodo);
        assertEquals(1, nodo.getDato().getPrioridad());
        assertEquals("Ana Rodriguez", nodo.getDato().getNombre());
        
        nodo = nodo.getSiguiente();
        assertNotNull(nodo);
        assertEquals(2, nodo.getDato().getPrioridad());
        assertEquals("Pedro Martinez", nodo.getDato().getNombre());

        nodo = nodo.getSiguiente();
        assertNotNull(nodo);
        assertEquals(3, nodo.getDato().getPrioridad());
        assertEquals("Carlos Lopez", nodo.getDato().getNombre());
        
        nodo = nodo.getSiguiente();
        assertNull(nodo);
    }
    
    @Test
    public void testInsertarOrdenadoPorDias() {
        gestor.agregarReceptor("11111111", "Carlos Lopez", "Higado", "A+", 30, 1);
        gestor.agregarReceptor("22222222", "Ana Rodriguez", "Riñon", "B+", 60, 1);
        
        ListaEnlazada<Receptor> lista = gestor.getListaReceptores();
        TDANodo<Receptor> nodo = lista.getPrimero();

        assertNotNull(nodo);
        assertEquals(60, nodo.getDato().getDiasEnEspera());
        assertEquals("Ana Rodriguez", nodo.getDato().getNombre());
        
        nodo = nodo.getSiguiente();
        assertNotNull(nodo);
        assertEquals(30, nodo.getDato().getDiasEnEspera());
        assertEquals("Carlos Lopez", nodo.getDato().getNombre());
    }   
}
