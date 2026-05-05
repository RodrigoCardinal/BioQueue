package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SistemaBioQueueTest {
    
    private SistemaBioQueue sistema;
    private Donante donante1;
    private Donante donante2;
    private Donante donante3;
    private Receptor receptor1;
    private Receptor receptor2;
    private Receptor receptor3;
    
    @Before
    public void setUp() {
        sistema = new SistemaBioQueue();
        
        donante1 = new Donante("11111111", "Luca Moreno", "Corazon", "O+");
        donante2 = new Donante("22222222", "Carlos Buela", "Riñon", "A+");
        donante3 = new Donante("33333333", "Pedro Varela", "Higado", "B+");
        
        receptor1 = new Receptor("44444444", "Marco Carlomagno", "Corazon", "O+", 30, 1);
        receptor2 = new Receptor("55555555", "Federico Baptista", "Riñon", "A+", 45, 2);
        receptor3 = new Receptor("66666666", "Rosa Ma", "Corazon", "O+", 20, 1);
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
    //falta la parte del sistemaBioqueue

    @Test
    public void testDesempateRandom() {}

    @Test
    public void testProcesarDonante() {}

    @Test
    public void testseleccionarMejorReceptor() {}

    @Test
    public void testProcesarListaEnteraDonantes() {}

}