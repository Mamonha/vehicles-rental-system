package models.repositories;

import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import models.entities.ClienteEntity;
import models.entities.LocadoraEntity;

public class LocadoraRepository implements BasicCrud {
    List<LocadoraRepository> bancoLocadora = new ArrayList<>();
    private DAO<LocadoraEntity> dao;

    public LocadoraRepository() {
        dao = new DAO<>(LocadoraEntity.class);
    }

    @Override
    public Long create(Object object) {
        LocadoraEntity locadora = (LocadoraEntity) object;
        dao.openConnection().insert(locadora).closeConnection();
        Long locadoraId = locadora.getId();
        return locadoraId;
    }

    @Override
    public LocadoraEntity findById(Object id) {
        LocadoraEntity locadora = dao.openConnection().findById(id);
        dao.closeConnection();
        return locadora;
    }

    @Override
    public Object update(Object object) {
        LocadoraEntity locadora = (LocadoraEntity) object;
        dao.openConnection().update(locadora);
        dao.closeConnection();
        return null;
    }

    @Override
    public void delete(Object object) {
        dao.openConnection().delete((LocadoraEntity) object);
        dao.closeConnection();
    }

    public List<LocadoraEntity> findAll() {
        List <LocadoraEntity> locadoraList = dao.openConnection().findAll();
        dao.closeConnection();
        return locadoraList;
    }

    public boolean existsAny() {
        return !findAll().isEmpty();
    }

}