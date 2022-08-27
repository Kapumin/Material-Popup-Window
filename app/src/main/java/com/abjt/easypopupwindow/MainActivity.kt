package com.abjt.easypopupwindow

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.abjt.easypopupwindow.databinding.ActivityMainBinding
import com.abjt.easypopupwindow.popupwindow.MaterialListPopupWindow
import com.abjt.easypopupwindow.popupwindow.MaterialTextPopupWindow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            mbListPopup.setOnClickListener {
                showListPopupWindow(it)
            }
            mbTextPopup.setOnClickListener {
                showTextPopupWindow(it)
            }
        }
    }

    private fun showTextPopupWindow(parentView: View) = MaterialTextPopupWindow(this).show {
        showAsDropDownMenu(parentView, 0, (-1.8 * parentView.height).toInt(), Gravity.CENTER)
        setText("Hi Im a noob Programmer")
    }

    private fun showListPopupWindow(anchorView: View) =
        MaterialListPopupWindow<SimpleListAdapter>(this).show {
            showAsDropDownMenu(anchorView)
            adapter = SimpleListAdapter()
            updateRecyclerView()
        }
}