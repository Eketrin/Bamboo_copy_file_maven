package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            // подбрасывает исключение
            methodThatThrowsCheckedException();
        } catch (CustomException ex) {
            //вывод инфы об исключении
            System.out.println("Исключение поймано: " + ex.getMessage());
        } finally {
            //вывод в любом случае
            System.out.println("Этот блок выполняется в любом случае.");
        }
    }

    static void methodThatThrowsCheckedException() throws CustomException {
        //подбрасывание исключения  .
        throw new CustomException("Это кастомное исключение.");
    }
}
