package mvc.main;

import mvc.configuration.JPAConfig;
import mvc.entity.BookDetailsEntity;
import mvc.entity.BookEntity;
import mvc.entity.CategoryEntity;
import mvc.repository.BookRepository;
import mvc.repository.CategoryRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepo = applicationContext.getBean("bookRepository", BookRepository.class);
    static CategoryRepository categoryRepository = applicationContext.getBean("categoryRepository", CategoryRepository.class);

    private static CategoryEntity createCategory(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("LS");
        categoryEntity.setDescription("Hoc lich su cho co kien thuc ls");
        return categoryEntity;

    }
    private static BookEntity createBook(){
        BookDetailsEntity bookDetailsEntity = new BookDetailsEntity();
        bookDetailsEntity.setIsbn("aaaaaaaaaaaa");
        bookDetailsEntity.setNumberOfPage(222);
        bookDetailsEntity.setPrice(1000);
        bookDetailsEntity.setPublishDate(LocalDate.now());

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("CNTT");
        bookEntity.setAuthor("Roger");
        bookEntity.setBookDetails(bookDetailsEntity);
        bookDetailsEntity.setBook(bookEntity);

        return bookEntity;

    }
    private static void createNewBookEntryWithNewCategory(){
        CategoryEntity categoryEntity = createCategory();
        CategoryEntity resultCate = categoryRepository.save(categoryEntity);
        BookEntity bookEntity = createBook();
        bookEntity.setCategory(categoryEntity);
        BookEntity resultBook = bookRepo.save(bookEntity);
        if (resultCate != null && resultBook != null){
            System.out.println("A new category and book saved successfully");
        }

    }

    private static void createNewBookEntry(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1);
        BookEntity bookEntity = createBook();
        bookEntity.setCategory(categoryEntity);
        BookEntity resultBook = bookRepo.save(bookEntity);
        if (resultBook != null){
            System.out.println("A createNewBookEntry saved successfully");
        }

    }




//    private static void findByAuthorBook(String author){
//        List<BookEntity> bookEntityList = bookRepo.findByAuthor(author);
//        if(bookEntityList.isEmpty()){
//            System.out.println("Book not exist");
//        }
//        for(BookEntity b : bookEntityList){
//            System.out.println(b.toString());
//        }
//    }

    private static void findByNameAndAuthorBook(String name ,String author){
        List<BookEntity> bookEntityList = bookRepo.findByNameAndAuthor(name,author);
        if(bookEntityList.isEmpty()){
            System.out.println("Book not exist");
        }
        for(BookEntity b : bookEntityList){
            System.out.println(b.toString());
        }
    }

    private static void findByNameOrAuthorBook(String name ,String author){
        List<BookEntity> bookEntityList = bookRepo.findByNameOrAuthor(name,author);
        if(bookEntityList.isEmpty()){
            System.out.println("Book not exist");
        }
        for(BookEntity b : bookEntityList){
            System.out.println(b.toString());
        }
    }
    private static void findByPriceLessThan(int price){

        List<BookEntity> book =  bookRepo.findByBookDetailsPriceLessThan(price);
        if(book.isEmpty()){
            System.out.println("Book not exist");
        }
        for(BookEntity b : book){
            System.out.println(b.toString());
        }
    }

    private static void findByNameContaining(String name){
        List<BookEntity> bookEntityList = bookRepo.findByNameContaining(name);
        if(bookEntityList.isEmpty()){
            System.out.println("Book not exist");
        }
        for(BookEntity b : bookEntityList){
            System.out.println(b.toString());
        }
    }

    private static void findByAllUsingQuery(){
        List<BookEntity> bookEntityList = (List<BookEntity>) bookRepo.findAll();
        if(bookEntityList.isEmpty()){
            System.out.println("Book not exist");
        }
        for(BookEntity b : bookEntityList){
            System.out.println(b.toString());
        }
    }

    private static void findByBookDetailsIsbn(String isbn){
        BookEntity bookEntity =  bookRepo.findByBookDetailsIsbn(isbn);
        if(bookEntity == null){
            System.out.println("Book not exist");
        }
        System.out.println(bookEntity.toString());
    }

    public static void findByBookNameStartWithUsingQuery(String name){
        List<BookEntity> bookEntityList = bookRepo.getBookNameStarWith(name);
        if(bookEntityList.isEmpty()){
            System.out.println("Book not exist");
        }
        for( BookEntity b  : bookEntityList){
            System.out.println(b.toString());
        }
    }
    public static void findBookPriceGreaterThanUsingQuery(int price){
        List<BookEntity> bookEntityList = bookRepo.getBookPriceGreaterThan(price);
        if(bookEntityList.isEmpty()){
            System.out.println("Book not exist");
        }
        for( BookEntity b  : bookEntityList){
            System.out.println(b.toString());
        }
    }


    public static void main(String[] args) {
        //createNewBookEntryWithNewCategory();
        //createNewBookEntry();
        //findByAuthorBook("Roger");
        //findByNameAndAuthorBook("CNTT","Roger");
        //findByNameOrAuthorBook("CNTT","Roger");
        //findByNameContaining("CN");
          findByAllUsingQuery();
        //findByBookNameStartWithUsingQuery("CN");
        //findBookPriceGreaterThanUsingQuery(100);

       // findByBookDetailsIsbn("aaaaaaaaaaaa");
        //findByPriceLessThan(8000);

    }






    //===================================================================================
