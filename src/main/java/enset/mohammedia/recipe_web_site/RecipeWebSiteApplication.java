package enset.mohammedia.recipe_web_site;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RecipeWebSiteApplication {

    public static void main(String[] args) {
        log.info("APPLICATION STARTED SUCCESSFULLY");
        SpringApplication.run(RecipeWebSiteApplication.class, args);
    }

}
