package mvc.repository;

import mvc.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByNameContainingOrAuthorContaining(String name,String author);

    List<BookEntity> findByNameAndAuthor(String name, String author);
    List<BookEntity> findByNameOrAuthor(String name,String author);

    BookEntity findByBookDetailsIsbn(String isbn);


    List<BookEntity> findByBookDetailsPriceLessThan(int price);
    List<BookEntity> findByBookDetailsPriceLessThanEqual(int price);

    List<BookEntity> findByBookDetailsPriceGreaterThanEqual(int price);

    List<BookEntity> findByNameContaining(String  name);


    @Query("select b from BookEntity b where b.name like ?1%")
    List<BookEntity> getBookNameStarWith(String  name);

    @Query("select b from BookEntity b where b.bookDetails.price > ?1")
    List<BookEntity> getBookPriceGreaterThan(int  price);

    @Query(value = "select * from book",nativeQuery = true)
    List<BookEntity> getAllBook();





//    List<BookEntity> findByAuthorAndPrice(String author, double price);
//
//    List<BookEntity> findByPriceOrNumberOfPage(double price, int numberOfPage);
//
//    List<BookEntity> findByPriceLessThan(double price);
//
//    List<BookEntity> findByPriceGreaterThanEqual(double price);
//
//    List<BookEntity> findByNameContaining(String textName);
//
//    BookEntity findByIsbn(String isbn);
//
//    List<BookEntity> findByPublishDateAfter(LocalDate date);
//
//    @Query("Select b from BookEntity b where b.name like ?1%")
//    List<BookEntity> getBookNameStartWith(String name);
//
//    @Query(value = "select * from book  where price < ?1 and numberPage >= ?2", nativeQuery = true)
//    List<BookEntity> getBookWherePriceLessThanAndNumberOfPageGreaterThan(double price,int numberOfPage);
}
