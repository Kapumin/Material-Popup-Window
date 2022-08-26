package com.abjt.easypopupwindow.popupwindow

import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.StringRes
import com.abjt.easypopupwindow.databinding.LayoutTextViewBinding

class PlainTextPopupWindow(context: Context) : BasePopupWindow<LayoutTextViewBinding>(context) {

    override fun initBinding(layoutInflater: LayoutInflater): LayoutTextViewBinding =
        LayoutTextViewBinding.inflate(layoutInflater)

    fun setText(@StringRes stringRes: Int) = apply {
        binding.tvPopupWindow.setText(stringRes)
    }

    fun setText(text: String) =apply {
        binding.tvPopupWindow.text = text
    }

    fun show(builder: PlainTextPopupWindow.() -> Unit): PlainTextPopupWindow.() -> Unit {

        return builder
    }
}