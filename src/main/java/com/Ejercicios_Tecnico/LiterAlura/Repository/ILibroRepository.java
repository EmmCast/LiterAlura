package com.Ejercicios_Tecnico.LiterAlura.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ejercicios_Tecnico.LiterAlura.model.Libro;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByIdioma(String idioma);

    Libro findByTitulo(String titulo);
}
