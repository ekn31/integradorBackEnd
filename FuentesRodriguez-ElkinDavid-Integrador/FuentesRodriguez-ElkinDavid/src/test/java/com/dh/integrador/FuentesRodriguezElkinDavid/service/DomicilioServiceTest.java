package com.dh.integrador.FuentesRodriguezElkinDavid.service;

import com.dh.integrador.FuentesRodriguezElkinDavid.dto.domicilioDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DomicilioServiceTest {

    @Autowired
    DomicilioService domicilioService;


    @Test
    public void testSaveDomicilio(){

        domicilioDTO domicilioDTO = new domicilioDTO();
        domicilioDTO.setId(1l);
        domicilioDTO.setCalle("TEST CALLE");
        domicilioDTO.setLocalidad("TEST LOCALIDAD");
        domicilioDTO.setNumero(12345);
        domicilioDTO.setProvincia("TEST PROVINCIA");
        domicilioService.save(domicilioDTO);

        assertTrue(domicilioService.findById(1l) != null);

    }


    @Test
    public void testDeleteDomicilio(){
        domicilioDTO domicilioDTO = new domicilioDTO();
        domicilioDTO.setId(1l);
        domicilioDTO.setCalle("TEST CALLE");
        domicilioDTO.setLocalidad("TEST LOCALIDAD");
        domicilioDTO.setNumero(12345);
        domicilioDTO.setProvincia("TEST PROVINCIA");
        domicilioService.save(domicilioDTO);
        domicilioService.delete(1l);
        assertTrue(domicilioService.findById(1l) == null);

    }

    @Test
    public void testFindDomicilio(){
        domicilioDTO domicilioDTO = new domicilioDTO();
        domicilioDTO.setId(3l);
        domicilioDTO.setCalle("TEST CALLE");
        domicilioDTO.setLocalidad("TEST LOCALIDAD");
        domicilioDTO.setNumero(12345);
        domicilioDTO.setProvincia("TEST PROVINCIA");
        domicilioService.save(domicilioDTO);

        assertEquals("TEST CALLE", domicilioDTO.getCalle());
        assertEquals(3l, domicilioDTO.getId());
        assertEquals(12345, domicilioDTO.getNumero());

    }

}