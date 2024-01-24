package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.domain.Credit
import me.dio.creditapplicationsystem.repository.CreditRepository
import me.dio.creditapplicationsystem.service.iCreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): iCreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomer(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode) ?: throw  RuntimeException("creditCode $creditCode not found"))
        if (credit.customer?.id == customerId) {
            return credit
        } else {
            throw RuntimeException("Contact admin")
        }
    }


}