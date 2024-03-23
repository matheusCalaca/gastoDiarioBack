package br.com.matheuscalaca.gastosDiarios.database.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "GASTO")
public class GastoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gasto_seq_gen")
    @SequenceGenerator(name = "gasto_seq_gen", sequenceName = "gastodiario.gasto_seq", allocationSize = 1)
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
    @Column(name = "data_compra")
    private LocalDate dataCompra;
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
    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(@Nonnull LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }
}
