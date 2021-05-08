package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(Long categoryId);

    List<Book> findByAuthorsContaining(Author author);

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByRating(Integer rating);

    List<Book> findByCategoryOrderByTitleAsc(Category category);

    List<Book> findByAuthors_NameAndAuthors_YearOfBirth(String authorsName, Integer yearOfBirth);

    ///////////
    // po kategorii i tytule książki
    List<Book> findByCategoryAndTitle(Category category, String title);

}
