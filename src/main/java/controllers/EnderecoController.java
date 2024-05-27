package controllers;

import models.entities.EnderecoAPI;
import models.entities.EnderecoEntity;
import models.services.ServiceCliente;
import models.services.ServiceEndereco;

public class EnderecoController {

    protected ServiceEndereco service = new ServiceEndereco();

    public EnderecoAPI findEndereco(String cep){
        return service.findEndereco(cep);
    }

    public void create(EnderecoEntity endereco){
        service.create(endereco);
    }

    public void update(EnderecoEntity endereco){
        service.update(endereco);
    }
}
