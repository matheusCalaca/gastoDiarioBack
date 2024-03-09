package br.com.matheuscalaca.gastosDiarios.database.adapter;

import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.output.UserOutput;
import br.com.matheuscalaca.gastosDiarios.database.Mapper.UserMapper;
import br.com.matheuscalaca.gastosDiarios.database.entity.UserEntity;
import br.com.matheuscalaca.gastosDiarios.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter implements UserOutput {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void creat(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        userRepository.save(userEntity);
    }
}
