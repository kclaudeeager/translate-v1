package com.example.demo.controller;

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
  public List<Translator> getAlltTranslators() {
    return translatorRepository.findAll();
  }

  @GetMapping("/translate/{variable}")
  public ResponseEntity<Translator> gettranslateById(@PathVariable(value = "id") Long id) {
    Translator trans = translatorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Translate  not found :: " + id));
    return ResponseEntity.ok().body(trans);
  }

  @DeleteMapping("/translate/{variable}")
  public Map<String, Boolean> delettranslate(@PathVariable(value = "variable") Long variable) {
    Translator trans = translatorRepository.findById(variable)
        .orElseThrow(() -> new ResourceNotFoundException("variable not found :: " + variable));
    translatorRepository.delete(trans);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }

  @PutMapping("/translate{variable}")
  public ResponseEntity<Translator> updatetranslate(@PathVariable(value = "variable") Long variable,
      @RequestBody Translator transDetails) {
    Translator trans = translatorRepository.findById(variable)
        .orElseThrow(() -> new ResourceNotFoundException("translation not found :: " + variable));

    trans.setfrench(transDetails.getfrench());
    trans.setenglish(transDetails.getenglish());
    trans.setswahili(transDetails.getswahili());
    trans.setkinyrwanda(transDetails.getkinyrwanda());
    final Translator updatedstranslation = translatorRepository.save(trans);
    return ResponseEntity.ok(updatedstranslation);
  }

}
