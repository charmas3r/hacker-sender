package com.charmaser.hacker_sender

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    var etComment: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define send button
        val buSend = findViewById<View>(R.id.buSend) as Button
        //// init Comment edit Text
        val etComment = findViewById<View>(R.id.etComment) as EditText
        //button listen to click event
        buSend.setOnClickListener { // set the package that we want to run
            val intent =
                packageManager.getLaunchIntentForPackage("com.charmaser.receiver")
            // put the data that we want to send over intent
            intent?.putExtra("Comment", etComment.text.toString())
            // start another app
            startActivity(intent)
        }
    }

    // cipher encryption add shift for key
    fun cipher(msg: String, shift: Int): String {
        var s = ""
        val len = msg.length // get string length
        for (x in 0 until len) {
            val c = (msg[x].code + shift).toChar() // shift every character
            s += c // append the characters
        }
        return s
    }
}
