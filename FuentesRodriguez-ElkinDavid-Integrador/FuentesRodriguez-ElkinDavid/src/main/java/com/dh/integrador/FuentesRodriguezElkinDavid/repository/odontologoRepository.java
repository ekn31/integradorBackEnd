package com.dh.integrador.FuentesRodriguezElkinDavid.repository;

import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface odontologoRepository extends JpaRepository<Odontologo, Long> {
    Optional<Odontologo> findAllById(Long id);


}
