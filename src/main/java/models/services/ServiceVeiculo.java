package models.services;


import jakarta.transaction.Transactional;
import models.entities.LocacaoEntity;
import models.entities.LocadoraEntity;
import models.entities.VeiculoEntity;

import models.repositories.VeiculoRepository;

import java.util.List;

public class ServiceVeiculo {

    private VeiculoRepository repository;

    public ServiceVeiculo() {
        this.repository = new VeiculoRepository();
    }

    public Long create(VeiculoEntity entity) {
        Long veiculoId = repository.create(entity);
        if (veiculoId != null) {
            System.out.println("Veiculo criado com sucesso!");
            return veiculoId;
        }
        return null;
    }

    public void update(VeiculoEntity veiculo){
        if(veiculo != null){
            repository.update(veiculo);
            System.out.println("Dados do veiculo " + veiculo.getModelo()+ " atualizados com sucesso!");
        }
    }

    public void delete(Object entity){
        if(entity != null){
            repository.delete(entity);
            VeiculoEntity veiculo = (VeiculoEntity) entity;
            System.out.println("Veiculo " + veiculo.getModelo()+ " removido com sucesso");
        }
    }

    public List<VeiculoEntity> listVeiculos() {
        return repository.findAll();
    }

    public VeiculoEntity findById(Long id){
        return repository.findById(id);
    }

    public List<VeiculoEntity> listVeiculosDisponiveis() {
        return repository.findDisponiveis();
    }

    @Transactional
    public void changeStatus(Object entity){

        VeiculoEntity veiculo = (VeiculoEntity) entity;

        LocadoraEntity locadora = veiculo.getLocadora();
        veiculo.setDisponivel(false);
        veiculo.setLocadora(locadora);
        repository.changeStatus(veiculo);
    }

    public VeiculoEntity findByModelo(String modelo){
        return repository.findByModelo(modelo);
    }



}
