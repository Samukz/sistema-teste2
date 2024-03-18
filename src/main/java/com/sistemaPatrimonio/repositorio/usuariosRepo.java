package com.sistemaPatrimonio.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sistemaPatrimonio.models.usuario;

public interface usuariosRepo extends CrudRepository<usuario, Integer>{
    
    @Query(value="select * from usuarios where user = :nome and password = :senha", nativeQuery = true)
    public usuario login(String nome, String senha);
}

