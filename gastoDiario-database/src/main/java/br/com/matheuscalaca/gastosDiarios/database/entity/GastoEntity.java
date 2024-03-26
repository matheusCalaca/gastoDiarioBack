package br.com.matheuscalaca.gastosDiarios.database.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "GASTO")
public class GastoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Nonnull
    private UserEntity user;
    @Nonnull
    private String nome;
    @Nonnull
    private BigDecimal valor;
    @Nonnull
    @Column(name = "data")
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @Nonnull
    private CategoriaEntity categoria;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

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

    @Nonnull
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(@Nonnull BigDecimal valor) {
        this.valor = valor;
    }

    @Nonnull
    public LocalDate getData() {
        return data;
    }

    public void setData(@Nonnull LocalDate data) {
        this.data = data;
    }
}
