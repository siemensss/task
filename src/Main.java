

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
Необходимо реализовать следующий метод:
        На вход получаем список названий книг.
        Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг.
        Все книги должны быть отсортированы по алфавиту с первой до последней полки.
        Количество полок константное — 5 штук.
        Вернуть книги, распределенные по полкам.
*/

public class Main {
    public static void main(String[] args) {
        List<String> books = new ArrayList<>();
        books.add("Шеорецкелоуоокген");
        books.add("Ееорецкелоуоокген");
        books.add("Цеорецкелоуоокген");
        books.add("Феорецкелоуоокген");
        books.add("ИАеорецкелоуоокген");
        books.add("Пеорецкелоуоокген");
        books.add("Реорецкелоуоокген");
        books.add("Неорецкелоуоокген");
        books.add("Йеорецкелоуоокген");
        books.add("Теорецкелоуоокген");
        books.add("Аеорецкелоуоокген");
        System.out.println(showLibrary(books));

    }

    public static List<ArrayList<String>> showLibrary(List<String> books) {
        List<ArrayList<String>> library = new ArrayList<>();
        books = books.stream()
                .sorted()
                .collect(Collectors.toList());
        for(int i = 0; i < 5; i++){
            ArrayList<String> shelf = new ArrayList<>();
            library.add(shelf);
        }

        int booksPerShelf = books.size()/ library.size();
        int remain = books.size()% library.size();
        int j = 0;
        for (List<String> shelf : library) {
            for (int i = 0; i < booksPerShelf; i++){
                shelf.add(books.get(j++));
            }
            if(remain-- > 0) {
                shelf.add(books.get(j++));
            }
        }

        return library;
    }
}

