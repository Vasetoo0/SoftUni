package springdataintro.exercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springdataintro.exercise.entities.Author;
import springdataintro.exercise.services.interfaces.AuthorService;
import springdataintro.exercise.services.interfaces.BookService;
import springdataintro.exercise.services.interfaces.CategoryService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();
/*
    !!! Start the program and look at resources/files/HomeWork folder!!
        For every task new text file with the output is created !!!
*/

//        1. Query exercise!
        LocalDate dateAfter = LocalDate.of(2000, 12, 31);
        writeBooksAfterYear(dateAfter);

//        2. Query exercise!
        LocalDate dateBefore = LocalDate.of(1990, 1, 1);
        writeAuthorsWithBooksBeforeYear(dateBefore);

//        3. Query exercise!
        writeAuthorsOrderedByBookCount();

//        4. Query exercise!
        writeBooksInfoFromAuthor("George Powell");
    }

    private void writeBooksInfoFromAuthor(String authorName) throws IOException {
        File file = new File("src/main/resources/files/HomeWork/exercise04.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        this.bookService.getAllBooksFRomAuthorOrderedByReleaseDate(authorName)
                .forEach(b -> {
                    System.out.println(b.getTitle() + " " + b.getReleaseDate() + " " + b.getCopies());

                    try {
                        bw.write(b.getTitle() + " " + b.getReleaseDate() + " " + b.getCopies());
                        bw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        bw.close();
    }

    private void writeAuthorsOrderedByBookCount() throws IOException {
        File file = new File("src/main/resources/files/HomeWork/exercise03.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        this.authorService.getAllAuthorsOrderedByBookCount().forEach(a -> {
            System.out.println(String.format("%s %s - BooksCount: %d",
                    a.getFirstName(),a.getLastName(),a.getBooks().size()));

            try {
                bw.write(String.format("%s %s - BooksCount: %d",
                        a.getFirstName(),a.getLastName(),a.getBooks().size()));
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        bw.close();
    }

    private void writeAuthorsWithBooksBeforeYear(LocalDate dateBefore) throws IOException {
        Set<String> names = new HashSet<>();

        this.bookService.getAllBooksBeforeYear(dateBefore).forEach(b -> {
            names.add(b.getAuthor().getFirstName() + " " + b.getAuthor().getLastName());
        });

        File file = new File("src/main/resources/files/HomeWork/exercise02.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for (String name : names) {
            System.out.println(name);

            bw.write(name);
            bw.newLine();
        }
        bw.close();
    }

    private void writeBooksAfterYear(LocalDate localDate) throws IOException {
        File file = new File("src/main/resources/files/HomeWork/exercise01.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        this.bookService.getAllBooksAfterYear(localDate)
                .forEach(b -> {
                    System.out.println(b.getTitle());

                    try {
                        bw.write(b.getTitle());
                        bw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        bw.close();
    }
}
