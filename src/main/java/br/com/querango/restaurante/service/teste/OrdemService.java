package br.com.querango.restaurante.service.teste;

import br.com.querango.restaurante.dao.CardapioDao;
import br.com.querango.restaurante.dao.ClienteDao;
import br.com.querango.restaurante.dao.OrdemDao;
import br.com.querango.restaurante.entity.Cliente;
import br.com.querango.restaurante.entity.Ordem;
import br.com.querango.restaurante.entity.OrdensCardapio;
import br.com.querango.restaurante.util.CargaDeDadosUtil;
import br.com.querango.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerQueRango();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Cliente lucas = new Cliente("11111111111", "Lucas", "00000000");
        Ordem ordem = new Ordem(lucas);
        ordem.addOrdensCardapio(new OrdensCardapio(ordem,cardapioDao.consultarPorId(1),2));
        clienteDao.cadastrar(lucas);
        ordemDao.cadastrar(ordem);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
