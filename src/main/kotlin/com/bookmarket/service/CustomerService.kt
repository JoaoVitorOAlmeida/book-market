package com.bookmarket.service

import com.bookmarket.model.CustomerModel
import com.bookmarket.reporsitory.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (val customerRepository: CustomerRepository){

    fun getAll(name: String?): List<CustomerModel> {

        name?.let {
            return customerRepository.findByNameContaining(it)
        }

        return customerRepository.findAll().toList()
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getCustomerById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun updateCustomer(customer: CustomerModel){
        if(!customerRepository.existsById(customer.id!!)){
            throw Exception()
        }

        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int){
        if(!customerRepository.existsById(id)){
            throw Exception()
        }

        customerRepository.deleteById(id)
    }
}