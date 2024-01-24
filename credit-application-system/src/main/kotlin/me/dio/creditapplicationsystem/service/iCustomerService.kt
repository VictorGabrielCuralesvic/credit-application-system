package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.domain.Customer

interface iCustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}