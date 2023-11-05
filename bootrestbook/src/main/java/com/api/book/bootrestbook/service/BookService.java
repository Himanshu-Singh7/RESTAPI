package com.api.book.bootrestbook.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entites.Book;

@Component
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
   // private static List<Book> list = new ArrayList<>();
    
    // static{
    //     list.add(new Book(12,"Java Reference book","YSA"));
    //     list.add(new Book(13,"Python Reference book","xyz"));
    //     list.add(new Book(14,"c++ Reference book","abc"));
    //     list.add(new Book(15,"c Reference book","rab"));
    // }

    //get all books

    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>)this.bookRepository.findAll();
       return list ;
    }

    // get single books by id
     public Book getBookById(int id){
     Book book = null;  
     try {
       // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        book =  this.bookRepository.findById(id);
      } catch (Exception e) {
       e.printStackTrace();
     }
     return book;
    }

    // Creating Resource Rest API

    public Book addBook(Book b){
       Book result =  bookRepository.save(b);
        return result;
    }

    // DElete Book 

    public void deleteBook(int bid){
     
     // list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
     bookRepository.deleteById(bid);
     
    }

    // Upadte Book
     public void updateBook(Book book , int bookId){
    //    list = list.stream().map(b -> {
    //         if (b.getId() == bookId) {
                
    //             b.setTitle(book.getTitle());
    //             b.setAuthor(book.getAuthor());
    //         }
    //             return b;
    //      }).collect(Collectors.toList());

      book.setId(bookId);
      bookRepository.save(book);

    }
}
