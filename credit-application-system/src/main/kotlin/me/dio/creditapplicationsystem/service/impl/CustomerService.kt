package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.domain.Customer
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.service.iCustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository): iCustomerService {

    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id not found")
        }
    }

    override fun delete(id: Long) {
        return this.customerRepository.deleteById(id)
    }
}