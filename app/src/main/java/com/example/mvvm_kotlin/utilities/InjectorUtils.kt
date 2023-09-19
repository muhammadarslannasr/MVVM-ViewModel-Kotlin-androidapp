package com.example.mvvm_kotlin.utilities

import com.example.mvvm_kotlin.data.FakeDatabase
import com.example.mvvm_kotlin.data.QuoteRepository
import com.example.mvvm_kotlin.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }

}