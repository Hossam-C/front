package com.mediscreen.front.proxies;


import com.mediscreen.front.DTO.RiskLevelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "riskLevel" ,  url = "risk:3333")
public interface RiskProxy {


    @GetMapping("/asses/id/{patientId}")
    String getRiskLevel(@PathVariable("patientId") Integer patientId);

    @GetMapping("/asses/family/{familyName}")
    List<RiskLevelDTO> getFamilyRiskLevel(@PathVariable("familyName") String familyName);

}
