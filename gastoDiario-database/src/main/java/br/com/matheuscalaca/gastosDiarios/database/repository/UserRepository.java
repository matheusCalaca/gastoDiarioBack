package br.com.matheuscalaca.gastosDiarios.database.repository;

import br.com.matheuscalaca.gastosDiarios.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
