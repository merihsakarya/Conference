package com.conference.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conference.dao.PresentationDao;
import com.conference.entity.Presentation;

@Service
public class PresentationService {
    
    @Autowired
    PresentationDao presentationDao;
    
    public Presentation createPresentation(Presentation presentation){
        return presentationDao.createPresentation(presentation);
    }
    
    public Presentation updatePresentation(Presentation presentation){
        return presentationDao.updatePresentation(presentation);
    }

    public Presentation getPresentationById(long id){
        return presentationDao.getPresentationById(id);
    }

    public List<Presentation> listPresentations(){
        return presentationDao.listPresentations();
    }
}
