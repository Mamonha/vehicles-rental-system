package controllers;

import java.util.List;

import models.entities.ClienteEntity;
import models.entities.VeiculoEntity;
import models.services.ServiceCliente;

public class ClienteController {

    protected ServiceCliente service = new ServiceCliente();
    public Object create(ClienteEntity clienteData) {
        Object id = service.createCliente(clienteData);
        if (id != null) {
            return id;
        }
        return null;
    }

    public List <ClienteEntity> index() {
        return service.listClientes();
    }

    public void delete(ClienteEntity cliente){
        service.delete(cliente);
    }

    public ClienteEntity findById(Long id){
        return service.findById(id);
    }

    public void update(ClienteEntity cliente){
        service.update(cliente);
    }

}