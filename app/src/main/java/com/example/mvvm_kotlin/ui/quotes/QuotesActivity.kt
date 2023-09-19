package com.example.mvvm_kotlin.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_kotlin.R
import com.example.mvvm_kotlin.data.Quote
import com.example.mvvm_kotlin.utilities.InjectorUtils
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        val textViewQuotes = findViewById<TextView>(R.id.textView_quotes)
        val buttonAddQuote = findViewById<Button>(R.id.button_add_quote)
        val editTextQuote = findViewById<EditText>(R.id.editText_quote)
        val editTextAuthor = findViewById<EditText>(R.id.editText_author)
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)[QuotesViewModel::class.java]

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textViewQuotes.text = stringBuilder.toString()
        })

        buttonAddQuote.setOnClickListener {
            val quote = Quote(editTextQuote.text.toString(),editTextAuthor.text.toString())
            viewModel.addQuote(quote)
            editTextQuote.setText("")
            editTextAuthor.setText("")
        }

    }

}