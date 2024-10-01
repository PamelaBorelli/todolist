package com.pamela.todolist.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.pamela.todolist.model.entity.Tarefa;
import com.pamela.todolist.model.service.impl.TarefaService;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefa(@PathVariable Long id) {
        return tarefaService.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.criar(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletar(id);
    }
    
    @DeleteMapping("/nome/{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorNome(@PathVariable String nome) {
        tarefaService.deletarPorNome(nome);
    }
    
    @PutMapping("/{id}/concluir")
    public Tarefa concluirTarefa(@PathVariable Long id) {
        return tarefaService.atualizarStatusParaConcluida(id);
    }
}
