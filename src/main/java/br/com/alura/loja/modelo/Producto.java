package br.com.alura.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nome;
    //@Column(name = "desc") quando o nome da coluna é difrente
    private String descricao;
    @ManyToOne
    private Categoria categorias;

    public Producto(String nome, String descricao, Categoria categorias) {
        this.nome = nome;
        this.descricao = descricao;
        this.categorias = categorias;
    }

    public Producto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }
}
