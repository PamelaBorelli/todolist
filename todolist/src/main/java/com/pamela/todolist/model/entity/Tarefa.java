package com.pamela.todolist.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.pamela.todolist.model.enums.StatusTarefa;

@Entity
@Data
public class Tarefa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome; 
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;
    
    private String observacoes;
    
    private LocalDateTime dataCriacao;
    
    private LocalDateTime dataAtualizacao;

    @PrePersist
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }
}
