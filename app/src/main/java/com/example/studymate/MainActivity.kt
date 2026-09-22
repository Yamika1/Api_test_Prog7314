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


class MainActivity : AppCompatActivity() {

    private lateinit var loginPassword : EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSSO : Button
    private lateinit var textviewRegister : TextView
    private lateinit var loginEmail:EditText

    private lateinit var fragmentContainerView: FragmentContainerView
  


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContentView(R.layout.activity_main)


        loginEmail = findViewById<EditText>(R.id.loginEmail)
        loginPassword = findViewById<EditText>(R.id.loginPassword)
        btnLogin = findViewById<Button>(R.id.btnLogin)
        btnSSO = findViewById<Button>(R.id.btnSSO)
        textviewRegister = findViewById<TextView>(R.id.textviewRegister)
        fragmentContainerView = findViewById<FragmentContainerView>(R.id.fragmentContainerView)

        btnLogin.setOnClickListener {

            val email = loginEmail.text.toString().trim()
            val password = loginPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Please fill in all fields",Toast.LENGTH_SHORT).show()
            }
            else{
           login(email, password)
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
        val request = LoginRequest(email=email, password = password)
        RetroFitClient.api.login(request).enqueue(object : Callback<LoginResponse?>{

            override fun onResponse(p0: Call<LoginResponse?>, p1: Response<LoginResponse?>) {
                    if (p1.isSuccessful){
                        Toast.makeText(this@MainActivity,"Login Successful!",Toast.LENGTH_SHORT).show()
                        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
                            HomeFragment()).commit()

                    }else{
                          Toast.makeText(this@MainActivity,"Login Failed! ${p1.message()}",Toast.LENGTH_SHORT).show()
                    }
                }


                override fun onFailure(p0: Call<LoginResponse?>, t: Throwable) {
                    Toast.makeText(this@MainActivity,"Error: ${t.message}",Toast.LENGTH_SHORT).show()
                }
            })
        }
    }