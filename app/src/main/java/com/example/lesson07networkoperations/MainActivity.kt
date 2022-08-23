package com.example.lesson07networkoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
//these are not network exercices. These are about fragments, transferring data between fragments
//and dialogs

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, CustomDialog1())
            .commit()
    }
}

fun Fragment.addFragment(fragment: Fragment) {
    val activity = requireActivity() as? MainActivity ?: error("")
    activity
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, fragment)
        .addToBackStack(null)
        .commit()
}