//    private static void createNewBook(){
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setName("Pysical basic");
//        bookEntity.setAuthor("Roger");
//        bookEntity.setCategory("Pyshical");
//        bookEntity.setIsbn("ISIBFee1");
//        bookEntity.setNumberOfPage(422);
//        bookEntity.setPrice(30.5);
//
//        BookEntity result = bookRepo.save(bookEntity);
//        if (result != null){
//            System.out.println("A new book saved successfully, book Id = " +bookEntity.getId());
//        }
//
//    }
//    public static void readBook(){
//        List<BookEntity> bookEntityList = (List<BookEntity>) bookRepo.findAll();
//        System.out.println("Found: " + bookEntityList.size() + "book(s) in the table book");
//        System.out.println("They are: ");
//        for(BookEntity book : bookEntityList){
//            System.out.println(book.toString());
//        }
//    }
//    public static void readOneBook(int id){
//        Optional<BookEntity> book =  bookRepo.findById(id);
//        if(book != null){
//            System.out.println("Found a book with book ID = " + id);
//            System.out.println(book.toString());
//        }
//
//    }
//    public static void updateBook(int id){
//        Optional<BookEntity> book =  bookRepo.findById(id);
//        if(!book.isPresent()){
//            System.out.println("Found a book with book ID = " + id + "Not found");
//        }
//        BookEntity bookUpdate = book.get();
//        bookUpdate.setPublishDate(LocalDate.now());
//        bookUpdate.setName("Chau thai son");
//        BookEntity result = bookRepo.save(bookUpdate);
//        System.out.println("Update Success:");
//        System.out.println(result.toString());
//    }
//
//    public static void deleteBook(int id){
//        Optional<BookEntity> book =  bookRepo.findById(id);
//        if(!book.isPresent()){
//            System.out.println("Found a book with book ID = " + id + "Not found");
//        }
//        bookRepo.delete(book.get());
//        System.out.println("Delete success");
//    }
//    public static void findByAuthorBook (String author){
//        List<BookEntity> bookbyAuthor = bookRepo.findByAuthor(author);
//        if(bookbyAuthor.isEmpty()){
//            System.out.println("Not found exist by author = " + author);
//        }
//        for(BookEntity book : bookbyAuthor){
//            System.out.println(book.toString());
//        }
//    }
//
//     public static void getBookNameStartWith(String name){
//        List<BookEntity> listBook = bookRepo.getBookNameStartWith(name);
//        if(listBook.isEmpty()){
//            System.out.println("Book not exist");
//        }
//        for(BookEntity book : listBook){
//            System.out.println(book.toString());
//        }
//     }
//
//     public static void getBookWherePriceLessThanAndNumberOfPageGreaterThan(double price, int numberOfPage){
//        List<BookEntity> list = bookRepo.getBookWherePriceLessThanAndNumberOfPageGreaterThan(price,numberOfPage);
//        if(list.isEmpty()){
//            System.out.println("Not exist");
//        }
//        for(BookEntity b : list){
//            System.out.println(b.toString());
//        }
//     }
//
//     public static void findBookByAuthorAndPrice(String author , double price){
//        List<BookEntity> list = bookRepo.findByAuthorAndPrice(author,price);
//        if(list.isEmpty()){
//            System.out.println("Not exist");
//        }
//        for(BookEntity b : list){
//            System.out.println(b.toString());
//        }
//     }
//    public static void main(String[] args)  {
//        // createNewBook();
//        // readBook();
//        // readOneBook(3);
//        // updateBook(1);
//        //deleteBook(2);
//        //findByAuthorBook("Roger");
//        //getBookNameStartWith("Math");
//        //getBookWherePriceLessThanAndNumberOfPageGreaterThan(30,300);
//        //findBookByAuthorAndPrice("Roger",20.5);
//        Scanner sc = new Scanner(System.in);
//        int num;
//        do {
//            System.out.println("-----------------------------Menu Book-----------------------");
//            System.out.println("|1. Create Book                                              |");
//            System.out.println("|2. List Book                                                |");
//            System.out.println("|3. Get Book By Id                                           |");
//            System.out.println("|4. Update Book                                              |");
//            System.out.println("|5. Delete Book                                              |");
//            System.out.println("|6. Find Book Author                                         |");
//            System.out.println("|7. Find Book NameStartWith                                  |");
//            System.out.println("|8. Find Book WherePriceLessThanAndNumberOfPageGreaterThan   |");
//            System.out.println("|9. Exit                                                     |");
//            System.out.println(" ---------------------------Choose one: ----------------------");
//            num = sc.nextInt();
//            switch (num){
//                case 1:
//                    createNewBook();
//                    break;
//                case 2:
//                    readBook();
//                    break;
//                case 3:
//                    readOneBook(3);
//                    break;
//                case 4:
//                    updateBook(1);
//                    break;
//                case 5:
//                    deleteBook(2);
//                    break;
//                case 6:
//                    findByAuthorBook("Roger");
//                    break;
//                case 7:
//                    getBookNameStartWith("Math");
//                    break;
//                case 8:
//                    getBookWherePriceLessThanAndNumberOfPageGreaterThan(30,300);
//                    break;
//                case 9:
//                    System.out.println("GOODBYE");
//                    break;
//                default:
//                    System.out.println("Nhap xà lơ thế bro");;
//            }
//        }while(num != 9);
//
//
//    }
}
