package com.example.demo.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.example.demo.model.Translator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslatorRepository extends JpaRepository<Translator, Long> {
	// Translator findById(String id);
	@Query("SELECT t FROM Translator t WHERE t.variable=?1")
	Translator findByvariable(String variable);
	@Query("SELECT variable FROM Translator")
	ArrayList<String> findAllVariable();
@Transactional
@Modifying
@Query("delete from Translator t where t.variable=?1")
Map<String,Boolean> deleteByVariable(String variable);
//	@Transactional
//	@Modifying
//	@Query("update Translations t set t.language =?1 where u.variable = ?2")
//	int updatevariable(String vari, String lang);

	@Query("SELECT COUNT(t) FROM Translator t WHERE t.variable=?1")
    long getCountByvariable(String Variable);
}
