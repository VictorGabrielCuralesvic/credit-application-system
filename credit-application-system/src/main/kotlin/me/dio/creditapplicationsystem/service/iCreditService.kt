package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.domain.Credit
import java.util.UUID

interface iCreditService {
    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(customerId: Long,  creditCode: UUID): Credit
}