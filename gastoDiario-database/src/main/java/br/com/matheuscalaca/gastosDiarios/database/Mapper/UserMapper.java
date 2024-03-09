package br.com.matheuscalaca.gastosDiarios.database.Mapper;

import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.database.entity.UserEntity;

public class UserMapper {
    private UserMapper() {
    }

    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setCpf(user.getCpf());
        userEntity.setEmail(user.getEmail());
        userEntity.setNome(user.getNome());
        return userEntity;
    }

    public static User toDomain(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setNome(userEntity.getNome());
        user.setEmail(userEntity.getEmail());
        user.setCpf(userEntity.getCpf());
        return user;
    }

}
