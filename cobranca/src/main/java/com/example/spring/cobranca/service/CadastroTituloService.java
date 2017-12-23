package com.example.spring.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.spring.cobranca.model.StatusTitulo;
import com.example.spring.cobranca.model.Titulo;
import com.example.spring.cobranca.repository.Titulos;
import com.example.spring.cobranca.repository.filter.TituloFilter;

@Service
public class CadastroTituloService {

	@Autowired
	private Titulos titulos;

	
	public void save(Titulo titulo) {
		try {			
			titulos.save(titulo);			
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
		
	}


	public void excluir(Long codigo) {
		titulos.delete(codigo);
	}


	public String receber(Long codigo) {		
		Titulo titulo = titulos.findOne(codigo);
		titulo.setStatus(StatusTitulo.RECEBIDO);		
		titulos.save(titulo);		
		return StatusTitulo.RECEBIDO.getDescricao();
	}


	public List<Titulo> findAll(TituloFilter filtro) {
		return titulos.findByDescricaoContaining(filtro.getDescricao() == null ? "%" : filtro.getDescricao());
	}
	
		
	
}
