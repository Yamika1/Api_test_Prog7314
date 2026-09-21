package com.example.studymate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var textviewLogin: TextView
    private lateinit var loginPassword : TextView
    private lateinit var btnLogin: Button
    private lateinit var btnSSO : Button
    private lateinit var textviewRegister : TextView


  



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContentView(R.layout.activity_main)


        textviewLogin = findViewById<TextView>(R.id.textviewLogin)
        loginPassword = findViewById<TextView>(R.id.loginPassword)
        btnLogin = findViewById<Button>(R.id.btnLogin)
        btnSSO = findViewById<Button>(R.id.btnSSO)
        textviewRegister = findViewById<TextView>(R.id.textviewRegister)


        textviewLogin.setOnClickListener {

            val email = textviewLogin.text.toString().trim()
            val password = loginPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Please fill in all fields",Toast.LENGTH_SHORT).show()
            }
            else{
           login(email, password,)
            }
        }

        textviewRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun login(email: String, password: String){
        val request = Login(email = email, password = password)
        val login = RetroFitClient.api.login(email = email, password = password)




    }
}