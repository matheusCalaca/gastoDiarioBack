package br.com.matheuscalaca.gastosDiarios.api.mapper;

import br.com.matheuscalaca.gastosDiarios.api.dto.GastoDto;
import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import org.springframework.stereotype.Component;

@Component
public class GastoMapper {
    public Gasto toEntity(GastoDto gastoDto) {
        Gasto gasto = new Gasto();

        User user = new User(gastoDto.getUserId());
        Categoria categoria = new Categoria(gastoDto.getCategoriaId());
        gasto.setUser(user);
        gasto.setCategoria(categoria);
        gasto.setNome(gastoDto.getNome());
        gasto.setDataCompra(gastoDto.getDataCompra());
        gasto.setValor(gastoDto.getValor());

        return gasto;
    }

}
