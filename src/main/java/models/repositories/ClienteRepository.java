package models.repositories;

import java.util.ArrayList;
import java.util.List;

import models.entities.ClienteEntity;

public class ClienteRepository implements BasicCrud {

    List<ClienteEntity> bancoClientes = new ArrayList<>();
    private DAO<ClienteEntity> dao;

    public ClienteRepository() {
        dao = new DAO<>(ClienteEntity.class);
    }

    @Override
    public Long create(Object object) {
        ClienteEntity cliente = (ClienteEntity) object;
        dao.openConnection().insert(cliente).closeConnection();
        Long clienteId = cliente.getId();
        return clienteId;
    }

    @Override
    public ClienteEntity findById(Object id) {
        ClienteEntity cliente = dao.openConnection().findById(id);
        dao.closeConnection();
        return cliente;
    }

    @Override
    public Object update(Object object) {
        ClienteEntity cliente = (ClienteEntity) object;
        dao.openConnection().update(cliente);
        dao.closeConnection();
        return null;

    }

    @Override
    public void delete(Object entity) {
         dao.openConnection().delete((ClienteEntity) entity);
         dao.closeConnection();
    }

    public List<ClienteEntity> findAll() {
        List<ClienteEntity> clientes = dao.openConnection().findAll();
        dao.closeConnection();
        return clientes;
    }

    public ClienteEntity findByName(String name) {
        ClienteEntity cliente = dao.openConnection().findByName(name);
        dao.closeConnection();
        return cliente;
    }

}