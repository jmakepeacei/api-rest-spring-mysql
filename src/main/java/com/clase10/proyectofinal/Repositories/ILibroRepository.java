package com.clase10.proyectofinal.Repositories;

import com.clase10.proyectofinal.Models.LibroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<LibroModel, Long> {

}
