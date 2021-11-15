package com.bookmarket.events.listener

import com.bookmarket.events.PurchaseEvent
import com.bookmarket.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateNfeListener(
    val purchaseService: PurchaseService
) {

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent){
        val nfe = UUID.randomUUID().toString()
        val purchase = purchaseEvent.purchaseModel.copy(nfe = nfe)
        purchaseService.update(purchase)
    }
}