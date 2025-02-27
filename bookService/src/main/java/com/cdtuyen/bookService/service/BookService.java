package com.cdtuyen.bookService.service;

import com.cdtuyen.bookService.dto.BookDTO;
import com.cdtuyen.bookService.entity.Book;
import com.cdtuyen.bookService.repository.BookRepository;
import com.cdtuyen.commonServer.exception.CommonErrorCode;
import com.cdtuyen.commonServer.exception.item.DataNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public Book getBookById(Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()){
            throw new DataNotFoundException(CommonErrorCode.ResourceNotFound,"", "BookService");
        }
        return bookOptional.get();
    }
    @Transactional
    public Book updateBookById(BookDTO bookDTO, Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()){
            throw new DataNotFoundException(CommonErrorCode.ResourceNotFound,"", "BookService");
        }
        Book updateBook = new Book(bookDTO.getId(), bookDTO.getName(), bookDTO.getAuthor(), bookDTO.getIsReady());
        return bookRepository.save(updateBook);
    }
    public Boolean checkIsReadyBook(Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()){
            throw new DataNotFoundException(CommonErrorCode.ResourceNotFound,"", "BookService");
        }
        return bookOptional.get().getIsReady();
    }
    public Boolean updateStatusBook(Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()){
            throw new DataNotFoundException(CommonErrorCode.ResourceNotFound,"", "BookService");
        }
        if (bookOptional.get().getIsReady().equals(false)){
            throw new DataNotFoundException(CommonErrorCode.ResourceNotFound,"", "BookService");
        }
        Book book = Book.builder().id(bookOptional.get().getId())
                .name(bookOptional.get().getName())
                .author(bookOptional.get().getAuthor())
                .isReady(false).build();
        return bookRepository.save(book).getIsReady();

    }
}
