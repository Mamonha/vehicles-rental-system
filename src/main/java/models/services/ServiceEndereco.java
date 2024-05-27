package models.services;

import models.entities.EnderecoAPI;
import models.entities.EnderecoEntity;
import models.repositories.ClienteRepository;
import models.repositories.EnderecoRepository;

public class ServiceEndereco {

    private EnderecoRepository repository;
    public ServiceEndereco() {
        this.repository = new EnderecoRepository();
    }

    public EnderecoAPI findEndereco(String cep){
           EnderecoAPI response = repository.findEndereco(cep);
           if(response == null){
               System.out.println("Algum problema ocorreu verifique se o CEP inserido e valido!");
               return null;
           }
           return repository.findEndereco(cep);
    }

    public void create(EnderecoEntity endereco){
        repository.create(endereco);
    }

    public void update(EnderecoEntity endereco){
        repository.update(endereco);
    }
}
