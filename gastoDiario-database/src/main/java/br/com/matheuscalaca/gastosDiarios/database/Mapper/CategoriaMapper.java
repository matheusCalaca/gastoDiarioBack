package br.com.matheuscalaca.gastosDiarios.database.Mapper;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.database.entity.CategoriaEntity;

public class CategoriaMapper {
    private CategoriaMapper() {
    }

    public static CategoriaEntity toEntity(Categoria categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(categoria.getId());
        categoriaEntity.setNome(categoria.getCategoria());

        return categoriaEntity;
    }

    public static Categoria toDomain(CategoriaEntity categoriaEntity) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaEntity.getId());
        categoria.setCategoria(categoriaEntity.getNome());
        return categoria;
    }

}
