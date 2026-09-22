package com.example.studymate

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginSSOActivity : AppCompatActivity() {
    private lateinit var textViewAccountName : TextView
    private lateinit var textViewAccountEmail : TextView

    private lateinit var textViewAccountMenu : TextView
    private lateinit var textViewPlus: TextView

    private lateinit var layoutExistingAccount: LinearLayout

    private lateinit var fragmentContainerView: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_sso_activity)

        textViewAccountName=findViewById<TextView>(R.id.textViewAccountName)
        textViewAccountEmail=findViewById<TextView>(R.id.textViewAccountEmail)

        textViewAccountMenu=findViewById<TextView>(R.id.textViewAccountMenu)
        textViewPlus=findViewById<TextView>(R.id.textViewPlus)
        layoutExistingAccount=findViewById<LinearLayout>(R.id.layoutExistingAccount)



        layoutExistingAccount.setOnClickListener {
            loginSSo()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_sso)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



    }
    fun loginSSo(){

       val email = textViewAccountEmail.text.toString()

        val request = LoginSSO( )
        RetroFitClient.api.loginSSO(request).enqueue(object : Callback<LoginResponse?>{

            override fun onResponse(p0: Call<LoginResponse?>, p1: Response<LoginResponse?>) {
                if (p1.isSuccessful){
                    Toast.makeText(this@LoginSSOActivity,"Login Successful!",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
                        HomeFragment()).commit()

                }else{
                    Toast.makeText(this@LoginSSOActivity,"Login Failed! ${p1.message()}",Toast.LENGTH_SHORT).show()
                }
            }


            override fun onFailure(p0: Call<LoginResponse?>, t: Throwable) {
                Toast.makeText(this@LoginSSOActivity,"Error: ${t.message}",Toast.LENGTH_SHORT).show()
            }
        })
    }
    }
