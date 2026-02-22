package br.com.querango.restaurante.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String cpf;


    private String nome;
    private String cep;

}
