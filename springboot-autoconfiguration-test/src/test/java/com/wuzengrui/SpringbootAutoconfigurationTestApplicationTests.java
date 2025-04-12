package com.wuzengrui;


import com.wuzengrui.pojo.Properties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootAutoconfigurationTestApplicationTests {

    @Autowired
    private Properties properties;


    @Test
    public void testContext() {
        String endpoint = properties.getEndpoint();
    }
}
