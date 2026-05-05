package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TrasplantesTest {
    
    private RegistroTrasplantes registro;
    private Donante donante;
    private Receptor receptor;
    private Trasplante trasplante;
    private Donante donante1;
    private Receptor receptor1;
    private Receptor receptor2;

    @Before
    public void setUp() {
        registro = new RegistroTrasplantes();
        trasplante = new Trasplante(donante, receptor);
    }
    
    @Test
    public void testGetDonante() {
        donante = new Donante("12345678", "Marco Carlomagno", "Corazon", "O+");
        Donante donante = trasplante.getDonante();
        assertEquals("Marco Carlomagno", donante.getNombre());
        assertEquals("Corazon", donante.getOrganoDonado());
        assertEquals("O+", donante.getTipoSangre());
        
    }
    
    @Test
    public void testGetReceptor() {
        receptor = new Receptor("11111111", "Maria De", "Corazon", "O+", 60, 1);
        Receptor receptor = trasplante.getReceptor();
        assertEquals("Maria De", receptor.getNombre());
        assertEquals("Corazon", receptor.getOrganoNecesitado());
        assertEquals("O+", receptor.getTipoSangre());
        assertEquals(60, receptor.getDiasEnEspera());
        assertEquals(1, receptor.getPrioridad());
    }
    
    @Test
    public void testAñadirTrasplante() {
        receptor = new Receptor("11111111", "Maria De", "Corazon", "O+", 60, 1);
        donante = new Donante("12345678", "Marco Carlomagno", "Corazon", "O+");
        registro.añadirTrasplante(donante, receptor);
        
        assertFalse(registro.getListaTrasplantes().esVacia());
        
        Trasplante trasplante = registro.getListaTrasplantes().getPrimero().getDato();
        assertEquals("12345678", trasplante.getDonante().getCedula());
        assertEquals("11111111", trasplante.getReceptor().getCedula());
    }
    
    @Test
    public void testBuscarTrasplante() {
        receptor = new Receptor("11111111", "Maria De", "Corazon", "O+", 60, 1);
        donante = new Donante("12345678", "Marco Carlomagno", "Corazon", "O+");
        donante1 = new Donante("123454", "Antonio Velazco", "Riñon", "B+");
        receptor1 = new Receptor("22222222", "Carlos Buela", "Riñon", "B+", 70, 2);
        registro.añadirTrasplante(donante, receptor);
        registro.añadirTrasplante(donante1, receptor1);
    
        Trasplante encontrado = registro.buscarTrasplante("12345678", "11111111");
        
        assertNotNull(encontrado);
    }
    
    @Test
    public void testBuscarTrasplanteInexistente() {
        donante1 = new Donante("123454", "Antonio Velazco", "Riñon", "B+");
        receptor1 = new Receptor("22222222", "Carlos Buela", "Riñon", "B+", 70, 2);
        registro.añadirTrasplante(donante1, receptor1);
        
        Trasplante encontrado = registro.buscarTrasplante("99999999", "88888888");
        
        assertNull(encontrado);
    }
    
    @Test
    public void testBuscarTrasplanteListaVacia() {
        Trasplante encontrado = registro.buscarTrasplante("12345678", "11111111");
        
        assertNull(encontrado);
    }
    
    @Test
    public void testBuscarTrasplanteConCIIncorrecta() {
        donante1 = new Donante("123454", "Antonio Velazco", "Riñon", "B+");
        receptor2 = new Receptor("22222222", "Carlos Buela", "Riñon", "B+", 70, 2);
        registro.añadirTrasplante(donante1, receptor1);
        
        Trasplante encontrado = registro.buscarTrasplante("123454", "00000000");
        
        assertNull(encontrado);
    }
    
    @Test
    public void testImprimirTrasplantesVacio() {
        String resultado = registro.imprimirTrasplantes();
        
        assertNotNull(resultado);
        assertTrue(false);
    }
    
    @Test
    public void testImprimirTrasplantesConUnTrasplante() {
        donante1 = new Donante("123454", "Antonio Velazco", "Riñon", "B+");
        receptor1 = new Receptor("22222222", "Carlos Buela", "Riñon", "B+", 70, 2);
        registro.añadirTrasplante(donante1, receptor1);
    
        String resultado = registro.imprimirTrasplantes();
        
        assertNotNull(resultado);
        assertTrue(resultado.contains("1"));
        assertTrue(resultado.contains("123454"));
        assertTrue(resultado.contains("22222222"));
        assertTrue(resultado.contains("Riñon"));
    }
    
    @Test
    public void testImprimirFormatoSalida() {
        donante1 = new Donante("123454", "Antonio Velazco", "Riñon", "B+");
        receptor1 = new Receptor("22222222", "Carlos Buela", "Riñon", "B+", 70, 2);
        registro.añadirTrasplante(donante1, receptor1);
        
        String resultado = registro.imprimirTrasplantes();

        assertNotNull(resultado);
        assertTrue(resultado.contains("----------------------------------------------------------------------------"));
        assertTrue(resultado.contains("CI receptor: 22222222"));
        assertTrue(resultado.contains("ÇI donante: 123454"));
        assertTrue(resultado.contains("Órgano donado: Riñon")); 
        
    }


}
