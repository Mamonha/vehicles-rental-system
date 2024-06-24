package controllers;

import models.entities.LocadoraEntity;

import models.services.ServiceLocadora;

import java.util.List;

public class LocadoraController {

    protected ServiceLocadora service = new ServiceLocadora();
    public Object create(LocadoraEntity locadora) {
        Object id = service.create(locadora);
        if (id != null) {
            return id;
        }
        return null;
    }

    public List<LocadoraEntity> index() {
        return service.listLocadoras();
    }

    public void delete(LocadoraEntity locadora){
        service.delete(locadora);
    }

    public LocadoraEntity findById(Long id){
        return service.findById(id);
    }

    public LocadoraEntity findByName(String name){
        return service.findByName(name);
    }

    public void update(LocadoraEntity locadora){
        service.update(locadora);
    }
}
