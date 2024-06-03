package elm.back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("elm.back.mapper")
public class BackSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackSystemApplication.class, args);
    }
}
