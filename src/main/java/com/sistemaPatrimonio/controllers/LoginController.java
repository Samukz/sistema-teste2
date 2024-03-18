package com.sistemaPatrimonio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemaPatrimonio.models.usuario;
import com.sistemaPatrimonio.repositorio.usuariosRepo;
import com.sistemaPatrimonio.service.CookieService;


import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

        @Autowired
    private usuariosRepo repo; // Nome da variável de acordo com a convenção

    @GetMapping("/login")
    public String index() { // Aqui foi corrigido de 'indfex' para 'index'
        
        return "login/index"; // Verifique se o caminho para a view está correto
    }

    @PostMapping("/logar")
    public String logar(Model model, usuario admParm, String lembrar, HttpServletResponse response){ 

        usuario user = this.repo.login(admParm.getNome(), admParm.getSenha());

        if(user != null){

            CookieService.setCookie(response, "usuariosId",String.valueOf(user.getId()), 60*60);

            return "redirect:/";
        }
        model.addAttribute("erro", "usuario ou senha invalidos");
        return "login/index";
    }

}
