package mvc.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookDetails")
public class BookDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_detail_id")
    private int bookDetailId;

    private String isbn;
    private int numberOfPage;

    private int price;
    private LocalDate publishDate;

    @OneToOne(mappedBy = "bookDetails")
    private BookEntity book;

    public BookDetailsEntity() {
    }

    public int getBookDetailId() {
        return bookDetailId;
    }

    public void setBookDetailId(int bookDetailId) {
        this.bookDetailId = bookDetailId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDetailsEntity{" +
                "bookDetailId=" + bookDetailId +
                ", isbn='" + isbn + '\'' +
                ", numberOfPage=" + numberOfPage +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }
}
