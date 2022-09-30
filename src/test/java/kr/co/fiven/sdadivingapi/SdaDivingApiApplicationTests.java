package kr.co.fiven.sdadivingapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class SdaDivingApiApplicationTests {

    @Autowired
    private Environment environment;
    @Test
    void contextLoads() {
        System.out.println("개발 환경 : " + environment.getProperty("spring.profiles.active"));
        System.out.println("개발 환경 : " + environment.getProperty("server.port"));

    }

}
