package com.example.numbersgameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //generate a random number from 0 to 10
        var random = Random.nextInt(11)
        val texts = arrayListOf<String>()
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.enterNumber)
        val myRv = findViewById<RecyclerView>(R.id.rvMain)
        var guess=3
        button.setOnClickListener{
            if(editText.text.isEmpty()) {
                Toast.makeText(this, "Please enter a number ", Toast.LENGTH_SHORT).show()
                editText.getText().clear()
            }
            else
            {
                    if(random==Integer.parseInt(editText.text.toString())){
                        texts.add("You guessed ${editText.text.toString()}\n Correct Guess! You win.")
                        this.recreate()
                    }
                    else {
                        texts.add("You guessed ${editText.text.toString()}\n You have $guess guesses left")
                        guess--
                    }
                //then clear the Edit Text field.
                editText.getText().clear()
                myRv.adapter = RecyclerViewAdapter(texts)
                myRv.layoutManager = LinearLayoutManager(this)
            }
        }

    }

}