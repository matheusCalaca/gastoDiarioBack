package br.com.matheuscalaca.gastosDiarios.api.JwtService;

import br.com.matheuscalaca.gastosDiarios.api.mapper.UserMapper;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.domain.UserAuthetication;
import br.com.matheuscalaca.gastosDiarios.core.input.GetUserByEmailInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    GetUserByEmailInput getUserByEmailInput;


    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserAuthetication user = getUserByEmailInput.execute(email);
        if (user == null) {
            throw new UsernameNotFoundException("could not found user..!!");
        }
        return userMapper.autenticationtoDto(user);

    }
}
