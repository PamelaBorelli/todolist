package com.pamela.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pamela.todolist.model.entity.Tarefa;
import com.pamela.todolist.model.enums.StatusTarefa;
import com.pamela.todolist.model.repository.TarefaRepository;
import com.pamela.todolist.model.service.impl.TarefaService;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TarefaServiceTest {

    @Autowired
    private TarefaService tarefaService;

//    @Test
//    void criarTarefaTest() {
//        Tarefa tarefa = new Tarefa();
//        tarefa.setNome("Nova tarefa");
//        tarefa.setDescricao("Descrição da tarefa");
//
//        Tarefa criada = tarefaService.criar(tarefa);
//
//        assertNotNull(criada.getId());
//        assertEquals("Nova tarefa para teste 2", criada.getNome());
//    }
    
//    @Test
//    void deletarTarefaTest() {
//        Tarefa tarefa = new Tarefa();
//        tarefa.setNome("Nova tarefa para teste 2");
//        tarefa.setDescricao("Descrição da tarefa");
//        
//        Tarefa tarefaSalva = tarefaService.criar(tarefa);
//
//        assertNotNull(tarefaSalva.getId());
//        assertTrue(tarefaService.buscarPorId(tarefaSalva.getId()).isPresent());
//
//        tarefaService.deletar(tarefaSalva.getId());
//        assertFalse(tarefaService.buscarPorId(tarefaSalva.getId()).isPresent());
//    }
//    
//    @Test
//    void deletarTarefaPorNome() {
//        Tarefa tarefa = new Tarefa();
//        tarefa.setNome("Nova tarefa para teste 3");
//        tarefaService.criar(tarefa); 
//        
//        tarefaService.deletarPorNome("Nova tarefa para teste 3");
//
//        Optional<Tarefa> tarefaDeletada = tarefaService.buscarPorId(tarefa.getId());
//        assertTrue(tarefaDeletada.isEmpty());
//    }
    
    @Test
    void atualizarStatusParaConcluidaTest() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Tarefa de Teste Atualização");
        tarefa.setDescricao("Descrição da tarefa de teste");
        tarefa.setStatus(StatusTarefa.PENDENTE);
        Tarefa criada = tarefaService.criar(tarefa); 

        Tarefa tarefaAtualizada = tarefaService.atualizarStatusParaConcluida(criada.getId());

        assertEquals(StatusTarefa.CONCLUIDO, tarefaAtualizada.getStatus());
    }
   
    	
}


