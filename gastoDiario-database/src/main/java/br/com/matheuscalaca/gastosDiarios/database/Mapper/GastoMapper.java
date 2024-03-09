package br.com.matheuscalaca.gastosDiarios.database.Mapper;

import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.database.entity.GastoEntity;
import br.com.matheuscalaca.gastosDiarios.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GastoMapper {
    private GastoMapper() {
    }

    public static GastoEntity toEntity(Gasto gasto) {
        GastoEntity gastoEntity = new GastoEntity();
        gastoEntity.setValor(gasto.getValor());
        gastoEntity.setNome(gasto.getNome());
        gastoEntity.setDataCompra(gasto.getDataCompra());
        gastoEntity.setUser(UserMapper.toEntity(gasto.getUser()));
        gastoEntity.setCategoria(CategoriaMapper.toEntity(gasto.getCategoria()));
        return gastoEntity;
    }

    public static Gasto toDomain(GastoEntity gastoEntity) {
        Gasto gasto = new Gasto();
        gasto.setValor(gastoEntity.getValor());
        gasto.setNome(gastoEntity.getNome());
        gasto.setDataCompra(gastoEntity.getDataCompra());
        gasto.setUser(UserMapper.toDomain(gastoEntity.getUser()));
        gasto.setCategoria(CategoriaMapper.toDomain(gastoEntity.getCategoria()));
        return gasto;
    }

}
