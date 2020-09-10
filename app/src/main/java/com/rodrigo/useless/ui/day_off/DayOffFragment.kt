package com.rodrigo.useless.ui.day_off

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.rodrigo.useless.R
import java.util.*

class DayOffFragment : Fragment() {

    private lateinit var dayOffViewModel: DayOffViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dayOffViewModel =
            ViewModelProviders.of(this).get(DayOffViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_day_off, container, false)
        val calendarView: CalendarView = root.findViewById(R.id.calendarView)
        val dayOffView: TextView = root.findViewById(R.id.day_off_value)

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val cal = Calendar.getInstance()
            cal.set(year, month, dayOfMonth)
            val res: String = isDayOff(cal)
            if (res !== "") {
                dayOffView.text = "Folga! " + res
            } else {
                dayOffView.text = "Melhor ir trabalhar..."
            }
        }
        return root
    }

    private fun isDayOff(cal: Calendar): String {
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) return "Final de semana"
        if (month == Calendar.JANUARY && day == 1) return "Confraternização universal"
        if (month == Calendar.MARCH && (day == 4 || day == 5)) return "Carnaval"
        if (month == Calendar.MAY && day == 1) return "Dia do trabalho"
        if (month == Calendar.JUNE && day == 20) return "Corpus Christi"
        if (month == Calendar.SEPTEMBER && day == 7) return "Dia da independência"
        if (month == Calendar.OCTOBER && day == 12) return "Nossa Senhora Aparecida"
        if (month == Calendar.NOVEMBER && day == 2) return "Finados"
        if (month == Calendar.NOVEMBER && day == 15) return "Proclamação da República"
        if (month == Calendar.DECEMBER && day == 25) return "Natal"

        return ""
    }
}