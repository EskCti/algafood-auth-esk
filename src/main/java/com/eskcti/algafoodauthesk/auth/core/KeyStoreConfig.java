package com.eskcti.algafoodauthesk.auth.core;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class KeyStoreConfig {

    @Autowired
    private KeyStoreProperties properties;

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure().directory("src/.env").load();
    }

    @Bean
    public boolean configPropertiesWithEnv(Dotenv dotenv) {
        properties.setKeypairAlias(dotenv.get("JWT_KEYSTORE_KEYPAIR_ALIAS"));
        properties.setPath(dotenv.get("JWT_KEYSTORE_PATH"));
        properties.setPassword(dotenv.get("JWT_KEYSTORE_PASSWORD"));
        return true;
    }
}
