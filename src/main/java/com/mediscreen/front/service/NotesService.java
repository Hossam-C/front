package com.mediscreen.front.service;


import com.mediscreen.front.DTO.NotesDTO;

import java.util.List;

public interface NotesService {

    public NotesDTO getNote(String id);

    public List<NotesDTO> getNotesByPatientId(Integer patientId);

    public NotesDTO addNotes(NotesDTO notesDTO);

    public NotesDTO updateNotes(NotesDTO notesDTO);

    public void deleteNotes(String id);
}
