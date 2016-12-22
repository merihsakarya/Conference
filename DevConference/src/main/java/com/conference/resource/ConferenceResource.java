package com.conference.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conference.entity.Presentation;
import com.conference.service.PresentationService;

@RestController
@RequestMapping("/conference")
class ConferenceResource {
    
    @Autowired
    PresentationService presentationService;
    
    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echo() {
        return "Echo!";
    }
    
    @RequestMapping(value = "/presentation/add", method = RequestMethod.POST)
    public ResponseEntity<Presentation> createPresentation(@RequestBody Presentation prs) {
        
        Presentation presentation = presentationService.createPresentation(prs);
        
        return new ResponseEntity<Presentation>(presentation, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/presentation/{id}", method = RequestMethod.GET)
    public ResponseEntity<Presentation> getCustomerById(@PathVariable Long id) {
        
        Presentation presentation = presentationService.getPresentationById(id);
        
        return new ResponseEntity<Presentation>(presentation, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/presentations", method = RequestMethod.GET)
    public ResponseEntity<List<Presentation>> listPresentations() {
        
        List<Presentation> presentations = presentationService.listPresentations();
        
        return new ResponseEntity<List<Presentation>>(presentations, HttpStatus.OK);
    }
}
