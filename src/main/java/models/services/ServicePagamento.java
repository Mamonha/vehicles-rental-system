package models.services;

import enums.StatusPagamento;
import models.entities.LocadoraEntity;
import models.entities.PagamentoEntity;
import models.repositories.LocadoraRepository;
import models.repositories.PagamentoRepository;

import java.util.List;

public class ServicePagamento {

    private PagamentoRepository repository;

        public ServicePagamento(){
            this.repository = new PagamentoRepository();
        }


    public Long create(PagamentoEntity entity) {
        Long pagamentoId = repository.create(entity);

        if (pagamentoId != null) {
            System.out.println("Pagamento criado com sucesso!");
            return pagamentoId;
        }
        return null;
    }

    public List<PagamentoEntity> listPagamentos() {
            List<PagamentoEntity> pagamentos = repository.findAll();
            if(pagamentos.isEmpty()){
                System.out.println("Nenhum pagamento registrado!");
                return null;
            }
        return repository.findAll();
    }

    public void updateStatus(Long pagamentoId, int status){
            PagamentoEntity pagamento = this.findById(pagamentoId);
            StatusPagamento statusConverted = StatusPagamento.deInt(status);
            if (pagamento != null && statusConverted != null){
                repository.updateStatus(pagamento, statusConverted);
                System.out.println("Status do pagamento atualizado para " + statusConverted);
            }
    }

    public List<PagamentoEntity> listPagamentosClientes(){
        List<PagamentoEntity> pagamentos = repository.findAll();
        if(pagamentos.isEmpty()){
            System.out.println("Nenhum pagamento registrado!");
            return null;
        }
        return repository.findAll();
    }

    public PagamentoEntity findById(Long id){
        return repository.findById(id);
    }
}
