package com.example.studymate

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var textviewTaskName: TextView
    private lateinit var textviewStudyMate: TextView
    private lateinit var textviewWelcome : TextView
    private lateinit var textviewDate : TextView
    private lateinit var textviewTodayTitle : TextView
    private lateinit var cardTodayTask : CardView
    private lateinit var textviewTaskDetails : TextView
    private lateinit var textviewUpcomingTitle : TextView
    private lateinit var cardUpcomingTask : CardView
    private lateinit var textviewUpcomingDetails : TextView
    private lateinit var textviewProgressTitle : TextView
    private lateinit var cardProgress : CardView
    private lateinit var textviewCompleted : TextView
    private lateinit var textviewPercentage : TextView
    private lateinit var bottomNav : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContentView(R.layout.activity_main)
        textviewTaskName= findViewById<TextView>(R.id.textviewTaskName)
        textviewStudyMate= findViewById<TextView>(R.id.textviewStudyMate)
        textviewWelcome = findViewById<TextView>(R.id.textviewWelcome)
        textviewDate = findViewById<TextView>(R.id.textviewDate)
        textviewTodayTitle = findViewById<TextView>(R.id.textviewTodayTitle)
        cardTodayTask = findViewById<CardView>(R.id.cardTodayTask)
        textviewTaskDetails = findViewById<TextView>(R.id.textviewTaskDetails)
        textviewUpcomingTitle  = findViewById<TextView>(R.id.textviewUpcomingTitle)
        cardUpcomingTask  = findViewById<CardView>(R.id.cardUpcomingTask)
        textviewUpcomingDetails  = findViewById<TextView>(R.id.textviewUpcomingDetails)
        textviewProgressTitle = findViewById<TextView>(R.id.textviewProgressTitle)
        cardProgress = findViewById<CardView>(R.id.cardProgress)
        textviewCompleted = findViewById<TextView>(R.id.textviewCompleted)
        textviewPercentage = findViewById<TextView>(R.id.textviewPercentage)
        bottomNav = findViewById<View>(R.id.bottomNav)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}