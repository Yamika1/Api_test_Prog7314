package com.example.studymate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView

class HomeFragment : Fragment() {
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

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textviewTaskName= view.findViewById<TextView>(R.id.textviewTaskName)
        textviewStudyMate= view.findViewById<TextView>(R.id.textviewStudyMate)
        textviewWelcome = view.findViewById<TextView>(R.id.textviewWelcome)
        textviewDate = view.findViewById<TextView>(R.id.textviewDate)
        textviewTodayTitle = view.findViewById<TextView>(R.id.textviewTodayTitle)
        cardTodayTask = view.findViewById<CardView>(R.id.cardTodayTask)
        textviewTaskDetails = view.findViewById<TextView>(R.id.textviewTaskDetails)
        textviewUpcomingTitle  = view.findViewById<TextView>(R.id.textviewUpcomingTitle)
        cardUpcomingTask  = view.findViewById<CardView>(R.id.cardUpcomingTask)
        textviewUpcomingDetails  = view.findViewById<TextView>(R.id.textviewUpcomingDetails)
        textviewProgressTitle = view.findViewById<TextView>(R.id.textviewProgressTitle)
        cardProgress = view.findViewById<CardView>(R.id.cardProgress)
        textviewCompleted = view.findViewById<TextView>(R.id.textviewCompleted)
        textviewPercentage = view.findViewById<TextView>(R.id.textviewPercentage)
        bottomNav = view.findViewById<View>(R.id.bottomNav)
    }


}