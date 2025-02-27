package com.cdtuyen.borrowingService.service;

import com.cdtuyen.borrowingService.client.BookServiceClient;
import com.cdtuyen.borrowingService.dto.CreateBorrowingDTO;
import com.cdtuyen.borrowingService.entity.Borrowing;
import com.cdtuyen.borrowingService.repository.BorrowingRepository;
import com.cdtuyen.commonServer.exception.CommonErrorCode;
import com.cdtuyen.commonServer.exception.item.DataNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;
    private final BookServiceClient bookServiceClient;
    @Transactional
    public Borrowing addBorrowing(CreateBorrowingDTO createBorrowingDTO){
        Boolean checkIsReadyBook = bookServiceClient.checkIsReadyBook(createBorrowingDTO.getBookId());
        if (!checkIsReadyBook.equals(true)){
            throw new DataNotFoundException(CommonErrorCode.ResourceNotFound,"","BookService");
        }
        Borrowing borrowing = Borrowing.builder().bookId(createBorrowingDTO.getBookId())
                .employeeId(createBorrowingDTO.getEmployeeId()).borrowingDate(new Date()).build();
        Borrowing borrowingSave = borrowingRepository.save(borrowing);
        Boolean checkUpdateStatusBook = bookServiceClient.updateStatusBook(createBorrowingDTO.getBookId());
        if (!checkUpdateStatusBook.equals(false)){
            throw new DataNotFoundException(CommonErrorCode.ResourceNotFound,"","BookService");
        }
        return borrowingSave;
    }
}
