package com.cdtuyen.borrowingService.controller;

import com.cdtuyen.borrowingService.dto.CreateBorrowingDTO;
import com.cdtuyen.borrowingService.entity.Borrowing;
import com.cdtuyen.borrowingService.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/borrowing")
public class BorrowingController {
    private final BorrowingService borrowingService;
    @PostMapping
    public ResponseEntity<Borrowing> saveBorrowing(@RequestBody CreateBorrowingDTO createBorrowingDTO){
        return new ResponseEntity<>(borrowingService.addBorrowing(createBorrowingDTO), HttpStatus.OK);
    }
}
