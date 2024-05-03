package br.com.matheuscalaca.gastosDiarios.database.adapter;

import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.domain.UserAuthetication;
import br.com.matheuscalaca.gastosDiarios.core.output.UserOutput;
import br.com.matheuscalaca.gastosDiarios.database.Mapper.UserAuthentiocationMapper;
import br.com.matheuscalaca.gastosDiarios.database.Mapper.UserMapper;
import br.com.matheuscalaca.gastosDiarios.database.entity.UserAuthenticationEntity;
import br.com.matheuscalaca.gastosDiarios.database.entity.UserEntity;
import br.com.matheuscalaca.gastosDiarios.database.repository.UserAuthenticationRepository;
import br.com.matheuscalaca.gastosDiarios.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAdapter implements UserOutput {

    @Autowired
    private UserAuthenticationRepository userAuthenticationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void creat(User user, String password) {
        UserEntity userEntity = UserMapper.toEntity(user);

        UserAuthenticationEntity userAuthenticationEntity =
                new UserAuthenticationEntity(
                        userEntity,
                        new BCryptPasswordEncoder().encode(password)
                );
        userAuthenticationRepository.save(userAuthenticationEntity);
    }

    @Override
    public UserAuthetication findByEmail(String email) {
        Optional<UserAuthenticationEntity> userEntity = userAuthenticationRepository.findFirstByEmail(email);

        return userEntity.map(UserAuthentiocationMapper::toDomain).orElse(null);

    }

    @Override
    public User findUserByEmail(String email) {
        Optional<UserEntity> userEntity = userRepository.findFirstByEmail(email);
        return userEntity.map(UserMapper::toDomain).orElse(null);
    }
}
