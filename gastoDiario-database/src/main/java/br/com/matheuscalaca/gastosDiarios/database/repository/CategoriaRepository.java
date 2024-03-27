package br.com.matheuscalaca.gastosDiarios.database.repository;

import br.com.matheuscalaca.gastosDiarios.core.domain.EnumTipoEntrada;
import br.com.matheuscalaca.gastosDiarios.database.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    @Query("""
            select c from CategoriaEntity c where c.entrada = :entrada
            """)
    List<CategoriaEntity> findAllByEntrada(@Param("entrada") EnumTipoEntrada entrada);
}
