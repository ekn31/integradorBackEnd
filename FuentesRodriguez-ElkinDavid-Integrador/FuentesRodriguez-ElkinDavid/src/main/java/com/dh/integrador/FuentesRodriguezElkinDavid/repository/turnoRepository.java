package com.dh.integrador.FuentesRodriguezElkinDavid.repository;


import com.dh.integrador.FuentesRodriguezElkinDavid.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface turnoRepository extends JpaRepository<Turno, Long> {

}
