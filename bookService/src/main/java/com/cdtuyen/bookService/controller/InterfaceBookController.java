package com.cdtuyen.bookService.controller;

import com.cdtuyen.bookService.entity.Book;
import com.cdtuyen.bookService.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interface/v1/book")
@RequiredArgsConstructor
public class InterfaceBookController {
    private final BookService bookService;
    @GetMapping("/{id}")
    public Boolean checkIsReadyBook(@PathVariable Long id){
        return bookService.checkIsReadyBook(id);
    }
    @PutMapping("/{id}")
    public Boolean updateStatusBook(@PathVariable Long id){
        return bookService.updateStatusBook(id);
    }
}
