package com.cdtuyen.bookService.controller;

import com.cdtuyen.bookService.dto.BookDTO;
import com.cdtuyen.bookService.entity.Book;
import com.cdtuyen.bookService.service.BookService;
import com.cdtuyen.commonServer.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;
    private final KafkaService kafkaService;

    @PostMapping
    public ResponseEntity<Book> addNewBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookDetail(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody BookDTO bookDTO, @PathVariable Long id){
        return new ResponseEntity<>(bookService.updateBookById(bookDTO, id), HttpStatus.OK);
    }
    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody String message){
        kafkaService.sendMessage("test",message);
    }
}
