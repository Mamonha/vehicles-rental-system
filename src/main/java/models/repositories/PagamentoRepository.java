package models.repositories;

import enums.StatusPagamento;
import models.entities.ClienteEntity;
import models.entities.LocadoraEntity;
import models.entities.PagamentoEntity;

import java.util.List;

public class PagamentoRepository {
    private DAO<PagamentoEntity> dao;

    public PagamentoRepository(){
        dao = new DAO<>(PagamentoEntity.class);
    }

    public List<PagamentoEntity> findAll() {
        List<PagamentoEntity> pagamentos = dao.openConnection().findAll();
        dao.closeConnection();
        return pagamentos;
    }

    public Long create(Object object) {
        PagamentoEntity pagamento = (PagamentoEntity) object;
        dao.openConnection().insert(pagamento).closeConnection();
        Long pagamentoId = pagamento.getId();
        return pagamentoId;
    }

    public void updateStatus(Object object, StatusPagamento status){
        PagamentoEntity pagamento = (PagamentoEntity) object;
        pagamento.setStatus(status.getValor());
        dao.openConnection().update(pagamento);
        dao.closeConnection();
    }

    public PagamentoEntity findById(Object id) {
        PagamentoEntity pagamento = dao.openConnection().findById(id);
        dao.closeConnection();
        return pagamento;
    }
}
