package com.eduardoromeu.taskapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardoromeu.taskapi.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository <Tarefa, Long>{

}
