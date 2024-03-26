package br.com.matheuscalaca.gastosDiarios.database.Mapper;

import br.com.matheuscalaca.gastosDiarios.core.domain.Ganho;
import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.database.entity.GanhoEntity;
import br.com.matheuscalaca.gastosDiarios.database.entity.GastoEntity;

public class GanhoMapper {
    private GanhoMapper() {
    }

    public static GanhoEntity toEntity(Ganho ganho) {
        GanhoEntity ganhoEntity = new GanhoEntity();
        ganhoEntity.setValor(ganho.getValor());
        ganhoEntity.setData(ganho.getData());
        ganhoEntity.setUser(UserMapper.toEntity(ganho.getUser()));
        ganhoEntity.setCategoria(CategoriaMapper.toEntity(ganho.getCategoria()));
        return ganhoEntity;
    }

    public static Ganho toDomain(GanhoEntity entity) {
        Ganho ganho = new Ganho();
        ganho.setValor(entity.getValor());
        ganho.setData(entity.getData());
        ganho.setUser(UserMapper.toDomain(entity.getUser()));
        ganho.setCategoria(CategoriaMapper.toDomain(entity.getCategoria()));
        return ganho;
    }

}
