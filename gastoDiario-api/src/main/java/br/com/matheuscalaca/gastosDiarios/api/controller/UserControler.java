package br.com.matheuscalaca.gastosDiarios.api.controller;

import br.com.matheuscalaca.gastosDiarios.api.dto.UserDto;
import br.com.matheuscalaca.gastosDiarios.api.mapper.UserMapper;
import br.com.matheuscalaca.gastosDiarios.core.domain.Response;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.domain.UserAuthetication;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.CreateUserInput;
import br.com.matheuscalaca.gastosDiarios.core.input.GetUserByEmailInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserControler {

    @Autowired
    private CreateUserInput createUserInput;

    @Autowired
    private GetUserByEmailInput getUserByEmailInput;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("user")
    public ResponseEntity<Response> creatUser(@RequestBody UserDto userDto) {
        try {
            createUserInput.execute(userMapper.toEntity(userDto), userDto.getPassword());
        } catch (ValidException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.ERROR_VALIDATION);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.SUCCESS);
    }

}
