package com.clase10.proyectofinal.Controllers;

import com.clase10.proyectofinal.Models.LibroModel;
import com.clase10.proyectofinal.Repositories.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {

    private final ILibroRepository libroRepository;

    @Autowired
    public LibroController(ILibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @PostMapping("/guardar")
    @ResponseBody
    public String guardarLibro(@RequestBody LibroModel nuevoLibro){
        libroRepository.save(nuevoLibro);
        return "Libro Guardado con Exito";
    }

    @GetMapping("/listar")
    public List<LibroModel> listarLibros(){
        return libroRepository.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<LibroModel> listarLibrosPorId(@PathVariable Long id){
        return libroRepository.findById(id)
                .map(libro -> new ResponseEntity<>(libro, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/editar/{id}")
    @ResponseBody
    public ResponseEntity<String> editarLibro(@PathVariable Long id, @RequestBody LibroModel libroActualizado) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libro.setTitulo(libroActualizado.getTitulo());
                    libro.setAutor(libroActualizado.getAutor());
                    libro.setAnio(libroActualizado.getAnio());
                    libroRepository.save(libro);
                    return new ResponseEntity<>("Libro Actualizado con Exito", HttpStatus.OK);
                }).orElse(new ResponseEntity<>("Libro NO encontrado", HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public ResponseEntity<String> eliminarLibro(@PathVariable Long id) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libroRepository.delete(libro);
                    return new ResponseEntity<>("Libro Eliminado con Exito", HttpStatus.OK);
                }).orElse(new ResponseEntity<>("Libro NO encontrado", HttpStatus.NOT_FOUND));
    }

}
