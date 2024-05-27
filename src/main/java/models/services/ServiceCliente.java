package models.services;

import java.util.List;

import models.entities.ClienteEntity;


import models.repositories.ClienteRepository;

public class ServiceCliente {

    private ClienteRepository repository;

    public ServiceCliente() {
        this.repository = new ClienteRepository();
    }

    public Long createCliente(ClienteEntity entity) {
        Long clienteId = repository.create(entity);

        if (clienteId != null) {
            return clienteId;
        }
        return null;
    }

    public void update(ClienteEntity cliente){
        if(cliente != null){
            repository.update(cliente);
            System.out.println("Dados do cliente " + cliente.getNome()+ " atualizados com sucesso!");
        }
    }

    public void delete(Object entity){
        if(entity != null){
            repository.delete(entity);
            ClienteEntity cliente = (ClienteEntity) entity;
            System.out.println("Cliente " + cliente.getNome()+ " removido com sucesso");
        }
    }

    public List <ClienteEntity> listClientes() {
        List <ClienteEntity> listClientes = repository.findAll();
        if(listClientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado na base!");
            return null;
        }
            return listClientes;

    }

    public ClienteEntity findById(Long id){
        return repository.findById(id);
    }
}
