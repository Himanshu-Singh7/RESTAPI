package com.api.book.bootrestbook.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.bootrestbook.entites.Book;
import com.api.book.bootrestbook.service.BookService;

@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public List<Book> getBook(){
       
        return this.bookService.getAllBooks();
    }

    // get single by id
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id ){
       return this.bookService.getBookById(id);
    }
   // Create resourse
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
         
        Book b = this.bookService.addBook(book);
        System.out.println(book);
        return b;
    }
 // Delete Book handler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){

        this.bookService.deleteBook(bookId);
    }

    // Update Book handler
    @PutMapping("/books/{bookId}")
    public Book  updateBook(@RequestBody Book book ,@PathVariable("bookId") int bookId){
          
       this.bookService.updateBook(book,bookId);
       return book;
    }
}
