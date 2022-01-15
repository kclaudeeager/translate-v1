package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Entity
@Table(name = "Translations")
public class Translator extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "Variable", nullable = true, unique = true)
	private String variable;

	@Column(name = "English")
	private String englishs;

	@Column(name = "French", nullable = true)
	private String french;

	@Column(name = "Kinyarwanda", nullable = true)
	private String kinyrwanda;

	@Column(name = "Swahili", nullable = true)
	private String swahili;

	public Translator() {
		super();
	}

	public Translator(String kinyrwanda, String swahili, String french, String variable, String englishs) {
		super();
		this.kinyrwanda = kinyrwanda;
		this.swahili = swahili;
		this.french = french;
		this.variable = variable;
		this.englishs = englishs;
	}

	public Long getId() {
		return id;
	}

	public String getenglish() {
		return englishs;
	}

	public void setenglish(String englishs) {
		this.englishs = englishs;
	}

	public void setvariable(String variable) {
		this.variable = variable;
	}

	public String getvariable() {
		return variable;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getkinyrwanda() {
		return kinyrwanda;
	}

	public void setkinyrwanda(String kinyrwanda) {
		this.kinyrwanda = kinyrwanda;
	}

	public String getswahili() {
		return swahili;
	}

	public void setswahili(String swahili) {
		this.swahili = swahili;
	}

	public String getfrench() {
		return french;
	}

	public void setfrench(String french) {
		this.french = french;
	}

}
