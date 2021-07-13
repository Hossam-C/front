package com.mediscreen.front.controllers;

import com.mediscreen.front.DTO.PatientDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mediscreen.front.service.PatientService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class PatientController {

    private static final Logger logger = LogManager.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;


    @RequestMapping("/")
    public String home(Model model){

        return "API Patient";
    }


    @GetMapping("/patient/list")
    public String getPatientList(Model model){

        logger.debug("patient/list");
        List<PatientDTO> patientDTOList = patientService.getPatientList();

        model.addAttribute("patientDTO", patientDTOList);

        return "patient/list";
    }

    @GetMapping("/patient/add")
    public String addPatientForm(PatientDTO patientDTO){

        logger.debug("patient/addPatientForm");

        return "/patient/add";
    }

    @PostMapping("/patient/validate")
    public String validate(@Valid PatientDTO patientDTO, BindingResult result, Model model) {

        logger.debug("patient/validate");

        if (!result.hasErrors()) {

            patientService.addPatient(patientDTO);
            model.addAttribute("patientDTO", patientService.getPatientList());
            return "redirect:/patient/list";

        }

        return "patient/add";

    }

    @GetMapping("/patient/update/{id}")
    public String updateForm(@PathVariable("id") Integer id , Model model) {

        logger.debug("patient/updateForm");

        PatientDTO patientDTO = patientService.getPatient(id);
        model.addAttribute("patientDTO", patientDTO);

        return "patient/update";
    }

    @PostMapping("patient/update/{id}")
    public String updatePatient(@PathVariable("id") Integer id, @Valid PatientDTO patientDTO, BindingResult result, Model model){

        logger.debug("patient/update");
        if (result.hasErrors()){
            logger.error("update error for id:"+id);
            return "patient/update";
        }

        patientService.updatePatient(patientDTO);

        model.addAttribute("patientDTO", patientService.getPatientList());
        return "redirect:/patient/list";

    }

    @GetMapping("patient/delete/{id}")
    public String deletePatient(@PathVariable("id") Integer id, Model model) {

        logger.debug("delete patient");
        patientService.deletePatient(id);
        model.addAttribute("patientDTO", patientService.getPatientList());

        return "redirect:/patient/list";

    }

}
