package com.sistemaPatrimonio.controllers;

import java.util.List; // Corrigido para a lista padrão do Java
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemaPatrimonio.models.usuario; // Nome da classe atualizado para iniciar com letra maiúscula
import com.sistemaPatrimonio.repositorio.usuariosRepo;

@Controller
public class UsuariosController {

    @Autowired
    private usuariosRepo repo; // Nome da variável de acordo com a convenção

    @GetMapping("/usuarios")
    public String index(Model model) {

        List<usuario> usuarios = (List<usuario>) repo.findAll(); // Lista de objetos do tipo Usuario

        model.addAttribute("usuarios", usuarios);

        return "usuarios/index"; // Normalmente o '.html' não é necessário
    }

    @GetMapping("/usuarios/novo")
    public String novo() {

        return "usuarios/novo"; // Normalmente o '.html' não é necessário
    }

    @PostMapping("/usuarios/criar")
    public String criar(usuario usuario) {
        repo.save(usuario);

        return "redirect:/usuarios"; // Normalmente o '.html' não é necessário
    }

    @GetMapping("/usuarios/{id}/excluir")
    public String excluir(@PathVariable int id) {
        repo.deleteById(id);

        return "redirect:/usuarios";
    }
    
    @GetMapping("/usuarios/{id}")
    public String busca(@PathVariable int id, Model model) {
        Optional <usuario> user = repo.findById(id);

        model.addAttribute("usuario", user.get());

        return "/usuarios/editar";
    }

    @PostMapping("/usuarios/{id}/atualizar")
    public String atualizar(@PathVariable int id, usuario usuario) {

        if(!repo.existsById(id)){
            return "redirect:/usuarios";
        }

        repo.save(usuario);

        return "redirect:/usuarios";
    }
}
