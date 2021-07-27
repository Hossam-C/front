package com.mediscreen.front.controllers;


import com.mediscreen.front.DTO.NotesDTO;
import com.mediscreen.front.DTO.PatientDTO;
import com.mediscreen.front.service.NotesService;
import com.mediscreen.front.service.PatientService;
import com.mediscreen.front.service.RiskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NotesController {

    private static final Logger logger = LogManager.getLogger(NotesController.class);

    @Autowired
    private NotesService notesService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private RiskService riskService;



    @GetMapping("/notes/list/{patientId}")
    public String getNotesList(@PathVariable("patientId") Integer patientId ,Model model){

        logger.debug("notes/list");
        PatientDTO patientDTO = patientService.getPatient(patientId);
        List<NotesDTO> notesDTOList = notesService.getNotesByPatientId(patientId);
        String riskLEvel = riskService.getPatientRisk(patientId);

        model.addAttribute("notesDTO", notesDTOList);
        model.addAttribute("patientDTO" , patientDTO);
        model.addAttribute("riskLEvel", riskLEvel);
        model.addAttribute("patientId", patientId);

        return "notes/list";
    }

    @GetMapping("/notes/add/{patientId}")
    public String addNotesForm(@PathVariable("patientId") Integer id, NotesDTO notesDTO, Model model){

        logger.debug("notes/addNotesForm");
        model.addAttribute("notesDTO" , notesDTO);
        model.addAttribute("patientId", id);

        return "notes/add";
    }

    @PostMapping("/notes/validate/{patientId}")
    public String validate(@PathVariable("patientId") Integer id,  @Valid NotesDTO notesDTO, BindingResult result, Model model) {

        logger.debug("notes/validate");

        if (!result.hasErrors()) {

            notesDTO.setPatientId(id);
            notesService.addNotes(notesDTO);
            model.addAttribute("notesDTO", notesService.getNotesByPatientId(notesDTO.getPatientId()));
            model.addAttribute("patientId", id);
            return "redirect:/notes/list/"+id;

        }

        return "notes/add";

    }

    @GetMapping("/notes/update/{patientId}/{id}")
    public String updateNotesForm(@PathVariable("patientId") Integer patientId,@PathVariable("id") String id,NotesDTO notesDTO, Model model) {

        logger.debug("notes/updateNotesForm");

        notesDTO = notesService.getNote(id);
        model.addAttribute("notesDTO" , notesDTO);
        model.addAttribute("patientId", patientId);
        model.addAttribute("id" , id);

        return "notes/update";

    }

    @PostMapping("/notes/update/{patientId}/{id}")
    public String updateNotes(@PathVariable("patientId") Integer patientId, @PathVariable("id") String id,  @Valid NotesDTO notesDTO, BindingResult result, Model model) {

        logger.debug("notes/update");

        if (!result.hasErrors()) {

            //notesDTO.setPatientId(patientId);
            NotesDTO notesDTO1 = notesService.getNote(id);
            notesDTO.setDateCreation(notesDTO1.getDateCreation());
            notesService.updateNotes(notesDTO);
            model.addAttribute("notesDTO", notesService.getNotesByPatientId(notesDTO.getPatientId()));
            model.addAttribute("patientId", patientId);
            model.addAttribute("id", id);
            return "redirect:/notes/list/"+patientId;

        }

        return "notes/add";

    }

    @GetMapping("/notes/delete/{patientId}/{id}")
    public String deleteNote(@PathVariable("patientId") Integer patientId , @PathVariable("id") String id, Model model) {

        logger.debug("notes/delete");
        notesService.deleteNotes(id);
        model.addAttribute("notesDTO", notesService.getNotesByPatientId(patientId));

        return "redirect:/notes/list/"+patientId;
    }

}
