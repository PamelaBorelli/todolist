package com.pamela.todolist.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pamela.todolist.model.entity.Tarefa;
import com.pamela.todolist.model.enums.StatusTarefa;
import com.pamela.todolist.model.repository.TarefaRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }
    
    @Transactional
    public Tarefa criar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }
    @Transactional
    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id)
            .map(tarefa -> {
                tarefa.setNome(tarefaAtualizada.getNome());
                tarefa.setDescricao(tarefaAtualizada.getDescricao());
                tarefa.setStatus(tarefaAtualizada.getStatus());
                tarefa.setObservacoes(tarefaAtualizada.getObservacoes());
                return tarefaRepository.save(tarefa);
            })
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }
    
    @Transactional
    public Tarefa atualizarStatusParaConcluida(Long id) {
        return tarefaRepository.findById(id)
            .map(tarefa -> {
                if (tarefa.getStatus() == StatusTarefa.PENDENTE) {
                    tarefa.setStatus(StatusTarefa.CONCLUIDO);
                    return tarefaRepository.save(tarefa);
                } else {
                    throw new RuntimeException("A tarefa não está no status DEPENDENTE");
                }
            })
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }
    
    @Transactional
    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }
    
    public void deletarPorNome(String nome) {
        Optional<Tarefa> tarefa = tarefaRepository.findByNome(nome);
        if (tarefa.isPresent()) {
            tarefaRepository.delete(tarefa.get());
        } else {
            throw new RuntimeException("Tarefa com nome " + nome + " não encontrada");
        }
    }
}

