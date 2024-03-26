package br.com.matheuscalaca.gastosDiarios.api.mapper;

import br.com.matheuscalaca.gastosDiarios.api.dto.GanhoDto;
import br.com.matheuscalaca.gastosDiarios.api.dto.GastoDto;
import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.domain.Ganho;
import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import org.springframework.stereotype.Component;

@Component
public class GanhoMapper {
    public Ganho toEntity(GanhoDto ganhoDto) {
        Ganho ganho = new Ganho();

        User user = new User(ganhoDto.getUserId());
        Categoria categoria = new Categoria(ganhoDto.getCategoriaId());
        ganho.setUser(user);
        ganho.setCategoria(categoria);
        ganho.setData(ganhoDto.getData());
        ganho.setValor(ganhoDto.getValor());

        return ganho;
    }

}
