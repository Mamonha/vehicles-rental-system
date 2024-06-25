package models.repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import	models.entities.VeiculoEntity;

public class VeiculoRepository implements BasicCrud {

    List<VeiculoEntity> bancoVeiculos = new ArrayList<>();
    private DAO<VeiculoEntity> dao;

    public VeiculoRepository() {
        dao = new DAO<>(VeiculoEntity.class);
    }

    @Override
    public Long create(Object object) {
        VeiculoEntity veiculo = (VeiculoEntity)object;
        if(veiculo != null) {
            dao.openConnection().insert(veiculo).closeConnection();
            Long veiculoId = veiculo.getId();
            return veiculoId;
        }
        return null;
    }

    @Override
    public VeiculoEntity findById(Object id) {
        VeiculoEntity veiculo = dao.openConnection().findById(id);
        dao.closeConnection();

        return veiculo;
    }

    public List<VeiculoEntity> findAll(){
        List<VeiculoEntity> veiculos = dao.openConnection().findAll();
        dao.closeConnection();
        return veiculos;
    }

    public List<VeiculoEntity> findDisponiveis(){
        return bancoVeiculos.stream().filter(VeiculoEntity::isDisponivel).collect(Collectors.toList());
    }

    @Override
    public Object update(Object object) {
        VeiculoEntity veiculo = (VeiculoEntity) object;
        dao.openConnection().update(veiculo);
        dao.closeConnection();
        return null;
    }

    @Override
    public void delete(Object entity) {
        dao.openConnection().delete((VeiculoEntity) entity);
        dao.closeConnection();
    }

    public void changeStatus(VeiculoEntity veiculo){
        dao.openConnection().update(veiculo);
        dao.closeConnection();
    }

    public VeiculoEntity findByModelo(String modelo) {
        VeiculoEntity veiculo = dao.openConnection().findByModelo(modelo);
        dao.closeConnection();
        return veiculo;
    }

}