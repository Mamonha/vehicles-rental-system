package models.services;

import enums.StatusPagamento;
import models.entities.*;

import models.repositories.LocacaoRepository;
import models.repositories.PagamentoRepository;
import models.repositories.VeiculoRepository;

import java.time.LocalDate;
import java.util.List;

public class ServiceLocacao {
    private LocacaoRepository repository;
    private PagamentoRepository repositoryPagamento = new PagamentoRepository();
    private VeiculoRepository repositoryVeiculo = new VeiculoRepository();
    public ServiceLocacao() {
        this.repository = new LocacaoRepository();
    }

    public Long create(LocacaoEntity locacao) {
        LocalDate now = LocalDate.now();

        Long locacaoId = repository.create(locacao);
        LocacaoEntity locacaoData = (LocacaoEntity) repository.findById(locacaoId);
        PagamentoEntity pagamento = new PagamentoEntity();

        if (locacao != null) {
            pagamento.setStatus(StatusPagamento.PENDENTE.getValor());
            pagamento.setCliente(locacaoData.getCliente());
            pagamento.setTotal(locacaoData.getValorTotal());
            pagamento.setData(now);

            repositoryPagamento.create(pagamento);

            System.out.println("Locacao registrada com sucesso!");
            return locacao.getId();
        }
        return null;
    }

    public void update(LocacaoEntity locacao){
        if(locacao != null){
            repository.update(locacao);
            System.out.println("Dados da locacao " + locacao.getId() + " atualizados com sucesso!");
        }
    }

    public void delete(LocacaoEntity locacao){
        if(locacao != null){
            VeiculoEntity veiculo = locacao.getVeiculo();
            veiculo.setDisponivel(true);
            System.out.println(veiculo.getLocadora());
            veiculo.setLocadora(veiculo.getLocadora());

            if(veiculo != null){
                veiculo.setDisponivel(true);
                repositoryVeiculo.changeStatus(veiculo);
            }
            repository.delete(locacao);
            System.out.println("Locacao " + locacao.getId()+ " encerrada com sucesso");
        }
    }

    public List<LocacaoEntity> listLocacoes() {
        return repository.findAll();
    }

    public LocacaoEntity findById(Long id){
        return (LocacaoEntity) repository.findById(id);
    }
}
