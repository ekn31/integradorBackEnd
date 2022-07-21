package com.dh.integrador.FuentesRodriguezElkinDavid.service;

import com.dh.integrador.FuentesRodriguezElkinDavid.dto.odontologoDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Odontologo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    OdontologoService odontologoService;

    @Test
    public void testSaveOdontologo() {

        odontologoDTO odontologoDTO = new odontologoDTO();
        odontologoDTO.setId(2l);
        odontologoDTO.setNombre("TEST ODONTOLOGO");
        odontologoDTO.setApellido("TEST APELLIDO");
        odontologoDTO.setMatricula(123456);
        odontologoService.save(odontologoDTO);

        assertTrue(odontologoService.consultar(2l) != null);
        assertEquals("TEST ODONTOLOGO", odontologoService.consultar(2l).getNombre());

    }

        @Test
        public void testDeleteOdontolgo(){
            odontologoDTO odontologoDTO = new odontologoDTO();

            odontologoDTO.setNombre("TEST ODONTOLOGO");
            odontologoDTO.setApellido("TEST APELLIDO");
            odontologoDTO.setMatricula(123456);
            odontologoService.save(odontologoDTO);
            odontologoService.eliminar(1l);
            assertTrue(odontologoService.consultar(1L) == null);



    }

    @Test
    public void testFindPaciente(){
        odontologoDTO odontologoDTO = new odontologoDTO();
        odontologoDTO.setId(3l);
        odontologoDTO.setNombre("TEST ODONTOLOGO");
        odontologoDTO.setApellido("TEST APELLIDO");
        odontologoDTO.setMatricula(123456);
        odontologoService.save(odontologoDTO);


        assertEquals("TEST ODONTOLOGO", odontologoDTO.getNombre());
        assertEquals("TEST APELLIDO", odontologoDTO.getApellido());
        assertEquals(123456, odontologoDTO.getMatricula());

    }

}