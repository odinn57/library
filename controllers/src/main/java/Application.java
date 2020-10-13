import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        LibraryFactory libraryFactory = new LibraryFactory();
        //путь к файлу с данными о книгах в одной библиотеке
        String path = new File("").getAbsolutePath() + "/controllers/src/main/resources/input.json";
        libraryFactory.addLibrary(path);

        System.out.println("Программа по введенному имени автора, выдает информацию о книгах, которые написал этот автор, имеющихся на данный момент в библиотеке.");
        System.out.println("Введите имя автора:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String authorName = bufferedReader.readLine();


        libraryFactory.getLibraryById(1).printJsonSerializedClass(new Author(authorName));

    }
}