package br.com.entidade;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author leomachadop
 */
@Entity
@Table
public class Estabelecimento implements Serializable {

    @OneToOne(mappedBy = "estabelecimento")
    private Seguimento seguimento;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String cnpj;

    @Column
    private String nome;

    @OneToOne
    private Endereco endereco;

    @OneToMany
    private List<Seguimento> seguimentos;

    public Seguimento getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(Seguimento seguimento) {
        this.seguimento = seguimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Seguimento> getSeguimentos() {
        return seguimentos;
    }

    public void setSeguimentos(List<Seguimento> seguimentos) {
        this.seguimentos = seguimentos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estabelecimento other = (Estabelecimento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
