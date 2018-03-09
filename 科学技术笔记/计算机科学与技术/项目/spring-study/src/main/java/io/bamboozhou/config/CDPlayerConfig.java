package io.bamboozhou.config;

import io.bamboozhou.component.CDplayer;
import io.bamboozhou.component.CompactDisc;
import io.bamboozhou.component.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zlq on 1/23/16.
 */
@Configuration
//@ComponentScan("io.bamboozhou.component")
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }


    @Bean
    public CDplayer cdplayer() {
        return new CDplayer(sgtPeppers());
    }
}
