package models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SoftDelete;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name ="locacoes")
@SoftDelete(columnName = "deleted")
public class LocacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalDateTime dataFim;
    public LocalDateTime dataInicio;
    public float valorTotal;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoEntity veiculo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    public LocacaoEntity() {
    }

    public LocacaoEntity(Long id, LocalDateTime dataFim, LocalDateTime dataInicio, float valorTotal, VeiculoEntity veiculo, ClienteEntity cliente) {
        this.id = id;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.valorTotal = valorTotal;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public VeiculoEntity getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoEntity veiculo) {
        this.veiculo = veiculo;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
