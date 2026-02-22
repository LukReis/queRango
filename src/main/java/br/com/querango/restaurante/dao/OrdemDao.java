package br.com.querango.restaurante.dao;

import br.com.querango.restaurante.entity.Ordem;
import br.com.querango.restaurante.vo.ItensPrincipaisVo;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {

    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Ordem ordem) {
        this.entityManager.persist(ordem);
    }

    public Ordem consultarPorId(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultarTodos() {
        String jpql = "SELECT c FROM Ordem c";
        return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
    }

    public Ordem joinFetchCLiente(final Integer id) {
        String jpql = "SELECT o FROM Ordem o JOIN FETCH o.cliente WHERE o.id = :id ";
        return this.entityManager.createQuery(jpql, Ordem.class).setParameter("id", id).getSingleResult();
    }

    public List<ItensPrincipaisVo> consultarItensMaisVendidos() {
        String sql = "SELECT new br.com.querango.restaurante.vo.ItensPrincipaisVo(c.nome,SUM(oc.quantidade))" +
                " FROM Ordem o " +
                "JOIN OrdensCardapio oc on o.id = oc.cardapio.id " +
                "JOIN oc.cardapio c " +
                "group by c.nome " +
                "ORDER BY SUM(oc.quantidade) DESC";
        return this.entityManager.createQuery(sql, ItensPrincipaisVo.class).getResultList();
    }


    public void atualizar(final Ordem ordem) {
        this.entityManager.merge(ordem);
    }

    public void remover(Ordem ordem) {
        this.entityManager.remove(ordem);
    }

}
