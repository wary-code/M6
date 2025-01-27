package com.example.ActivitaAPIRest.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ActivitaAPIRest.model.AlumnoModel;
import com.example.ActivitaAPIRest.repositorie.AlumnoRepository;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;
    
    public ArrayList<AlumnoModel> obtenerAlumnos(){
        return (ArrayList<AlumnoModel>) alumnoRepository.findAll();
    }

    public AlumnoModel guardarAlumno(AlumnoModel alumno){
        return alumnoRepository.save(alumno);
    }

    public Optional<AlumnoModel> obtenerPorId(Long id){
        return alumnoRepository.findById(id);
    }


    public ArrayList<AlumnoModel>  obtenerPorNombre(String nombre) {
        return alumnoRepository.findByNombre(nombre);
    }

    public boolean eliminarAlumno(Long id) {
        try{
            alumnoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}
