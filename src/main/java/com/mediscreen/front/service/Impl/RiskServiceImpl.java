package com.mediscreen.front.service.Impl;

import com.mediscreen.front.DTO.RiskLevelDTO;
import com.mediscreen.front.proxies.RiskProxy;
import com.mediscreen.front.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskServiceImpl implements RiskService {

    @Autowired
    private RiskProxy riskProxy;

    @Override
    public String getPatientRisk(Integer patientId){

        return riskProxy.getRiskLevel(patientId);

    }

    @Override
    public List<RiskLevelDTO> getPatientFamilyRisk(String name){

        return riskProxy.getFamilyRiskLevel(name);
    }

}
