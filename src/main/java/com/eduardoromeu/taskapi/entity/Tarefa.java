package com.eduardoromeu.taskapi.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(name="TAREFA")
public class Tarefa extends AbstractEntity<Long> {

    @NotBlank(message = "O nome da tarefa é obrigatório")
    @Size(min = 2, max = 60, message = "O nome da tarefa deve ter entre 2 e 60 caracteres")
    @Column(name="nome", nullable = false, unique = true, length = 60)
    private String nome;

    @NotNull(message = "A data de entrega é obrigatória")
    @Column(name="data_entrega", nullable = false, columnDefinition = "DATE")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate dataEntrega;

    @NotBlank(message = "O nome do responsável é obrigatório")
    @Column(name="responsavel", nullable = false, length = 60)
    private String responsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
