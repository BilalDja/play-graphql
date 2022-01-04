package dz.bdjaghout.playgraphql.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bilal Djaghout on 1/4/2022 10:57 AM
 */

@Configuration
public class BeanConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
