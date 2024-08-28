package org.factzoopia.sonarEvents.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebConfig.class)
public class WebConfigTest {

    @Autowired
    private WebConfig webConfig;

    @Test
    void testAddResourceHandlers() {
        ResourceHandlerRegistry registry = new ResourceHandlerRegistry(null, null);
        webConfig.addResourceHandlers(registry);
        assertNotNull(registry);
    }

    @Test
    void testBaseUrl() {
        assertNotNull(webConfig.baseUrl);
    }
}