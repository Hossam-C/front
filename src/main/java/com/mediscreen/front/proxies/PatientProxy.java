package com.mediscreen.front.proxies;


import com.mediscreen.front.DTO.PatientDTO;
import com.mediscreen.front.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "patient" ,  url = "localhost:1111")
public interface PatientProxy {

    @GetMapping(value = "/getPatient/{id}")
    PatientDTO getPatient(@PathVariable("id") Integer id);

    @GetMapping(value = "/getPatientList")
    List<PatientDTO> getPatientList();

    @PostMapping(value = "/addPatient")
    PatientDTO addPatient(PatientDTO patientDTO);

    @PostMapping(value = "/updatePatient")
    PatientDTO updatePatient(PatientDTO patientDTO);

    @GetMapping(value = "/deletePatient/{id}")
    String deletePatient(@PathVariable("id") Integer id);


}
