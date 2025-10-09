package com.eduardoromeu.taskapi.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.eduardoromeu.taskapi.entity.Tarefa;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
class TesteTarefa {
    @Autowired
    private TarefaServiceImpl ts;

    @Test
    @Order(1)
    public void insere() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("revisao");
        tarefa.setDataEntrega(LocalDate.of(2024, 06, 20));
        tarefa.setResponsavel("Luciane");
        ts.salvar(tarefa);
    }

    @Test
    @Order(2)
    public void pesquisaPeloId() {
        Tarefa tarefa = ts.buscarPorId(2L);
        System.out.println(tarefa);
    }

    @Test
    @Order(3)
    public void atualiza() {
        Tarefa tarefa = ts.buscarPorId(2L);
        tarefa.setNome("Review");
        ts.editar(tarefa);
    }

    @Test
    @Order(4)
    public void remove() {
        Tarefa tarefa = ts.buscarPorId(2L);
        ts.excluir(tarefa.getId());
    }
}
