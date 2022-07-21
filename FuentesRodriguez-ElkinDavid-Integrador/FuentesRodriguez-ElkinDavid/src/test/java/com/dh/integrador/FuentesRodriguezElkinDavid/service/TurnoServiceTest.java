package com.dh.integrador.FuentesRodriguezElkinDavid.service;

import com.dh.integrador.FuentesRodriguezElkinDavid.dto.odontologoDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.dto.turnoDTO;
import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Paciente;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    TurnoService turnoService;

    @Autowired
    OdontologoService odontologoService;

    private void testSaveTurno(){


    }

}