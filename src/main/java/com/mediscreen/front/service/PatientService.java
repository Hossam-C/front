package com.mediscreen.front.service;

import com.mediscreen.front.DTO.PatientDTO;

import java.util.List;

public interface PatientService {

    public PatientDTO getPatient(Integer id);

    public List<PatientDTO> getPatientList();

    public PatientDTO addPatient(PatientDTO patientDTO);

    public PatientDTO updatePatient(PatientDTO patientDTO);

    public void deletePatient(Integer id);
}
