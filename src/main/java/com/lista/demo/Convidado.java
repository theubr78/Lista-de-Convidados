package com.lista.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Convidado {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @NotBlank(message = "preencha o nome")
    private String nome;

    @Email(message = "Preencha com um email valido")
    @NotBlank
    private String email;
    
    @NotBlank(message = "Preencha com um telefone valido")
    private String telefone;

    public Convidado() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    
    
}

