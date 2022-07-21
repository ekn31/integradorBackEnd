package com.dh.integrador.FuentesRodriguezElkinDavid.repository;

import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pacienteRepository extends JpaRepository<Paciente, Long> {
}
