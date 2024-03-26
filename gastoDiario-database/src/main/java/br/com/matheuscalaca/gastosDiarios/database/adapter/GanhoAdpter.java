package br.com.matheuscalaca.gastosDiarios.database.adapter;

import br.com.matheuscalaca.gastosDiarios.core.domain.Ganho;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.output.GanhoOutput;
import br.com.matheuscalaca.gastosDiarios.database.Mapper.CategoriaMapper;
import br.com.matheuscalaca.gastosDiarios.database.Mapper.GanhoMapper;
import br.com.matheuscalaca.gastosDiarios.database.Mapper.UserMapper;
import br.com.matheuscalaca.gastosDiarios.database.entity.CategoriaEntity;
import br.com.matheuscalaca.gastosDiarios.database.entity.GanhoEntity;
import br.com.matheuscalaca.gastosDiarios.database.entity.UserEntity;
import br.com.matheuscalaca.gastosDiarios.database.repository.CategoriaRepository;
import br.com.matheuscalaca.gastosDiarios.database.repository.GanhoRepository;
import br.com.matheuscalaca.gastosDiarios.database.repository.GastoRepository;
import br.com.matheuscalaca.gastosDiarios.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GanhoAdpter implements GanhoOutput {

    @Autowired
    private GanhoRepository ganhoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void creat(Ganho ganho) {
        Optional<UserEntity> user = userRepository.findById(ganho.getUser().getId());
        user.ifPresent(userEntity -> ganho.setUser(UserMapper.toDomain(userEntity)));

        Optional<CategoriaEntity> categoria = categoriaRepository.findById(ganho.getCategoria().getId());
        categoria.ifPresent(categoriaEntity -> ganho.setCategoria(CategoriaMapper.toDomain(categoriaEntity)));

        GanhoEntity ganhoEntity = GanhoMapper.toEntity(ganho);
        ganhoRepository.save(ganhoEntity);
    }

    @Override
    public List<Ganho> findByUserAndMonth(User user, Integer month, Integer year) {
        Optional<UserEntity> userEntity = userRepository.findById(user.getId());
        List<GanhoEntity> ganhoEntities = ganhoRepository.findByUserAndDataCompraMonth(userEntity.get(), month, year);

        List<Ganho> ganhos = new ArrayList<>();
        ganhoEntities.forEach(ganhoEntity -> {
            ganhos.add(GanhoMapper.toDomain(ganhoEntity));
        });

        return ganhos;
    }
}
