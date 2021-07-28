package com.example.booklibrary.web;
import com.example.booklibrary.data.BookRepository;
import com.example.booklibrary.model.Book;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BookController {
    private BookRepository books;
    public BookController(BookRepository bookRepository){
        this.books=bookRepository;
    }
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("lista",books.findAll());
        return "tabel";
    }
    @GetMapping("/books/new")
    public String newBook(Model model){
        model.addAttribute("book",new Book());
        return "addBook";
    }
    @PostMapping("books/new")
    public String newBook(@Valid  Book book , Errors errors){

        if(errors.hasErrors()){

            return "addBook";
        }
        books.save(book);
        return "redirect:/";
    }
    @GetMapping("/books")
    public  String bookDetails(@Param("id") Long id, Model model){
        model.addAttribute("book",books.findById(id));
        return "updateBook";
    }
    @PostMapping("/books/{id}")
    public  String bookUpdate(@PathVariable Long id ,@Valid Book book ,Errors errors ,Model model){

        if(errors.hasErrors()){

            model.addAttribute("book",books.findById(id));

            return "updateBook";
        }

        books.save(book);
        return "redirect:/";
    }
    @PostMapping("/books/{id}/delete")
    public String bookDelete(@PathVariable Long id){
        books.deleteById(id);
        return "redirect:/";
    }
    @PostMapping("/back")
    public String back(){
        return "redirect:/";
    }

}
