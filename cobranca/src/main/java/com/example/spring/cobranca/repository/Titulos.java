package com.example.spring.cobranca.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.cobranca.model.Titulo;


public interface Titulos extends JpaRepository<Titulo, Long> {

}
