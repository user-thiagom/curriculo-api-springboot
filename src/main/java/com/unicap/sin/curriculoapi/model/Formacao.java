package com.unicap.sin.curriculoapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Formacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String instituicao;
	
	@Column(length = 100, nullable = false)
	private String curso;
	
	@Column(length = 4, nullable = false)
	private String anoInicio;
	
	@Column(length = 4, nullable = false)
	private String anoFim;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "curriculo_id")
	private Curriculo curriculo;
}
