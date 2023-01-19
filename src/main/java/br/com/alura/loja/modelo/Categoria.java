package br.com.alura.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    // é preciso ter um construtor default para as entidades JPA
    public Categoria() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
