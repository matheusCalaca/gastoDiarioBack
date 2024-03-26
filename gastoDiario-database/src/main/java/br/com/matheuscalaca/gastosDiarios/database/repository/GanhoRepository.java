package br.com.matheuscalaca.gastosDiarios.database.repository;

import br.com.matheuscalaca.gastosDiarios.database.entity.GanhoEntity;
import br.com.matheuscalaca.gastosDiarios.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GanhoRepository extends JpaRepository<GanhoEntity, Long> {

    @Query("SELECT g FROM GanhoEntity g WHERE g.user = :user AND MONTH(g.data) = :month AND YEAR(g.data) = :yearDate")
    List<GanhoEntity> findByUserAndDataMonth(@Param("user") UserEntity user, @Param("month") int month, @Param("yearDate") int yearDate);
}
