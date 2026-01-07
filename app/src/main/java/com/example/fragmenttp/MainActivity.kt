package com.example.fragmenttp

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.button.MaterialButton
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), Fragment1.OnDataSentListener {

    var messageTyped: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var edt_text = findViewById<EditText>(R.id.edt_txt)
        var button = findViewById<MaterialButton>(R.id.btn_massage)

        button.setOnClickListener {
            messageTyped = edt_text.text.toString()
            val fragment = Fragment1()
            var bundle = Bundle()
            bundle.putString("MESSAGE", messageTyped)
            fragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }

    }

    override fun envoyer_feedBack(feedBack: String) {
        var txt_feedback = findViewById<TextView>(R.id.txt_feedback)
        txt_feedback.text = "FeedBack : " + messageTyped
    }

}