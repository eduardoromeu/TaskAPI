package com.eduardoromeu.demorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardoromeu.demorest.model.Contato;

@Repository
public interface ContatoRepository  extends JpaRepository <Contato, Long>{

}
