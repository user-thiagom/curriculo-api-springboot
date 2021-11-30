package com.unicap.sin.curriculoapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.unicap.sin.curriculoapi.model.Curriculo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CurriculoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Campo NOME é requerido")
	@Length(min = 3, max = 60, message = "O campo NOME deve ter entre 3 e 60 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo PROFISSAO é requerido")
	@Length(min = 4, max = 60, message = "O campo PROFISSAO deve ter entre 4 e 60 caracteres")
	private String profissao;
	
	@Length(max = 400, message = "O campo RESUMO deve ter até 400 caracteres")
	private String resumo;
	
	@NotEmpty(message = "Campo EMAIL é requerido")
	@Length(min = 11, max = 50, message = "O campo EMAIL deve ter entre 11 e 50 caracteres")
	private String email;
	
	@NotEmpty(message = "Campo TELEFONE é requerido")
	@Length(min = 11, max = 11, message = "O campo EMAIL deve ter entre 11 caracteres")
	private String telefone;
	
	@Length(max = 50, message = "O campo LIKEDIN deve ter até 50 caracteres")
	private String linkedin;
	
	@Length(max = 50, message = "O campo GITHUB deve ter até 50 caracteres")
	private String github;

	public CurriculoDTO(Curriculo obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.profissao = obj.getProfissao();
		this.resumo = obj.getResumo();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
		this.linkedin = obj.getLinkedin();
		this.github = obj.getLinkedin();
	}

	
	
	
}
