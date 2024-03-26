package br.com.matheuscalaca.gastosDiarios.api.config;

import br.com.matheuscalaca.gastosDiarios.core.input.*;
import br.com.matheuscalaca.gastosDiarios.core.output.CategoriaOutput;
import br.com.matheuscalaca.gastosDiarios.core.output.GanhoOutput;
import br.com.matheuscalaca.gastosDiarios.core.output.GastoOutput;
import br.com.matheuscalaca.gastosDiarios.core.output.UserOutput;
import br.com.matheuscalaca.gastosDiarios.core.useCase.*;
import br.com.matheuscalaca.gastosDiarios.database.adapter.CategoriaAdpter;
import br.com.matheuscalaca.gastosDiarios.database.adapter.GanhoAdpter;
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
    public GanhoOutput ganhoOutput() {
        return new GanhoAdpter();
    }
    @Bean
    public CategoriaOutput categoriaOutput() {
        return new CategoriaAdpter();
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
    @Bean
    public GetGanhoUserByMonthInput getGanhoUserByMonthInput(GanhoOutput ganhoOutput) {
        return new GetGanhoUserByMonthUseCase(ganhoOutput);
    }

    @Bean
    public CreateGanhoInput createGanhoInput(GanhoOutput ganhoOutput) {
        return new CreateGanhoUseCase(ganhoOutput);
    }

    @Bean
    public GetResumoGastoUserByMonthInput getResumoGastoUserByMonthInput(GastoOutput gastoOutput) {
        return new GetResumoGastoUserByMonthUseCase(gastoOutput);
    }

    @Bean
    public GetCategoriaInput getCategoriaInput(CategoriaOutput categoriaOutput) {
        return new GetCategoriaUseCase(categoriaOutput);
    }

    @Bean
    public GetUserByEmailUseCase getUserByEmailUseCase(UserOutput userOutput) {
        return new GetUserByEmailUseCase(userOutput);
    }


}
