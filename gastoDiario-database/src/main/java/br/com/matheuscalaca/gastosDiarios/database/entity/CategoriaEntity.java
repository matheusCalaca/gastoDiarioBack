package br.com.matheuscalaca.gastosDiarios.database.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIA")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nonnull
    public String getNome() {
        return nome;
    }

    public void setNome(@Nonnull String nome) {
        this.nome = nome;
    }
}
