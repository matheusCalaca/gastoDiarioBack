package br.com.matheuscalaca.gastosDiarios.database.repository;

import br.com.matheuscalaca.gastosDiarios.database.entity.CategoriaEntity;
import br.com.matheuscalaca.gastosDiarios.database.entity.GastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
