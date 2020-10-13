import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Library {
    public ArrayList<Book> books;
    Gson gson = new Gson();

    public Library(String filePath) throws IOException {
        books = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        JsonElement rootNode = JsonParser.parseReader(bufferedReader).getAsJsonObject();
        JsonArray array= (JsonArray) rootNode.getAsJsonObject().get("books");
        for( int i = 0;i < array.size();++i){
            Book book = new Book();
            book.setBookName(array.get(i).getAsJsonObject().get("bookName").getAsString());
            book.setAuthor(new Author(array.get(i).getAsJsonObject().get("author").getAsString()));
            books.add(i, book);
        }
    }


    public void printBooksByAuthor(Author author) {
        for (Book book : books)
            if (book.getAuthor().getFullName().equals(author.getFullName()))
                System.out.println(book.getBookName());
    }

    public void printJsonSerializedClass(Author author) {
        for (Book book : books)
            if (book.getAuthor().getFullName().equals(author.getFullName()))
                System.out.println(gson.toJson(book));
    }
}