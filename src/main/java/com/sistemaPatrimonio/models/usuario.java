package com.sistemaPatrimonio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class usuario {
    

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

@Column(name = "user")
private String nome;

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

@Column(name = "password")
private String senha;

public String getSenha() {
    return senha;
}

public void setSenha(String senha) {
    this.senha = senha;
}

}
