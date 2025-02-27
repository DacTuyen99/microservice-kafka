package com.cdtuyen.borrowingService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bookService", url = "http://localhost:9001/interface/v1/book")
public interface BookServiceClient {
    @GetMapping("/{id}")
    public Boolean checkIsReadyBook(@PathVariable Long id);
    @PutMapping("/{id}")
    public Boolean updateStatusBook(@PathVariable Long id);
}
