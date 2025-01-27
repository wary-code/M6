package com.example.ActivitaAPIRest.repositorie;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ActivitaAPIRest.model.AlumnoModel;

@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoModel, Long> {
    public abstract ArrayList<AlumnoModel> findByNombre(String nombre);

}