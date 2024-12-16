package grp.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class IOExampleTest {
    //Этот тест проверяет основные свойства файла copy.txt, такие как его существование,
    // абсолютный путь, имя, а также удостоверяется, что это именно файл, а не директория.
    // После этого файл удаляется, и тест проверяет, что файл действительно был удален.
    @Test
    void fileClassExample(){
        File file = new File("copy.txt");
        Assertions.assertTrue(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        Assertions.assertTrue(file.isFile());
        Assertions.assertFalse(file.isDirectory());
        file.delete();
        Assertions.assertFalse(file.exists());
    }
    //Этот тест копирует содержимое файла copy.txt в новый файл copy.txt.
    // Он использует байтовые потоки ввода и вывода для чтения и записи данных.
    // Блок try-with-resources
    // гарантирует, что потоки будут закрыты автоматически после завершения операции.
    @Test
    void copyFile() throws IOException {
        try(FileInputStream fis = new FileInputStream("copy.txt");
            FileOutputStream fos = new FileOutputStream("copy1.txt")){
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) > 0){
                fos.write(buffer, 0, len);
            }
        }
    }
//Этот тест выполняет аналогичную задачу, но с использованием символьных потоков (FileReader и FileWriter).
// Он читает содержимое copy.txt и записывает его в copy2.txt, также используя буфер для чтения символов.

    @Test
    void fileReaderAndWriterExample() throws IOException{
        try(FileReader reader = new FileReader("copy.txt");
            FileWriter writer = new FileWriter("copy2.txt")){
            char[] buffer = new char[1024];
            int len;
            while ((len = reader.read(buffer)) > 0){
                writer.write(buffer, 0, len);
            }
        }
    }
}

