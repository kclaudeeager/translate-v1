package com.example.demo.repository;

import com.example.demo.model.Translator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslatorRepository extends JpaRepository<Translator, Long> {
	Translator findById(String contactId);
}
