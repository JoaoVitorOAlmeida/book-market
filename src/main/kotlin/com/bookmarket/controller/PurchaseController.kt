package com.bookmarket.controller

import com.bookmarket.controller.mapper.PurchaseMapper
import com.bookmarket.controller.request.PurchaseRequest
import com.bookmarket.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("purchases")
class PurchaseController (
    val purchaseService: PurchaseService,
    val purchaseMapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody @Valid request: PurchaseRequest){
        purchaseService.create(purchaseMapper.toModel(request))
    }
}