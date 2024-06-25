package controllers;

import models.entities.VeiculoEntity;

import models.services.ServiceVeiculo;

import java.util.List;

public class VeiculoController {
    protected ServiceVeiculo service = new ServiceVeiculo();

    public Object create(VeiculoEntity veiculoData) {
        Object id = service.create(veiculoData);
        if (id != null) {
            return id;
        }
        return null;
    }

    public List<VeiculoEntity> index() {
        return service.listVeiculos();
    }

    public void delete(VeiculoEntity veiculo){
        service.delete(veiculo);
    }

    public VeiculoEntity findById(Long id){
        return service.findById(id);
    }

    public void update(VeiculoEntity veiculo){
        service.update(veiculo);
    }

    public List<VeiculoEntity> indexDisponiveis() {
        System.out.println("37" + service.listVeiculosDisponiveis());
        return service.listVeiculosDisponiveis();
    }

    public void changeStatus(Object entity){
        service.changeStatus(entity);
    }

    public VeiculoEntity findByModelo(String modelo){
        return service.findByModelo(modelo);
    }
}
