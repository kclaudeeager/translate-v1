package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Translator;
import com.example.demo.repository.TranslatorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/v1")
public class TranslatorController {

  @Autowired
  private TranslatorRepository translatorRepository;

  @PostMapping("/translate")
  public Translator createTransilTranslator(@Validated @RequestBody Translator translator) {
    return translatorRepository.save(translator);
  }

  @GetMapping("/translate")
  public Map<String, List<Translator>>getAlltTranslators() {
	  Map<String,List<Translator>> Translations=new HashMap<>();
	  Translations.put("Translations",translatorRepository.findAll());
    return Translations ;
  }

  @GetMapping("/translate/{variable}")
  public ResponseEntity<Translator> gettranslateByVariable(@PathVariable(value = "variable") String variable) {
    Translator trans = translatorRepository.findByvariable(variable);
    if (trans == null) {
      throw  new ResourceNotFoundException("Translate  not found :: " + variable);
    }
    return ResponseEntity.ok().body(trans);
  }

//  @GetMapping("/translate/{variable}")
//  public ResponseEntity<Translator> translateKey(@RequestParam(value = "variable") String variable, @RequestParam(value = "language") String language) {
//    Translator trans = translatorRepository.findByvariable(variable);
//    if (trans == null) {
//      throw  new ResourceNotFoundException("Translate  not found :: " + variable);
//    }
//    return ResponseEntity.ok().body(trans);
//  }

  
  @DeleteMapping("/translate/{variable}")
  public Map<String, Boolean> delettranslate(@PathVariable(value = "variable") String variable){
Translator trans = translatorRepository.findByvariable(variable);
    if (trans == null) {
      throw  new ResourceNotFoundException("Translate  not found :: " + variable);
    }
    translatorRepository.delete(trans);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
  @GetMapping("/translate/variables")
  public ArrayList<String> getAllVariabels() {
    return (ArrayList<String>) translatorRepository.findAllVariable();
  }
  @PutMapping("/translate/{variable}")
  public ResponseEntity<Translator> updatetranslate(@PathVariable(value = "variable") String variable,
      @RequestBody Translator transDetails) {
	  Translator trans = translatorRepository.findByvariable(variable);
	    if (trans == null) {
	      throw  new ResourceNotFoundException("Translate  not found :: " + variable);
	    }
    trans.setfrench(transDetails.getfrench() != null ? transDetails.getfrench() : trans.getfrench() );
    trans.setenglish(transDetails.getenglish() !=null? transDetails.getenglish() : trans.getenglish());
    trans.setswahili(transDetails.getswahili() != null ? transDetails.getswahili() : trans.getswahili());
    trans.setkinyarwanda(transDetails.getkinyarwanda() != null ? transDetails.getkinyarwanda() : trans.getkinyarwanda());
    final Translator updatedstranslation = translatorRepository.save(trans);
    return ResponseEntity.ok(updatedstranslation);
  }
  

}
