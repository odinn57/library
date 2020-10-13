import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

public class LibraryFactory {
    private ArrayList<Library> listOfLibrary;

    public LibraryFactory() {
        listOfLibrary = new ArrayList<>();
    }

    public void addLibrary(@NotNull String path) throws IOException {
        listOfLibrary.add(new Library(path));
    }

    public Library getLibraryById(int id) {
        return listOfLibrary.get(id - 1);
    }
}