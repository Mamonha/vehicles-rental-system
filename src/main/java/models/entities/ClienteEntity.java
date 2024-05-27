package models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SoftDelete;

import java.util.List;

@Entity
@Table(name = "clientes")
@SoftDelete(columnName = "deleted")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    public String nome;
    public String telefone;
    public String email;

    @ManyToOne
    @JoinColumn(name = "locadora_id")
    private LocadoraEntity locadora;

    @OneToMany(mappedBy = "cliente")
    private List<LocacaoEntity> locacoes;

    @OneToOne(mappedBy = "cliente")
    private EnderecoEntity endereco;

    public ClienteEntity() {
    }

    @PreRemove
    private void preRemove() {
        if (locadora != null) {
            locadora.getClientes().remove(this);
            this.locadora = null;
        }
    }

    public ClienteEntity(String nome, String telefone, String email, LocadoraEntity locadora) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.locadora = locadora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocadoraEntity getLocadora() {
        return locadora;
    }

    public void setLocadora(LocadoraEntity locadora) {
        this.locadora = locadora;
    }

}