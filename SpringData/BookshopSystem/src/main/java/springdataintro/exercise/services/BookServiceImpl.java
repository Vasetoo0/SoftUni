package springdataintro.exercise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintro.exercise.entities.*;
import springdataintro.exercise.repositories.BookRepository;
import springdataintro.exercise.services.interfaces.AuthorService;
import springdataintro.exercise.services.interfaces.BookService;
import springdataintro.exercise.services.interfaces.CategoryService;
import springdataintro.exercise.utils.FileUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static springdataintro.exercise.constants.GlobalConstants.BOOK_FILE_PATH;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        String[] booksData = this.fileUtil.readFileContent(BOOK_FILE_PATH);

        for (String bookData : booksData) {

            String[] tokens = bookData.split("\\s+");

            Author author = this.getRandomAuthor();

            EditionType editionType = EditionType.values()[Integer.parseInt(tokens[0])];

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(tokens[1], formatter);

            int copies = Integer.parseInt(tokens[2]);

            BigDecimal price = new BigDecimal(tokens[3]);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(tokens[4])];

            StringBuilder titleAppend = new StringBuilder();

            for (int i = 5; i < tokens.length; i++) {
                titleAppend.append(tokens[i]);
            }
            String title = titleAppend.toString().trim();

            Book book = new Book();

            book.setAuthor(author);
            book.setAgeRestriction(ageRestriction);
            book.setCopies(copies);
            book.setEditionType(editionType);
            book.setPrice(price);
            book.setReleaseDate(releaseDate);
            book.setTitle(title);
            book.setCategories(getRandomCategories());

            if(bookDontExist(book)) {
                this.bookRepository.saveAndFlush(book);
            }
        }
    }

    @Override
    public List<Book> getAllBooksAfterYear(LocalDate date) {
        return this.bookRepository.findAllByReleaseDateAfter(date);
    }

    @Override
    public List<Book> getAllBooksBeforeYear(LocalDate date) {
        return this.bookRepository.findAllByReleaseDateBefore(date);
    }

    private boolean bookDontExist(Book book) {
        return this.bookRepository.findBookById(book.getId()) == null;
    }

    private Set<Category> getRandomCategories() {
        Random random = new Random();

        Set<Category> categories = new LinkedHashSet<>();

        for (int i = 0; i < 3; i++) {
            long rdCategoryId = random.nextInt(this.categoryService.getAllCategoriesCount()) + 1;
            categories.add(this.categoryService.getCategoryById(rdCategoryId));
        }

        return categories;
    }

    private Author getRandomAuthor() {
        Random random = new Random();
        long rdAuthorId = random.nextInt(this.authorService.getAllAuthorsCount()) + 1;

        return this.authorService.getAuthorById(rdAuthorId);
    }

    @Override
    public List<Book> getAllBooksFRomAuthorOrderedByReleaseDate(String name) {
        return this.bookRepository.findAllByAuthorNameOrderedByReleaseDate(name);
    }
}
