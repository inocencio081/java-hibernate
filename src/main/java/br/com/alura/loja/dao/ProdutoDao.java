package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Producto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }
    public void salvar(Producto producto){
        em.persist(producto);
    }

    public void actualizar(Producto producto){
        // categoria = em.merge(categoria);
        em.persist(producto);
    }

    public void remove(Producto producto){
        // categoria = em.merge(categoria) forçar a entidade a ficar merged
        em.persist(producto);
    }

    public Producto buscarPorId(Long id){
      return  em.find(Producto.class, id);
    }

    public List<Producto> buscarTodos(){
        String jpql = "SELECT p FROM Producto p";
        return em.createQuery(jpql, Producto.class).getResultList();
    }

    public List<Producto> buscarPorNome(String nome){
       // String jpql = "SELECT p FROM Producto p WHERE p.nome = :nome";
         String jpql = "SELECT p FROM Producto p WHERE p.nome = ?1";
        return em.createQuery(jpql, Producto.class).setParameter(1, nome).getResultList();
    }

    public List<Producto> buscarPorNomeDaCategoria(String nome){
        // String jpql = "SELECT p FROM Producto p WHERE p.nome = :nome";
        String jpql = "SELECT p FROM Producto p WHERE p.categorias.nome = ?1";
        return em.createQuery(jpql, Producto.class).setParameter(1, nome).getResultList();
    }

    public String buscarDescricaoProduto(String nome){
        // String jpql = "SELECT p FROM Producto p WHERE p.nome = :nome";
        String jpql = "SELECT p.descricao FROM Producto p WHERE p.descricao = ?1";
        return em.createQuery(jpql, String.class).setParameter(1, nome).getSingleResult();
    }


}
