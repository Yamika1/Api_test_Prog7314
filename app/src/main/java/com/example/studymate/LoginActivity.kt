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

class LoginActivity : AppCompatActivity() {
    private lateinit var textviewLogin: TextView
    private lateinit var loginPassword : TextView
    private lateinit var btnLogin: Button
    private lateinit var btnSSO : Button
    private lateinit var textviewRegister : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        textviewLogin = findViewById<TextView>(R.id.textviewLogin)
        loginPassword = findViewById<TextView>(R.id.loginPassword)
        btnLogin = findViewById<Button>(R.id.btnLogin)
        btnSSO = findViewById<Button>(R.id.btnSSO)
        textviewRegister = findViewById<TextView>(R.id.textviewRegister)


        textviewLogin.setOnClickListener {

            val usernameOrEmail = textviewLogin.text.toString().trim()
            val password = loginPassword.text.toString().trim()

            if (usernameOrEmail.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Please fill in all fields",Toast.LENGTH_SHORT).show()
            }
            else{
                login(usernameOrEmail,password)
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
    fun login(usernameOrEmail:String, password:String){
     /*  -- api call here --
      if (thingythingyCall is successful) {
        Toast.makeText(this,"Successfully Log in!",Toast.LENGTH_SHORT).show()
          startActivity(intent)
          finish()
      }else{
          Toast.makeText(this,"Login Failed! ${task?.exception.message}",Toast.LENGTH_SHORT).show()
      }
*/

    }
}