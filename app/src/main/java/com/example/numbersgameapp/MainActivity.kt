package com.example.numbersgameapp

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var guess = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //generate a random number from 0 to 10
        var random = Random.nextInt(11)
        val texts = arrayListOf<String>()
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.enterNumber)
        val myRv = findViewById<RecyclerView>(R.id.rvMain)
        //guess limit


            button.setOnClickListener {
                if (editText.text.isEmpty()) {
                    Toast.makeText(this, "Please enter a number ", Toast.LENGTH_SHORT).show()
                    editText.getText().clear()
                } else if(guess==0)
                    {
                        showAlertDialog()
                        editText.getText().clear()
                     } else if(random == Integer.parseInt(editText.text.toString())) {
                        texts.add("You guessed ${editText.text.toString()}\n Correct Guess! You win.")
                        //then clear the Edit Text field.
                        editText.getText().clear()
                        myRv.adapter = RecyclerViewAdapter(texts)
                        myRv.layoutManager = LinearLayoutManager(this)
                        guess=0
                        showAlertDialog()
                    } else {
                        texts.add("You guessed ${editText.text.toString()}\n You have $guess guesses left")
                        //then clear the Edit Text field.
                        editText.getText().clear()
                        myRv.adapter = RecyclerViewAdapter(texts)
                        myRv.layoutManager = LinearLayoutManager(this)
                        guess--
                    }

            }
        }
    fun showAlertDialog()
    {

        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(this)
        // here we set the message of our alert dialog
        dialogBuilder.setMessage("Would you like to play again?")
            // positive button text and action
            .setPositiveButton("Play", DialogInterface.OnClickListener {
                    dialog, id ->  this.recreate()
                    guess=3
            })
            // negative button text and action
            .setNegativeButton("Stop", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("New Message")
        // show alert dialog
        alert.show()

    }

    }


               // Toast.makeText(this, "Please enter a number ", Toast.LENGTH_SHORT).show()

