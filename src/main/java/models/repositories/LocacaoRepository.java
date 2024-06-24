package models.repositories;

import models.entities.ClienteEntity;
import models.entities.LocacaoEntity;

import java.util.ArrayList;
import java.util.List;

public class LocacaoRepository implements BasicCrud{

    List<LocacaoEntity> bancoLocacoes = new ArrayList<>();
    private DAO<LocacaoEntity> dao;

    public LocacaoRepository() {
        dao = new DAO<>(LocacaoEntity.class);
    }

    @Override
    public Long create(Object object) {
        LocacaoEntity locacao = (LocacaoEntity) object;
        dao.openConnection().insert(locacao);
        dao.closeConnection();
        Long locacaoId = locacao.getId();
        return locacaoId;
    }

    @Override
    public Object update(Object object) {
        LocacaoEntity locacao = (LocacaoEntity) object;
        dao.openConnection().update(locacao);
        dao.closeConnection();
        return null;
    }

    @Override
    public Object findById(Object id) {
        LocacaoEntity locacao = dao.openConnection().findById(id);
        dao.closeConnection();
        return locacao;
    }

    @Override
    public void delete(Object entity) {
        dao.openConnection().delete((LocacaoEntity) entity);
        dao.closeConnection();
    }

    public List<LocacaoEntity> findAll(){
        List<LocacaoEntity> locacoes = dao.openConnection().findAll();
        dao.closeConnection();
        return locacoes;
    }
    
}
