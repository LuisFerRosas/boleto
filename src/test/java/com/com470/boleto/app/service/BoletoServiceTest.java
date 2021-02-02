/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.boleto.app.service;

import com.com470.boleto.app.dao.BoletoDao;
import com.com470.boleto.app.entities.Boleto;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Date;
import java.util.List;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Fernando
 */
public class BoletoServiceTest {
    Boleto boleto ;
    
    @Mock
    private BoletoDao boletoDao;
    
    @InjectMocks
    BoletoService boletoService;
   
    public BoletoServiceTest() {
         boleto =new Boleto();
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateBoleto() {
        Boleto guardado ;
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jose Perez");
        boleto.setSalida("Sucre");

        boleto.setDestino("Potosi");

        boleto.setFecha(new Date());

        boleto.setEmail("jorge.perez@gmail.com");

        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto);
         guardado=boletoService.createBoleto(boleto);

        //assertThat(boletoDao.save(boleto)).isEqualTo(boleto);
        assertEquals(guardado, boleto);
        
    }

    @Test
    public void testGetBoletoById() {
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jose Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        Boleto guardado ;
        guardado=boletoService.getBoletoById(1);
        Mockito.when(guardado).thenReturn(boleto);
    }

    @Test
    public void testGetAllBoletos() {
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jose Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
       
        Mockito.when(boletoService.getAllBoletos()).thenReturn(Arrays.asList(boleto));
        assertEquals(boletoService.getAllBoletos(), Arrays.asList(boleto));
    }

    @Test
    public void testDeleteBoleto() {
        Boleto guardado ;
        
        boletoService.deleteBoleto(1);
        guardado=boletoService.getBoletoById(1);
        Mockito.when(guardado).thenReturn(null);
        assertEquals(guardado, null);
        
    }

    @Test
    public void testUpdateBoleto() {
//        boleto.setBoletoId(1);
//        boleto.setNombreDelPasajero("Jose Perez");
//        boleto.setSalida("Sucre");
//        boleto.setDestino("Potosi");
//        boleto.setFecha(new Date());
//        boleto.setEmail("jorge.perez@gmail.com");
//        
//        Boleto dato ;
//        dato=boletoService.updateBoleto(1, "correo");
//        
//        assertNotEquals(boleto, dato);
        Mockito.when(boletoDao.findOne(1)).thenReturn(boleto);
        Boleto response = boletoService.updateBoleto(1, "correo");

        assertEquals(response, boletoDao.save(boleto));
    }
    
}
