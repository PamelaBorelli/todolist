package com.pamela.todolist.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pamela.todolist.model.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	Optional<Tarefa> findByNome(String nome);
}
