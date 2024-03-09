package br.com.matheuscalaca.gastosDiarios.database.adapter;

import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.output.GastoOutput;
import br.com.matheuscalaca.gastosDiarios.database.Mapper.CategoriaMapper;
import br.com.matheuscalaca.gastosDiarios.database.Mapper.GastoMapper;
import br.com.matheuscalaca.gastosDiarios.database.Mapper.UserMapper;
import br.com.matheuscalaca.gastosDiarios.database.entity.CategoriaEntity;
import br.com.matheuscalaca.gastosDiarios.database.entity.GastoEntity;
import br.com.matheuscalaca.gastosDiarios.database.entity.UserEntity;
import br.com.matheuscalaca.gastosDiarios.database.repository.CategoriaRepository;
import br.com.matheuscalaca.gastosDiarios.database.repository.GastoRepository;
import br.com.matheuscalaca.gastosDiarios.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GastoAdpter implements GastoOutput {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void creat(Gasto gasto) {

        Optional<UserEntity> user = userRepository.findById(gasto.getUser().getId());
        user.ifPresent(userEntity -> gasto.setUser(UserMapper.toDomain(userEntity)));

        Optional<CategoriaEntity> categoria = categoriaRepository.findById(gasto.getCategoria().getId());
        categoria.ifPresent(categoriaEntity -> gasto.setCategoria(CategoriaMapper.toDomain(categoriaEntity)));

        GastoEntity gastoEntity = GastoMapper.toEntity(gasto);
        gastoRepository.save(gastoEntity);
    }

    @Override
    public List<Gasto> findByUserAndMonth(User user, Integer month) {
        Optional<UserEntity> userEntity = userRepository.findById(user.getId());
        List<GastoEntity> gastosEntity = gastoRepository.findByUserAndDataCompraMonth(userEntity.get(), month);

        List<Gasto> gastos = new ArrayList<>();
        gastosEntity.forEach(gastoEntity -> {
            gastos.add(GastoMapper.toDomain(gastoEntity));
        });

        return gastos;
    }
}
