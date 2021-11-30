package com.unicap.sin.curriculoapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Curriculo")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Curriculo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	
	@Column(length = 60, nullable = false)
	private String profissao;
	
	@Column(length = 400, nullable = true)
	private String resumo;
	
	@Column(length = 11, nullable = false, unique = true)
	private String telefone;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(length = 50, nullable = false)
	private String linkedin;
	
	@Column(length = 50, nullable = false)
	private String github;
	
	@OneToOne(mappedBy = "curriculo")
	private Localizacao localizacao;
	
	@OneToMany(mappedBy = "curriculo")
	private List<Experiencia> experiencias;
	
	@OneToMany(mappedBy = "curriculo")
	private List<Formacao> formacoes;
	
	@OneToMany(mappedBy = "curriculo")
	private List<Competencia> competencias;
	
	public Curriculo(Integer id, String nome, String profissao, String resumo, String telefone, String email,
			String linkedin, String github) {
		super();
		this.id = id;
		this.nome = nome;
		this.profissao = profissao;
		this.resumo = resumo;
		this.telefone = telefone;
		this.email = email;
		this.linkedin = linkedin;
		this.github = github;
	}
	
	
}
