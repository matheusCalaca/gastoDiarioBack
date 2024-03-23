package br.com.matheuscalaca.gastosDiarios.database.repository;

import br.com.matheuscalaca.gastosDiarios.database.entity.UserAuthenticationEntity;
import br.com.matheuscalaca.gastosDiarios.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthenticationEntity, Long> {

    @Query("""
            select ua from UserAuthenticationEntity ua
            where ua.user.email = :email
            """)
    Optional<UserAuthenticationEntity> findFirstByEmail(@Param("email") String email);

}
