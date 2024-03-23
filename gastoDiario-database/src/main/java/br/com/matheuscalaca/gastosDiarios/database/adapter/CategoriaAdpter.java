package br.com.matheuscalaca.gastosDiarios.database.adapter;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.output.CategoriaOutput;
import br.com.matheuscalaca.gastosDiarios.database.Mapper.CategoriaMapper;
import br.com.matheuscalaca.gastosDiarios.database.entity.CategoriaEntity;
import br.com.matheuscalaca.gastosDiarios.database.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaAdpter implements CategoriaOutput {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> all() {
        List<Categoria> categoriaList = categoriaRepository.findAll().stream().map(categoriaEntity -> {
            return CategoriaMapper.toDomain(categoriaEntity);
        }).collect(Collectors.toList());
        return categoriaList;
    }
}
