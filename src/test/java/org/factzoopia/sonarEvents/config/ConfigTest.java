package org.factzoopia.sonarEvents.config;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.cors.CorsConfigurationSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class ConfigTest {

    @Autowired
    private Config config;

    @Test
    void testCorsConfigurationSource() {
        CorsConfigurationSource source = config.corsConfigurationSource();
        assertNotNull(source);
    }

    @Test
    void testEncoder() {
        PasswordEncoder encoder = config.encoder();
        assertNotNull(encoder);
    }

    @Test
    void testFilterChain() throws Exception {
        SecurityFilterChain filterChain = config.filterChain(new HttpSecurity(new TestRequestMatcher()));
        assertNotNull(filterChain);
    }
}


