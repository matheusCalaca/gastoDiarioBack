package br.com.matheuscalaca.gastosDiarios.api.controller;

import br.com.matheuscalaca.gastosDiarios.api.dto.GastoDto;
import br.com.matheuscalaca.gastosDiarios.api.mapper.GastoMapper;
import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.Response;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.CreateGastoInput;
import br.com.matheuscalaca.gastosDiarios.core.input.GetGastoUserByMonthInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GastoControler {

    @Autowired
    private CreateGastoInput createGastoInput;

    @Autowired
    private GetGastoUserByMonthInput getGastoUserByMonthInput;

    @Autowired
    private GastoMapper gastoMapper;

    @PostMapping("gasto")
    public ResponseEntity<Response> creatGasto(@RequestBody GastoDto gastoDto) {
        try {
            System.out.println("criar "+gastoDto.toString());

            createGastoInput.execute(gastoMapper.toEntity(gastoDto));
        } catch (ValidException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.ERROR_VALIDATION);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.SUCCESS);
    }

    @GetMapping("gasto/{userId}/{month}/{year}")
    public ResponseEntity<List<Gasto>> getGastosByMonth(@PathVariable("userId") Long userId, @PathVariable("month") Integer month, @PathVariable("year") Integer year) {
        System.out.println("obetendo os dados");
        User user = new User();
        user.setId(userId);
        List<Gasto> gastos = getGastoUserByMonthInput.execute(user, month, year);

        return ResponseEntity.status(HttpStatus.CREATED).body(gastos);
    }
}
