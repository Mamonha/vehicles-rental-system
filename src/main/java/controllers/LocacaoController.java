package controllers;

import models.entities.ClienteEntity;
import models.entities.LocacaoEntity;
import models.services.ServiceLocacao;

import java.util.List;

public class LocacaoController {

    protected ServiceLocacao service = new ServiceLocacao();
    public Object create(LocacaoEntity locacaoData){
        Object id = service.create(locacaoData);
        return id;
    }

    public List<LocacaoEntity> index() {
        return service.listLocacoes();
    }

    public void delete(LocacaoEntity locacao){
        service.delete(locacao);
    }

    public LocacaoEntity findById(Long id){
        return service.findById(id);
    }
    public void update(LocacaoEntity locacao){
        service.update(locacao);
    }

    public void encerrarLocacao(Long idLocacao){
        LocacaoEntity locacao = service.findById(idLocacao);
        service.delete(locacao);
    }

}
