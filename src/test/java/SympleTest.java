import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@Owner("evgdas")
@Feature("Работа с Jenkins")
public class SympleTest {
    @Test
    @DisplayName("Проверка умножения")
    @Tag("multiple_test")
    public void checkMultiple() {
        String a = System.getProperty("valA", "0");
        String b = System.getProperty("valB", "0");
        int c=Integer.parseInt(a) * Integer.parseInt(b);
        System.out.println("a= "+a+" b= "+b+" c= "+c);
        parameter("Множитель а", a);
        parameter("Множитель b", b);
        step("Проверка результатов операции", () -> {
           assertThat(c,greaterThan(0));
        });
    }

}