package com.mediscreen.front.proxies;


import com.mediscreen.front.DTO.NotesDTO;
import com.mediscreen.front.DTO.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "Notes" ,  url = "notes:2222")
public interface NotesProxy {

    @GetMapping(value = "/getNote/{id}")
    NotesDTO getNote(@PathVariable("id") String id);

    @GetMapping(value = "getNotesByPatient/{patientId}")
    List<NotesDTO> getNotesByPatientId(@PathVariable("patientId") Integer patientId);

    @PostMapping(value = "/addNotes")
    NotesDTO addNotes(NotesDTO notesDTO);

    @PostMapping(value = "/updateNotes")
    NotesDTO updateNotes(NotesDTO notesDTO);

    @GetMapping(value = "/deleteNotes/{id}")
    String deleteNotes(@PathVariable("id") String id);
}
