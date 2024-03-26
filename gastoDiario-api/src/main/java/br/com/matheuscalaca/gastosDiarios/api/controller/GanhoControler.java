package br.com.matheuscalaca.gastosDiarios.api.controller;

import br.com.matheuscalaca.gastosDiarios.api.dto.GanhoDto;
import br.com.matheuscalaca.gastosDiarios.api.mapper.GanhoMapper;
import br.com.matheuscalaca.gastosDiarios.core.domain.Ganho;
import br.com.matheuscalaca.gastosDiarios.core.domain.Response;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.CreateGanhoInput;
import br.com.matheuscalaca.gastosDiarios.core.input.GetGanhoUserByMonthInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GanhoControler {

    @Autowired
    private CreateGanhoInput createGanhoInput;

    @Autowired
    private GetGanhoUserByMonthInput getGanhoUserByMonthInput;

    @Autowired
    private GanhoMapper ganhoMapper;

    @PostMapping("ganho")
    public ResponseEntity<Response> creatGanho(@RequestBody GanhoDto ganhoDto) {
        try {
            System.out.println("GANHO criar " + ganhoDto.toString());

            createGanhoInput.execute(ganhoMapper.toEntity(ganhoDto));
        } catch (ValidException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.ERROR_VALIDATION);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.SUCCESS);
    }

    @GetMapping("ganho/{userId}/{month}/{year}")
    public ResponseEntity<List<Ganho>> getGanhoByMonth(@PathVariable("userId") Long userId, @PathVariable("month") Integer month, @PathVariable("year") Integer year) {
        System.out.println("obetendo os dados Ganho");
        User user = new User();
        user.setId(userId);
        List<Ganho> ganhos = getGanhoUserByMonthInput.execute(user, month, year);

        return ResponseEntity.status(HttpStatus.OK).body(ganhos);
    }
}
