package br.com.matheuscalaca.gastosDiarios.database.Mapper;

import br.com.matheuscalaca.gastosDiarios.core.domain.UserAuthetication;
import br.com.matheuscalaca.gastosDiarios.database.entity.UserAuthenticationEntity;

public class UserAuthentiocationMapper {
    private UserAuthentiocationMapper() {
    }

//    public static UserAuthetication toEntity(User user, String password) {
//        UserAuthetication userEntity = new UserAuthetication();
//        userEntity.setId(user.getId());
//        userEntity.setCpf(user.getCpf());
//        userEntity.setEmail(user.getEmail());
//        userEntity.setNome(user.getNome());
//        return userEntity;
//    }
//
    public static UserAuthetication toDomain(UserAuthenticationEntity entity) {
        UserAuthetication user = new UserAuthetication();
        user.setUser(UserMapper.toDomain(entity.getUser()));
        user.setPassword(entity.getPassword());
        return user;
    }

}
