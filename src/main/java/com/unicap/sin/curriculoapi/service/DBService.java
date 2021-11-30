package com.unicap.sin.curriculoapi.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicap.sin.curriculoapi.model.Competencia;
import com.unicap.sin.curriculoapi.model.Curriculo;
import com.unicap.sin.curriculoapi.model.Experiencia;
import com.unicap.sin.curriculoapi.model.Formacao;
import com.unicap.sin.curriculoapi.model.Localizacao;
import com.unicap.sin.curriculoapi.repository.CompetenciaRepository;
import com.unicap.sin.curriculoapi.repository.CurriculoRepository;
import com.unicap.sin.curriculoapi.repository.ExperienciaRepository;
import com.unicap.sin.curriculoapi.repository.FormacaoRepository;
import com.unicap.sin.curriculoapi.repository.LocalizacaoRepository;

@Service
public class DBService {
	@Autowired
	CompetenciaRepository competenciaRepository;
	
	@Autowired
	CurriculoRepository curriculoRepository;
	
	@Autowired
	ExperienciaRepository experienciaRepository;
	
	@Autowired
	FormacaoRepository formacaoRepository;
	
	@Autowired
	LocalizacaoRepository localizacaoRepository;
	
	public void instanciaBaseDeDados() {
		Curriculo cu1 = new Curriculo(null, "Thiago Mateus", "Programador", "Nada em especial", "81989392358", "thiago@outlook.com", "user_thiagom", "user_thiagom");
		Curriculo cu2 = new Curriculo(null, "Joselito o Préa", "Programador", "Joselito é massa gente boa dms", "81989552358", "joseprea@outlook.com", "joselito_oprea", "jose.lito");
		cu1 = this.curriculoRepository.save(cu1);
		cu2 = this.curriculoRepository.save(cu2);
		
		Competencia comp1 = new Competencia(null, "React Native", "Experiencia moderada com o framework ReactNative", cu1);
		Competencia comp2 = new Competencia(null, "CSS", "o pai sabe fazer arte no css", cu1);
		Competencia comp3 = new Competencia(null, "Java", "pouca experiencia, mas muito amor <3", cu1);
		Competencia comp4 = new Competencia(null, "ReactJs", "Grandes Experiencias com ReactJs", cu2);
		this.competenciaRepository.saveAll(Arrays.asList(comp1,comp2,comp3));
		this.competenciaRepository.saveAll(Arrays.asList(comp4));
		
		Experiencia exp1 = new Experiencia(null, "DeepSilver", "Desenvolvedor Junior", "2019", "2021", cu2);
		Experiencia exp2 = new Experiencia(null, "Avanade", "Engenheiro de Software", "2018", "2020", cu1);
		Experiencia exp3 = new Experiencia(null, "Capcom", "Desenvolvedor Junior", "2015", "2018", cu1);
		this.experienciaRepository.saveAll(Arrays.asList(exp1,exp2,exp3));
		
		Formacao for1 = new Formacao(null, "Unicap", "Sistemas para Internet", "2020", "2021", cu2);
		Formacao for2 = new Formacao(null, "Ibratec", "Analise e desenvolvimento de sistemas", "2019", "2021", cu1);
		this.formacaoRepository.saveAll(Arrays.asList(for1,for2));
		
		Localizacao loc1 = new Localizacao(null, "Brasil", "Pernambuco", "Ipojuca", cu1);
		Localizacao loc2 = new Localizacao(null, "Brasil", "Pernambuco", "Ipojuca", cu2);
		this.localizacaoRepository.saveAll(Arrays.asList(loc1,loc2));
		
		/* cu1.getCompetencias().addAll(Arrays.asList(comp1,comp2,comp3));
		cu1.getExperiencias().addAll(Arrays.asList(exp2,exp3));
		cu1.getFormacoes().addAll(Arrays.asList(for2)); */
		cu1.setLocalizacao(loc1);
		cu1.setCompetencias(Arrays.asList(comp1,comp2,comp3));
		cu1.setExperiencias(Arrays.asList(exp2,exp3));
		cu1.setFormacoes(Arrays.asList(for2));
		
		/* cu2.getCompetencias().addAll(Arrays.asList(comp4));
		cu2.getExperiencias().addAll(Arrays.asList(exp1));
		cu2.getFormacoes().addAll(Arrays.asList(for1));*/
		cu2.setLocalizacao(loc2); 
		cu2.setCompetencias(Arrays.asList(comp4));
		cu2.setExperiencias(Arrays.asList(exp1));
		cu2.setFormacoes(Arrays.asList(for1));
		
		
		
		/*this.competenciaRepository.saveAll(Arrays.asList(comp1,comp2,comp3,comp4));
		this.experienciaRepository.saveAll(Arrays.asList(exp1,exp2,exp3));
		this.formacaoRepository.saveAll(Arrays.asList(for1,for2));
		this.localizacaoRepository.saveAll(Arrays.asList(loc1,loc2));
		this.curriculoRepository.saveAll(Arrays.asList(cu1,cu2));*/
		
		
		/*Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Romance", "Livros Melosos");
		Categoria cat3 = new Categoria(null, "Terror", "Livro para melar a cueca");
		Livro l1 = new Livro(null, "CleanCode", "Robert Martin", "Blablablablablablabla", cat1);
		Livro l2 = new Livro(null, "Romeu e Julieta", "Roberto Kifer", "Blablablablablablabla", cat2);
		Livro l3 = new Livro(null, "Biohazard", "Mateus Da Silva", "Blablablablablablabla", cat3); 
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat3.getLivros().addAll(Arrays.asList(l3));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3));*/
	}
}
