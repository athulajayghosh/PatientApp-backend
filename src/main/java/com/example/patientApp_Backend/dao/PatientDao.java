package com.example.patientApp_Backend.dao;

import com.example.patientApp_Backend.model.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends CrudRepository<Patient,Integer> {
    @Query(value = "SELECT `id`, `address`, `doctor`, `mobileno`, `name` FROM `patient` WHERE `name`= :name",nativeQuery = true)
    List<Patient> searchPatient(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `patient` WHERE `id`=:id",nativeQuery = true)
    void deletePatient(@Param("id") Integer id);
}
