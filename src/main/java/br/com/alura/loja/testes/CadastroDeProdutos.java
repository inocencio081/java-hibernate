package br.com.alura.loja.testes;

import br.com.alura.loja.JPAUtil.JpaUtilFactory;
import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CadastroDeProdutos {
    public static void main(String[] args) {
   //cadastroProduto();
        EntityManager em = JpaUtilFactory.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

       /* Producto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getNome());*/

        /*
        List<Producto> p1 = produtoDao.buscarTodos();
        for (Producto pro: p1) {
            System.out.println(pro.getNome());
        }*/

        List<Producto> p1 = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        for (Producto pro: p1) {
            System.out.println("o nome é" + pro.getNome());
        }

        String desc = produtoDao.buscarDescricaoProduto("com fio");
            System.out.println("A desc é" + desc);


    }

    public static void cadastroProduto(){
        Categoria celulares = new Categoria("CELULARES");
        Producto celular = new Producto("Xiaomi Redmi", "Muito legal", celulares );

        EntityManager em = JpaUtilFactory.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.salvar(celulares);
        produtoDao.salvar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
