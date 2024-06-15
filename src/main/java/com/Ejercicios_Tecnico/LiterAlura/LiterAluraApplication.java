package com.Ejercicios_Tecnico.LiterAlura;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Ejercicios_Tecnico.LiterAlura.Service.LibroService;
import com.Ejercicios_Tecnico.LiterAlura.model.Autor;
import com.Ejercicios_Tecnico.LiterAlura.model.Libro;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    @Autowired
    private LibroService libroService;

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarTodosLosLibros();
                    break;
                case 3:
                    listarLibrosPorIdioma();
                    break;
                case 4:
                    listarAutoresVivosEnAno();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("***************************************");
        System.out.println("** Escriba el número de la opción deseada **");
        System.out.println("1 - Buscar libro por título");
        System.out.println("2 - Listar todos los libros");
        System.out.println("3 - Listar libros por idioma");
        System.out.println("4 - Listar autores vivos en un año");
        System.out.println("9 - Salir");
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        Object libro = libroService.buscarLibroPorTitulo(titulo);
        System.out.println("Libro encontrado: " + libro);
    }

    private void listarTodosLosLibros() {
        List<Libro> libros = libroService.obtenerTodosLosLibros();
        libros.forEach(System.out::println);
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Ingrese el idioma: ");
        String idioma = scanner.nextLine();
        List<Libro> libros = libroService.obtenerLibrosPorIdioma(idioma);
        libros.forEach(System.out::println);
    }

    private void listarAutoresVivosEnAno() {
        System.out.print("Ingrese el año: ");
        int ano = scanner.nextInt();
        List<Autor> autores = libroService.obtenerAutoresVivosEn(ano);
        autores.forEach(System.out::println);
    }
}