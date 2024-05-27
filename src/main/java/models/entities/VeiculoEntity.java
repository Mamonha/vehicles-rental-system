package models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SoftDelete;

import java.util.List;

@Entity
@Table(name = "veiculos")
@SoftDelete(columnName = "deleted")
public class VeiculoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String modelo;
    public int ano;
    public String placa;
    public boolean disponivel;
    public float custoPorDia;
    public int quilometragem;

    public List<LocacaoEntity> getLocacoes() {
        return locacoes;
    }

    @ManyToOne
    @JoinColumn(name = "locadora_id")
    private LocadoraEntity locadora;

    @OneToMany(mappedBy = "veiculo")
    private List<LocacaoEntity> locacoes;

    public VeiculoEntity() {
    }

    public VeiculoEntity(String modelo, int ano, String placa, boolean disponivel, float custoPorDia, int quilometragem, LocadoraEntity locadora) {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.disponivel = disponivel;
        this.custoPorDia = custoPorDia;
        this.quilometragem = quilometragem;
        this.locadora = locadora;
    }

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocacoes(List<LocacaoEntity> locacoes) {
        this.locacoes = locacoes;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public float getCustoPorDia() {
        return custoPorDia;
    }

    public void setCustoPorDia(float custoPorDia) {
        this.custoPorDia = custoPorDia;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public LocadoraEntity getLocadora() {
        return locadora;
    }

    public void setLocadora(LocadoraEntity locadora) {
        this.locadora = locadora;
    }

}