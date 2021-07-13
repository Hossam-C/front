package com.mediscreen.front.service.Impl;

import com.mediscreen.front.DTO.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.mediscreen.front.proxies.PatientProxy;
import com.mediscreen.front.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientProxy patientProxy;

    @Override
    public PatientDTO getPatient(Integer id) {

        PatientDTO patientDTO = new PatientDTO();

        patientDTO = patientProxy.getPatient(id);

        return patientDTO;
    }


    @Override
    public List<PatientDTO> getPatientList(){

        List<PatientDTO> patientDTOList = new ArrayList<>();

        patientDTOList = patientProxy.getPatientList();

        return patientDTOList;

    }

    @Override
    public PatientDTO addPatient(PatientDTO patientDTO) {

        patientDTO = patientProxy.addPatient(patientDTO);

        return patientDTO;

    }

    @Override
    public PatientDTO updatePatient(PatientDTO patientDTO) {

        patientDTO = patientProxy.updatePatient(patientDTO);

        return patientDTO;

    }

    @Override
    public void deletePatient(Integer id) {

        patientProxy.deletePatient(id);
    }
}
