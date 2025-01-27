package com.example.ActivitaAPIRest.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ActivitaAPIRest.model.AlumnoModel;
import com.example.ActivitaAPIRest.service.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    private static final String Nombre = null;
	@Autowired
    AlumnoService alumnoService;

    @GetMapping()
    public ArrayList<AlumnoModel> obtenerAlumnos(){
        return alumnoService.obtenerAlumnos();
    }

    @PostMapping()
    public AlumnoModel guardarAlumno(@RequestBody AlumnoModel alumno){
        return this.alumnoService.guardarAlumno(alumno);
    }

    @GetMapping( path = "/{id}")
    public Optional<AlumnoModel> obtenerAlumnoPorId(@PathVariable("id") Long id) {
        return this.alumnoService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<AlumnoModel> obtenerAluimnoPorNombre(@RequestParam("Nombre") String nombre){
        return this.alumnoService.obtenerPorNombre(Nombre);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.alumnoService.eliminarAlumno(id);
        if (ok){
            return "Se eliminó el alumno con id " + id;
        }else{
            return "No pudo eliminar el alumno con id" + id;
        }
    }

}
