package br.com.matheuscalaca.gastosDiarios.api.controller;

import br.com.matheuscalaca.gastosDiarios.core.domain.ResumoGasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.input.GetResumoGastoUserByMonthInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumoGastoControler {

    @Autowired
    private GetResumoGastoUserByMonthInput getResumoGastoUserByMonthInput;

    @GetMapping("resumo/{userId}/{month}/{year}")
    public ResponseEntity<ResumoGasto> getGastosByMonth(@PathVariable("userId") Long userId, @PathVariable("month") Integer month, @PathVariable("year") Integer year) {
        System.out.println("obetendo os dados de resumo");
        User user = new User();
        user.setId(userId);
        ResumoGasto resumoGasto = getResumoGastoUserByMonthInput.execute(user, month, year);

        return ResponseEntity.status(HttpStatus.OK).body(resumoGasto);
    }
}
