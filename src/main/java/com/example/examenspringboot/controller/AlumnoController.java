package com.example.examenspringboot.controller;

import com.example.examenspringboot.model.Alumno;
import com.example.examenspringboot.model.RepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alumnado")
public class AlumnoController {

    @Autowired
    private RepositoryJPA repositoryJPA;


    @GetMapping("")
    public List<Alumno> getAllAlumnos() {
        List<Alumno> alumnado = new ArrayList<>();
        var a = repositoryJPA.findAll();
        for(Alumno alumno : a) {
            alumnado.add(alumno);
        }
        return alumnado;
    }

    @GetMapping("/{id}")
    public Alumno getAlumno(@PathVariable Long id) {
        Alumno alumno = repositoryJPA.findById(id).get();
        return alumno;
    }

    @GetMapping("/suspensos/{modulo}")
    public List<Alumno> getSuspensos(@PathVariable String modulo) {
        List<Alumno> alumnado = new ArrayList<>();
        var a = repositoryJPA.findAll();
        for(Alumno alumno : a) {
            if(modulo.equals("ad") && alumno.getAd() < 5) {
                alumnado.add(alumno);
            } else if(modulo.equals("di") && alumno.getDi() < 5) {
                alumnado.add(alumno);
            }
        }
        return alumnado;
    }
}
