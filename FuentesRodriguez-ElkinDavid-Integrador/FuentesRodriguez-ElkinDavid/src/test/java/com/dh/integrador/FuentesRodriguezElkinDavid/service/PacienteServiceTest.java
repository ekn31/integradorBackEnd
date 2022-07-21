package com.dh.integrador.FuentesRodriguezElkinDavid.service;

import com.dh.integrador.FuentesRodriguezElkinDavid.dto.pacienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PacienteServiceTest {

    @Autowired
    PacienteService pacienteService;

   @Test
    public void testCrearEstudiante() {
        pacienteDTO pacienteDTO = new pacienteDTO();
        pacienteDTO.setId(3l);
        pacienteDTO.setNombre("TEST NOMBRE");
        pacienteDTO.setApellido("TEST APELLIDO");
        pacienteDTO.setDNI("TEST DNI");
        pacienteService.save(pacienteDTO);
        pacienteDTO pacienteDTO1 = pacienteService.findById(3l);

        assertTrue(pacienteDTO1 != null);
        assertFalse(pacienteDTO1 == null);

    }



    @Test
    public void testBuscarPaciente(){
        pacienteDTO pacienteDTO = new pacienteDTO();
        pacienteDTO.setId(2l);
        pacienteDTO.setNombre("TEST NOMBREBUSCAR");
        pacienteDTO.setApellido("TEST APELLIDOBUSCAR");
        pacienteDTO.setDNI("TEST DNIBUSCAR");
        pacienteService.save(pacienteDTO);

        pacienteDTO pacienteDTO1 = pacienteService.findById(2l);

        assertEquals("TEST NOMBREBUSCAR", pacienteDTO1.getNombre());
        assertEquals("TEST APELLIDOBUSCAR", pacienteDTO1.getApellido());
        assertEquals("TEST DNIBUSCAR", pacienteDTO1.getDNI());

    }

    @Test
    public void testEliminarPaciente(){
        pacienteDTO pacienteDTO = new pacienteDTO();
        // pacienteDTO.setId(2l);
        pacienteDTO.setNombre("TEST NOMBREDELETE");
        pacienteDTO.setApellido("TEST APELLIDODELETE");
        pacienteDTO.setDNI("TEST DNIDELETE");
        pacienteService.save(pacienteDTO);
        pacienteService.delete(1l);
        pacienteDTO pacienteDTO1 = pacienteService.findById(1l);

        assertEquals(null,pacienteDTO1);


    }



}