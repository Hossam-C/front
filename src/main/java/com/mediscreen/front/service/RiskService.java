package com.mediscreen.front.service;

import com.mediscreen.front.DTO.RiskLevelDTO;

import java.util.List;

public interface RiskService {

    public String getPatientRisk(Integer patientId);

    public List<RiskLevelDTO> getPatientFamilyRisk(String name);
}
