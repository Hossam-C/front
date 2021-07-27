package com.mediscreen.front.service.Impl;


import com.mediscreen.front.DTO.NotesDTO;
import com.mediscreen.front.proxies.NotesProxy;
import com.mediscreen.front.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesProxy notesProxy;

    @Override
    public NotesDTO getNote(String id) {

        NotesDTO notesDTO = new NotesDTO();

        notesDTO = notesProxy.getNote(id);

        return notesDTO;
    }


    @Override
    public List<NotesDTO> getNotesByPatientId(Integer id){

        List<NotesDTO> notesDTOList = new ArrayList<>();

        notesDTOList = notesProxy.getNotesByPatientId(id);

        return notesDTOList;

    }

    @Override
    public NotesDTO addNotes(NotesDTO notesDTO) {

        notesDTO = notesProxy.addNotes(notesDTO);

        return notesDTO;

    }

    @Override
    public NotesDTO updateNotes(NotesDTO notesDTO) {

        notesDTO = notesProxy.updateNotes(notesDTO);

        return notesDTO;

    }

    @Override
    public void deleteNotes(String id) {

        notesProxy.deleteNotes(id);
    }
}
