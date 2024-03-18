package com.sistemaPatrimonio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() { // Aqui foi corrigido de 'indfex' para 'index'
        
        return "home/index.html"; // Verifique se o caminho para a view está correto
    }

}
