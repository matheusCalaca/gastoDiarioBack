package br.com.matheuscalaca.gastosDiarios.api.mapper;

import br.com.matheuscalaca.gastosDiarios.api.dto.UserDto;
import br.com.matheuscalaca.gastosDiarios.api.dto.UserInfoDto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.domain.UserAuthetication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setCpf(userDto.getCpf());
        user.setNome(userDto.getNome());
        user.setEmail(userDto.getEmail());

        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setCpf(user.getCpf());
        userDto.setNome(user.getNome());
        userDto.setEmail(user.getEmail());

        return userDto;
    }


    public UserInfoDto toInfoDto(User user) {
        UserInfoDto userDto = new UserInfoDto();
        userDto.setId(user.getId());
        userDto.setCpf(user.getCpf());
        userDto.setNome(user.getNome());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    public UserDto autenticationtoDto(UserAuthetication userAuthetication) {
        UserDto userDto = new UserDto();
        User user = userAuthetication.getUser();
        userDto.setCpf(user.getCpf());
        userDto.setNome(user.getNome());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(userAuthetication.getPassword());

        return userDto;
    }

}
