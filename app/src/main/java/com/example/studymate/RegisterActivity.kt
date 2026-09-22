package com.example.studymate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var firstName : EditText
    private lateinit var lastName : EditText
    private lateinit var username : EditText

    private lateinit var email : EditText

    private lateinit var password : EditText
    private lateinit var btnRegister : Button

    private lateinit var textviewLogin : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        firstName=findViewById<EditText>(R.id.firstName)
        lastName=findViewById<EditText>(R.id.lastName)
        username=findViewById<EditText>(R.id.username)
        email=findViewById<EditText>(R.id.email)
        password=findViewById<EditText>(R.id.password)
        btnRegister=findViewById<Button>(R.id.btnRegister)
        textviewLogin = findViewById<TextView>(R.id.textviewLogin)


        btnRegister.setOnClickListener {
           val firstName = firstName.text.toString().trim()
            val lastName = lastName.text.toString().trim()
            val email = email.text.toString().trim()
            val username = username.text.toString().trim()
            val password = password.text.toString().trim()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"All fields are required. Please fill in all empty fields",Toast.LENGTH_SHORT).show()
            }
            else{
                 register(firstName,lastName,email,username,password)

            }
        }

        textviewLogin.setOnClickListener {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun register(firstName:String,lastName:String,email:String,username: String,password: String){
        val request = RegisterRequest(firstName = firstName, lastName = lastName, email=email, username=username, password = password)
        RetroFitClient.api.register(request).enqueue(object : Callback<RegisterResponse?>{

            override fun onResponse(p0: Call<RegisterResponse?>, p1: Response<RegisterResponse?>) {
                if (p1.isSuccessful){
                Toast.makeText(this@RegisterActivity,"Registration Successful!",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()


                }else{
                    Toast.makeText(this@RegisterActivity,"Registration Failed! ${p1.message()}",Toast.LENGTH_SHORT).show()

                }
            }


            override fun onFailure(p0: Call<RegisterResponse?>, t: Throwable) {
                Toast.makeText(this@RegisterActivity,"Error: ${t.message}",Toast.LENGTH_SHORT).show()
            }
        })
    }
}