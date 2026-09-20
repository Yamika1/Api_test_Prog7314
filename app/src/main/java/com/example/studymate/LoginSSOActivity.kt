package com.example.studymate

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginSSOActivity : AppCompatActivity() {
    private lateinit var textViewAccountName : TextView
    private lateinit var textViewAccountEmail : TextView
    private lateinit var textViewAccountUsername : TextView
    private lateinit var textViewAccountMenu : TextView
    private lateinit var textViewPlus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_sso_activity)

        textViewAccountName=findViewById<TextView>(R.id.textViewAccountName)
        textViewAccountEmail=findViewById<TextView>(R.id.textViewAccountEmail)
        textViewAccountUsername=findViewById<TextView>(R.id.textViewAccountUsername)
        textViewAccountMenu=findViewById<TextView>(R.id.textViewAccountMenu)
        textViewPlus=findViewById<TextView>(R.id.textViewPlus)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_sso)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}