package models.services;

import models.entities.LocadoraEntity;

import models.repositories.LocadoraRepository;

import java.util.List;

public class ServiceLocadora {


    private LocadoraRepository repository;

    public ServiceLocadora() {
        this.repository = new LocadoraRepository();
    }

    public Long create(LocadoraEntity entity) {
        Long locadoraId = repository.create(entity);

        if (locadoraId != null) {
            System.out.println("Locadora criada com sucesso!");
            return locadoraId;
        }
        return null;
    }

    public void update(LocadoraEntity locadora){
        if(locadora != null){
            repository.update(locadora);
            System.out.println("Dados da locadora " + locadora.getNome()+ " atualizados com sucesso!");
        }
    }

    public void delete(Object entity){

        if(entity != null){
            List<LocadoraEntity> allLocadoras = repository.findAll();
            int quantidadeDeLocadoras = allLocadoras.size();
            if (quantidadeDeLocadoras > 1) {
                repository.delete(entity);
                LocadoraEntity locadora = (LocadoraEntity) entity;
                System.out.println("Locadora " + locadora.getNome()+ " removido com sucesso");

            }else {
                System.out.println("Não é possível deletar todas as locadoras. Pelo menos uma deve permanecer registrada no sistema.");
            }
        }
    }

    public List<LocadoraEntity> listLocadoras() {
        return repository.findAll();
    }

    public LocadoraEntity findById(Long id){
        return repository.findById(id);
    }

}
