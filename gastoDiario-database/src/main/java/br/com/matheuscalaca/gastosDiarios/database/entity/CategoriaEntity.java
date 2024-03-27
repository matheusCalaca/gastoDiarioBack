package br.com.matheuscalaca.gastosDiarios.database.entity;

import br.com.matheuscalaca.gastosDiarios.core.domain.EnumTipoEntrada;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "CATEGORIA")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @Enumerated(EnumType.STRING)
    private EnumTipoEntrada entrada;

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

    public EnumTipoEntrada getEntrada() {
        return entrada;
    }

    public void setEntrada(EnumTipoEntrada entrada) {
        this.entrada = entrada;
    }
}
