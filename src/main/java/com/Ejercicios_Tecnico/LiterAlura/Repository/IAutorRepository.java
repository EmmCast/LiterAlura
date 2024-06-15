package com.Ejercicios_Tecnico.LiterAlura.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ejercicios_Tecnico.LiterAlura.model.Autor;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByAnoNacimientoLessThanEqualAndAnoFallecimientoGreaterThanEqual(int anoNacimiento, int anoFallecimiento);
}