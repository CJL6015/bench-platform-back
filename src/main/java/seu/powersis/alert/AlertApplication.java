package seu.powersis.alert;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 陈小黑
 */
@SpringBootApplication
@MapperScan("seu.powersis.alert.dao.mapper")
public class AlertApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlertApplication.class, args);
    }

}
