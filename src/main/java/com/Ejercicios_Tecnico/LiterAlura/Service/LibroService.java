package com.Ejercicios_Tecnico.LiterAlura.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ejercicios_Tecnico.LiterAlura.Repository.IAutorRepository;
import com.Ejercicios_Tecnico.LiterAlura.Repository.ILibroRepository;
import com.Ejercicios_Tecnico.LiterAlura.model.Autor;
import com.Ejercicios_Tecnico.LiterAlura.model.Libro;

@Service
public class LibroService {

    @Autowired
    private ILibroRepository libroRepository;

    @Autowired
    private IAutorRepository autorRepository;


    public Libro buscarLibroPorTitulo(String titulo) {
        // Buscar en la base de datos local
        List<Libro> libros = (List<Libro>) libroRepository.findByTitulo(titulo);
        if (libros.isEmpty()) {
            throw new RuntimeException("Libro no encontrado en la base de datos local");
        }
        return libros.get(0);
    }

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    public List<Libro> obtenerLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    public List<Autor> obtenerAutoresVivosEn(int ano) {
        return autorRepository.findByAnoNacimientoLessThanEqualAndAnoFallecimientoGreaterThanEqual(ano, ano);
    }
}
