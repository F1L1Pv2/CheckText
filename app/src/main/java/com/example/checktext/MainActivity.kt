package com.example.checktext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var button = findViewById<Button>(R.id.login)
        var firstPass = findViewById<EditText>(R.id.firstPassInput)
        var secondPass = findViewById<EditText>(R.id.secondPassInput)
        var warningText = findViewById<TextView>(R.id.Warningss)
        var checkmark = findViewById<ImageView>(R.id.succesfull)

        fun checkPass(firstPassword: String, secondPassword: String): Array<String> {
            val errors = mutableListOf<String>()
            if (firstPassword != secondPassword){
                errors.add("Nie są takie same")
            }

            val specialCharRegex = "[^A-Za-z0-9]".toRegex()

            if (!specialCharRegex.containsMatchIn(firstPassword)){
                errors.add("Hasło musi posiadać przynajmniej jeden znak specialny")
            }

            val upperCaseRegex = "[A-Z]".toRegex()
            val lowerCaseRegex = "[a-z]".toRegex()
            val numberRegex = "[0-9]".toRegex()

            if(!upperCaseRegex.containsMatchIn(firstPassword)){
                errors.add("Hasło musi posiadać przynajmniej jedną dużą litere")
            }

            if(!lowerCaseRegex.containsMatchIn(firstPassword)){
                errors.add("Hasło musi posiadać przynajmniej jedną małą litere")
            }

            if(!numberRegex.containsMatchIn(firstPassword)){
                errors.add("Hasło musi posiadać przynajmniej jedną liczbe")
            }

            return errors.toTypedArray()
        }


    }
}