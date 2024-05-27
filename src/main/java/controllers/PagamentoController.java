package controllers;

import enums.StatusPagamento;
import models.entities.ClienteEntity;
import models.entities.PagamentoEntity;
import models.services.ServicePagamento;

import java.util.List;

public class PagamentoController {
    protected ServicePagamento servicePagamento = new ServicePagamento();

    public Object create(PagamentoEntity pagamentoData) {
        Object id = servicePagamento.create(pagamentoData);
        if (id != null) {
            System.out.println("Pagamento criado com sucesso!");
            return id;
        }
        return null;
    }

    public List<PagamentoEntity> index() {
        return servicePagamento.listPagamentos();
    }

    public void updateStatus(Long idPagamento, int status){
        servicePagamento.updateStatus(idPagamento, status);
    }

}
