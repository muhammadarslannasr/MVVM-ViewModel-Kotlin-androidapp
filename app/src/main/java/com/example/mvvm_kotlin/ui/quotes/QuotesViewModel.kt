package com.example.mvvm_kotlin.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvm_kotlin.data.Quote
import com.example.mvvm_kotlin.data.QuoteRepository

class QuotesViewModel (private val quoteRepository: QuoteRepository) :
    ViewModel() {


    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuotes(quote)

}