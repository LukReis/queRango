package br.com.querango.restaurante.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @EmbeddedId
    private ClienteId clienteId;

    private String nome;
    private String cep;

    @Embedded
    private Contato contato;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecoList = new ArrayList<>();



    public Cliente() {
    }

    public Cliente(String cpf,String email, String nome) {
        this.clienteId = new ClienteId(email, cpf);
        this.nome = nome;
    }

    public void addEndereco(Endereco endereco) {
        endereco.setCliente(this);
        this.enderecoList.add(endereco);
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getCpf() {
        return clienteId.getCpf();
    }

    public void setCpf(String cpf) {
        this.clienteId.setCpf(cpf);
    }

    public String getEmail() {
        return clienteId.getEmail();
    }

    public void setEmail(String email) {
        this.clienteId.setEmail(email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + clienteId.getCpf() + '\'' +
                "email='" + clienteId.getEmail() + '\'' +
                ", nome='" + nome + '\'' +
                ", contato=" + contato +
                '}';
    }
}
