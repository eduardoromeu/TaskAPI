package com.eduardoromeu.taskapi.controller;

import com.eduardoromeu.taskapi.entity.Tarefa;
import com.eduardoromeu.taskapi.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping("/cadastro")
    public String cadastro(ModelMap model) {
        return "tarefa/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Tarefa tarefa,BindingResult result) {
        if (result.hasErrors()) {
            return "/tarefa/cadastro";
        }
        service.salvar(tarefa);
        return "redirect:/tarefas/cadastro";
    }

    @GetMapping("/lista")
    public String lista(ModelMap model){
        model.addAttribute("tarefas", service.buscaTodos());
        return "tarefa/lista";

    }

    // editar e excluir
    @PostMapping("/editar")
    public String editar(@Valid Tarefa tarefa, BindingResult result) {
        if (result.hasErrors()) {
            return "/tarefa/cadastro";
        }
        service.editar(tarefa);
        return "redirect:/tarefas/cadastro";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        service.excluir(id);
        return lista(model);
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("tarefa", service.buscarPorId(id));
        return "/tarefa/cadastro";
    }
}
