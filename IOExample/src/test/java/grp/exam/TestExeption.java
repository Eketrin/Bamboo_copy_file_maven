package grp.exam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestExeption{

    @Test
    void throwsExceptionTest() {
        // Проверяем, что при вызове someFunction с null будет выброшено исключение
        Exception exception = assertThrows(Exception.class, () -> {
            someFunction(null);
        });

        // Выводим сообщение об исключении в консоль
        System.out.println(exception.getMessage());
        // Выводим стек вызовов исключения для отладки
        exception.printStackTrace();
    }


    public static void someFunction(Object input) throws Exception {
        System.out.println("some function");
        if (input == null) {
            throw new Exception("some exception");
        }
    }
}
