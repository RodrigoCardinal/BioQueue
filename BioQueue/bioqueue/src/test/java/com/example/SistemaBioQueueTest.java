package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.example.ImplementacionesTDA.ListaEnlazada;

public class SistemaBioQueueTest {
    
    private SistemaBioQueue sistema;
    private Donante donante1;
    private Receptor receptor1;
    private Receptor receptor3;
    
    @Before
    public void setUp() {
        sistema = new SistemaBioQueue();
        
        donante1 = new Donante("11111111", "Luca Moreno", "Corazon", "O+");
        receptor1 = new Receptor("44444444", "Marco Carlomagno", "Corazon", "O+", 30, 1);
        receptor3 = new Receptor("22222222", "Carlos Buela", "Riñon", "A+", 20, 1);
    }
    
    @Test
    public void testGetGestorReceptores() {
        assertNotNull(sistema.getGestorReceptores());
        assertNotNull(sistema.getGestorReceptores().getListaReceptores());
    }
    
    @Test
    public void testGetGestorDonantes() {
        assertNotNull(sistema.getGestorDonantes());
        assertNotNull(sistema.getGestorDonantes().getListaDonantes());
    }
    
    @Test
    public void testGetRegistroTrasplantes() {
        assertNotNull(sistema.getRegistroTrasplantes());
        assertNotNull(sistema.getRegistroTrasplantes().getListaTrasplantes());
    }

    @Test
    public void testDesempateRandom() {
        ListaEnlazada<Receptor> listaDesempate = new ListaEnlazada<>();
        listaDesempate.agregar(receptor1);
        listaDesempate.agregar(receptor3);
        
        sistema.desempateRandom(listaDesempate);
    }
    
    @Test
    public void testProcesarDonanteSinCompatibles() {
        RegistroTrasplantes registro = sistema.getRegistroTrasplantes();
        
        String resultado = sistema.procesarDonante(donante1, registro);
        assertNotNull(resultado);
        assertTrue(resultado.contains("No hay receptores compatibles"));
    }
    
    @Test
    public void testProcesarDonanteConCompatible() {
        RegistroTrasplantes registro = sistema.getRegistroTrasplantes();
        
        String resultado = sistema.procesarDonante(donante1, registro);
        assertNotNull(resultado);
    }
    
    @Test
    public void testProcesarDonanteMultiplesCompatibles() {
        RegistroTrasplantes registro = sistema.getRegistroTrasplantes();
        
        String resultado = sistema.procesarDonante(donante1, registro);
        assertNotNull(resultado);
    }
    
    @Test
    public void testProcesarListaEnteraDonantes() {
        String resultado = sistema.procesarListaEnteraDonantes();
        assertNotNull(resultado);
    }
    
    @Test
    public void testDesempateRandomListaVacia() {
        ListaEnlazada<Receptor> listaVacia = new ListaEnlazada<>();
        sistema.desempateRandom(listaVacia);
    }
}