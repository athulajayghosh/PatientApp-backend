package com.example.patientApp_Backend.controller;

import com.example.patientApp_Backend.dao.PatientDao;
import com.example.patientApp_Backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientDao dao;


    @GetMapping("/")
    public String homepage(){
        return "Page Working fine";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Patient> viewall(){
        return (List<Patient>)dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public Patient addpatient(@RequestBody Patient p){
        dao.save(p);
        return p;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchpatient",consumes = "application/json",produces = "application/json")
    public List<Patient> searchEmp(@RequestBody Patient p){
        return (List<Patient>)dao.searchPatient(p.getName());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/deletepatient",consumes = "application/json",produces = "application/json" )
    public HashMap<String,String> deletepatient(@RequestBody Patient p){
        String id=String.valueOf(p.getId());
        dao.deletePatient(p.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }


}
