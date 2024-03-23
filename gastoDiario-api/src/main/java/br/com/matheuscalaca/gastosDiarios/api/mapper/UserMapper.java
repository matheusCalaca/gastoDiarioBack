package br.com.matheuscalaca.gastosDiarios.api.mapper;

import br.com.matheuscalaca.gastosDiarios.api.dto.UserDto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
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
        // TODO alterar para buscar do BD
        userDto.setPassword(new BCryptPasswordEncoder().encode("123"));

        return userDto;
    }

}
