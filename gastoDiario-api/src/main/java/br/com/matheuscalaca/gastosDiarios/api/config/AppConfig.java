package br.com.matheuscalaca.gastosDiarios.api.config;

import br.com.matheuscalaca.gastosDiarios.core.input.CreateGastoInput;
import br.com.matheuscalaca.gastosDiarios.core.input.CreateUserInput;
import br.com.matheuscalaca.gastosDiarios.core.input.GetGastoUserByMonthInput;
import br.com.matheuscalaca.gastosDiarios.core.output.GastoOutput;
import br.com.matheuscalaca.gastosDiarios.core.output.UserOutput;
import br.com.matheuscalaca.gastosDiarios.core.useCase.CreateGastoUseCase;
import br.com.matheuscalaca.gastosDiarios.core.useCase.CreateUserUseCase;
import br.com.matheuscalaca.gastosDiarios.core.useCase.GetGastoUserByMonthUseCase;
import br.com.matheuscalaca.gastosDiarios.database.adapter.GastoAdpter;
import br.com.matheuscalaca.gastosDiarios.database.adapter.UserAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"br.com.matheuscalaca.gastosDiarios"})
@EnableJpaRepositories(basePackages = "br.com.matheuscalaca.gastosDiarios.database.*")
public class AppConfig {

    @Bean
    public UserOutput userOutput() {
        return new UserAdapter();
    }

    @Bean
    public GastoOutput gastoOutput() {
        return new GastoAdpter();
    }

    @Bean
    public CreateUserInput createUserInput(UserOutput userOutput) {
        return new CreateUserUseCase(userOutput);
    }

    @Bean
    public CreateGastoInput createGastoInput(GastoOutput gastoOutput) {
        return new CreateGastoUseCase(gastoOutput);
    }

    @Bean
    public GetGastoUserByMonthInput getGastoUserByMonthInput(GastoOutput gastoOutput) {
        return new GetGastoUserByMonthUseCase(gastoOutput);
    }


}
