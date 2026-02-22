package br.com.querango.restaurante.service.teste;

import br.com.querango.restaurante.dao.CardapioDao;
import br.com.querango.restaurante.util.CargaDeDadosUtil;
import br.com.querango.restaurante.util.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;


public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerQueRango();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("O Produto Pesquisado foi: " + cardapioDao.consultarPorNome("moqueca"));
        entityManager.close();


    }

}
