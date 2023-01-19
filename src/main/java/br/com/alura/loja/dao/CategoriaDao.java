package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Producto;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }
    public void salvar(Categoria categoria){
        em.persist(categoria);
    }

    public void actualizar(Categoria categoria){
      // categoria = em.merge(categoria);
        em.persist(categoria);
    }

    public void remove(Categoria categoria){
        // categoria = em.merge(categoria) forçar a entidade a ficar merged
        em.persist(categoria);
    }
}
