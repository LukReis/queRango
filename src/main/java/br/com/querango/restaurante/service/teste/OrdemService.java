package br.com.querango.restaurante.service.teste;
import br.com.querango.restaurante.dao.ClienteDao;
import br.com.querango.restaurante.dao.EnderecoDao;
import br.com.querango.restaurante.dao.OrdemDao;
import br.com.querango.restaurante.entity.ClienteId;
import br.com.querango.restaurante.entity.Ordem;
import br.com.querango.restaurante.util.CargaDeDadosUtil;
import br.com.querango.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerQueRango();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);

        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        System.out.println(enderecoDao.consultarClientesUsandoCriteria(null, "Sao Paulo", null));

        ClienteDao clienteDao = new ClienteDao(entityManager);
        System.out.println(clienteDao.consultarPorNome("Maria"));
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
