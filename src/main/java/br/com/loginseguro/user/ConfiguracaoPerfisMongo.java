package br.com.loginseguro.user;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Configuration
public class ConfiguracaoPerfisMongo {
    @Bean
    MongoCustomConversions roleConversions() {
        return new MongoCustomConversions(List.of(new ConversorPerfilArmazenado()));
    }
    @ReadingConverter
    static class ConversorPerfilArmazenado implements Converter<String, Perfil> {
        @Override
        public Perfil convert(String value) {
            return switch (value) {
                case "USER" -> Perfil.ALUNO;
                case "EDITOR" -> Perfil.PROFESSOR;
                default -> Perfil.valueOf(value);
            };
        }
    }
}
