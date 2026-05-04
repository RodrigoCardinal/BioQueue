package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class DonanteTest {
    
    private Donante donante1;
    private Donante donante2;
    private GestorDonantes gestor;

    @Before
    public void setUp() {
        gestor = new GestorDonantes();
    }
    
    
    @Test
    public void testGetOrganoDonado() {
        donante1 = new Donante("74284838", "Joseb Abad", "Riñon", "B+");
        donante2 = new Donante("83648283", "Napoleon Bonaparte", "Corazon", "O+");
        assertEquals("Riñon", donante1.getOrganoDonado());
        assertEquals("Corazon", donante2.getOrganoDonado());
    }
    
    @Test
    public void testSetOrgano() {
        donante1 = new Donante("74284838", "Joseb Abad", "Riñon", "B+");
        donante2 = new Donante("83648283", "Napoleon Bonaparte", "Corazon", "O+");
        donante1.setOrgano_donado("Higado");
        assertEquals("Higado", donante1.getOrganoDonado());
    }
    
    @Test
    public void testSetNombre() {
        donante1 = new Donante("74284838", "Joseb Abad", "Riñon", "B+");
        donante2 = new Donante("83648283", "Napoleon Bonaparte", "Corazon", "O+");
        donante1.setNombre("Juan Perez");
        assertEquals("Juan Perez", donante1.getNombre());
    }
    
    @Test
    public void testSetCedula() {
        donante1 = new Donante("74284838", "Joseb Abad", "Riñon", "B+");
        donante2 = new Donante("83648283", "Napoleon Bonaparte", "Corazon", "O+");
        donante1.setCedula("99999999");
        assertEquals("99999999", donante1.getCedula());
    }
    
    @Test
    public void testAgregarDonante() {
        gestor.agregarDonante("74284838", "Joseb Abad", "Riñon", "B+");
        assertEquals(1, gestor.getListaDonantes().tamaño());
    }
    
    @Test
    public void testBuscarDonante() {
        gestor.agregarDonante("74284838", "Joseb Abad", "Riñon", "B+");
        
        Donante donante = gestor.buscarDonante("74284838");
        assertNotNull(donante);
        assertEquals("Joseb Abad", donante.getNombre());
        assertEquals("Riñon", donante.getOrganoDonado());
    }
    
    @Test
    public void testBuscarDonanteInexistente() {
        gestor.agregarDonante("74284838", "Joseb Abad", "Riñon", "B+");
        
        Donante donante = gestor.buscarDonante("99999999");
        assertNull(donante);
    }
    
    @Test
    public void testEliminarDonante() {
        gestor.agregarDonante("74284838", "Joseb Abad", "Riñon", "B+");
        gestor.agregarDonante("83648283", "Napoleon Bonaparte", "Corazon", "O+");
        
        assertEquals(2, gestor.getListaDonantes().tamaño());
        
        boolean resultado = gestor.eliminarDonante("74284838");
        assertTrue(resultado);
        assertEquals(1, gestor.getListaDonantes().tamaño());
    }
    
    @Test
    public void testEliminarDonanteInexistente() {
        gestor.agregarDonante("74284838", "Joseb Abad", "Riñon", "B+");
        
        boolean resultado = gestor.eliminarDonante("99999999");
        assertFalse(resultado);
        assertEquals(1, gestor.getListaDonantes().tamaño());
    }
    
    @Test
    public void testMostrarDonantesVacia() {
        String resultado = gestor.MostrarDonantes();
        assertTrue(resultado.contains("0 donantes"));
    }
}
