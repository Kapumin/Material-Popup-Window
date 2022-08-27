package com.abjt.easypopupwindow.popupwindow

import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.StringRes
import com.abjt.easypopupwindow.databinding.LayoutTextViewBinding

class MaterialTextPopupWindow(private val context: Context) :
    AbsMaterialPopupWindow<LayoutTextViewBinding>(context) {

    override fun initBinding(layoutInflater: LayoutInflater): LayoutTextViewBinding =
        LayoutTextViewBinding.inflate(layoutInflater)

    fun setText(@StringRes stringRes: Int) = apply {
        binding.tvPopupWindow.setText(stringRes)
    }

    fun setText(text: String) = apply {
        binding.tvPopupWindow.text = text
    }

    fun show(builder: MaterialTextPopupWindow.() -> Unit): MaterialTextPopupWindow = apply(builder)
}