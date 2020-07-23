package wang.ismy.htmlcachesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MY
 */
@SpringBootApplication
@MapperScan("wang.ismy.htmlcachesystem.dao")
public class HtmlCacheSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HtmlCacheSystemApplication.class, args);
    }

}
