package kr.co.fiven.sdadivingapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.DriverManager;


@SpringBootTest
class SdaDivingApiApplicationTests {

    @Autowired
    private Environment environment;
    @Test
    void contextLoads() {
        System.out.println("개발 환경 : " + environment.getProperty("spring.profiles.active"));
        System.out.println("개발 환경 : " + environment.getProperty("server.port"));

    }

    @Test
    public void testConnectted() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:sqlserver://172.30.1.7:1433",
                "splog_ekS1dlP9djT0fl",
                "splog_ekS1dlP9djT0fl"
        ) )
        {
            System.out.println(connection);
            if(connection != null) {
                System.out.println("DB Connectdion Sucess!");
            }
        } catch (Exception e) {
            System.out.println("error Message : "  + e.getMessage());

        }

    }

}
