package br.com.matheuscalaca.gastosDiarios.api.controller;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.input.GetCategoriaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriControler {

    @Autowired
    private GetCategoriaInput getCategoriaInput;

    @GetMapping("categoria")
    public ResponseEntity<List<Categoria>> getCategoria() {
        System.out.println("obetendo os dados de Categria");

        return ResponseEntity.status(HttpStatus.OK).body(getCategoriaInput.all());
    }
}
