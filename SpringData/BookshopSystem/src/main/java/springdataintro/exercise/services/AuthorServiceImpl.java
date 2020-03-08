package springdataintro.exercise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintro.exercise.constants.GlobalConstants;
import springdataintro.exercise.entities.Author;
import springdataintro.exercise.repositories.AuthorRepository;
import springdataintro.exercise.services.interfaces.AuthorService;
import springdataintro.exercise.utils.FileUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static springdataintro.exercise.constants.GlobalConstants.AUTHOR_FILE_PATH;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        String[] authorsData = fileUtil.readFileContent(AUTHOR_FILE_PATH);

        for (String authorData : authorsData) {

            String[] fullName = authorData.split("\\s+");
            String firstName = fullName[0];
            String lastName = fullName[1];

            if (authorDontExist(lastName)) {
                this.authorRepository.saveAndFlush(new Author(firstName, lastName));
            }
        }
    }

    @Override
    public int getAllAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author getAuthorById(long id) {
        return this.authorRepository.getOne(id);
    }

    @Override
    public List<Author> getAllAuthorsOrderedByBookCount() {
        return this.authorRepository.findAllAuthorsOrderByBooksCounts();
    }

    private boolean authorDontExist(String lastName) {
        return this.authorRepository.findByLastName(lastName) == null;
    }


}
