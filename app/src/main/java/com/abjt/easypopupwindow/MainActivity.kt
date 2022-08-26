package com.abjt.easypopupwindow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.abjt.easypopupwindow.databinding.ActivityMainBinding
import com.abjt.easypopupwindow.popupwindow.PlainTextPopupWindow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvShow.setOnClickListener {
            showTextPopupWindow(it)
        }
    }

    private fun showTextPopupWindow(parentView: View) {

        PlainTextPopupWindow(this).show {
            create()
            setContentView()
            showWindowAtLocation(parentView, Gravity.CENTER, 20, 0)
            setWindowFocusable(true)
            setText("Hi Im a noob Programmer")
        }
    }
}