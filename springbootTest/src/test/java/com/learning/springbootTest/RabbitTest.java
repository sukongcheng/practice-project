package com.learning.springbootTest;

import com.learning.springbootTest.config.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitTest {

    @Autowired
    private Provider provider;

    @Test
    public void providerTest(){
        provider.sendMessage("Hello world");
    }
}
