package br.com.matheuscalaca.gastosDiarios.api.controller;

import br.com.matheuscalaca.gastosDiarios.api.dto.JwtRequestDto;
import br.com.matheuscalaca.gastosDiarios.api.dto.UserDto;
import br.com.matheuscalaca.gastosDiarios.api.dto.UserInfoDto;
import br.com.matheuscalaca.gastosDiarios.api.mapper.UserMapper;
import br.com.matheuscalaca.gastosDiarios.core.domain.Response;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.CreateUserInput;
import br.com.matheuscalaca.gastosDiarios.core.input.GetUserInput;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControler {

    @Autowired
    private CreateUserInput createUserInput;

    @Autowired
    private GetUserInput getUserInput;

    @Autowired
    private UserMapper userMapper;

    @Value("${security.jwt.secret-key}")
    public String SECRET;

    @PostMapping("user")
    public ResponseEntity<Response> creatUser(@RequestBody UserDto userDto) {
        try {
            createUserInput.execute(userMapper.toEntity(userDto), userDto.getPassword());
        } catch (ValidException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.ERROR_VALIDATION);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.SUCCESS);
    }

    @PostMapping("user/info")
    public ResponseEntity<UserInfoDto> info(@RequestBody JwtRequestDto jwtRequestDto) {
        try {
            System.out.println("obter info");
            // Analisando o token JWT
            Claims claims = Jwts.parser()
                    // Defina a chave secreta, se aplicável
                    .setSigningKey(SECRET)
                    // Passe o token JWT para análise
                    .parseClaimsJws(jwtRequestDto.getJwt())
                    // Obtenha as reivindicações (claims) do token
                    .getBody();

            // Agora você pode acessar os dados dos campos do token JWT
            String email = claims.get("sub", String.class);

            // Exemplo de uso dos dados
            System.out.println("email: " + email);

            User user = getUserInput.execute(email);

            UserInfoDto userInfoDto = userMapper.toInfoDto(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(userInfoDto);


        } catch (ValidException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
