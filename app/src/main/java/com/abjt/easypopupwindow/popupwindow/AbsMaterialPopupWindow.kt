package com.abjt.easypopupwindow.popupwindow

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.core.widget.PopupWindowCompat
import androidx.viewbinding.ViewBinding
import com.abjt.easypopupwindow.R

abstract class AbsMaterialPopupWindow<VB : ViewBinding>(private val context: Context) {

    private var _materialPopupWindow: PopupWindow? = null

    private lateinit var _binding: VB

    private val layoutInflater: LayoutInflater
        get() = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)

    val binding: VB
        get() = _binding

    val materialPopupWindow: PopupWindow?
        get() = try {
            _materialPopupWindow
        } catch (npe: NullPointerException) {
            throw npe
        }

    abstract fun initBinding(layoutInflater: LayoutInflater): VB

    init {
        Log.d("PopupWindow -> ", " Base window init")
        create()
        setContentView()
        setOutsideTouchable(true)
        setWindowFocusable(true)
        setBackground(ColorDrawable(ContextCompat.getColor(context, R.color.transparent)))
    }

    private fun create(attributeSet: AttributeSet? = null) = apply {
        attributeSet?.let {
            _materialPopupWindow = PopupWindow(context, attributeSet)
        } ?: let {
            _materialPopupWindow = PopupWindow(context)
        }
        _binding = initBinding(layoutInflater)
        Log.d("PopupWindow -> ", " Base created and bound")
    }

    private fun setContentView() = apply {
        _materialPopupWindow?.contentView = _binding.root
    }

    private fun setContentView(@LayoutRes layoutRes: Int) = apply {
        _materialPopupWindow?.contentView = layoutInflater.inflate(layoutRes, null)
    }

    fun setBackground(drawable: Drawable) = apply {
        _materialPopupWindow?.setBackgroundDrawable(drawable)
    }

    fun setWindowDimensions(
        widthInDp: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
        heightInDp: Int = ViewGroup.LayoutParams.WRAP_CONTENT
    ) = apply {
        _materialPopupWindow?.apply {
            width = widthInDp
            height = heightInDp
        }
    }

    fun setOutsideTouchable(isOutsideTouchable: Boolean) = apply {
        _materialPopupWindow?.isOutsideTouchable = isOutsideTouchable
    }

    fun setWindowFocusable(isFocusableWindow: Boolean) = apply {
        _materialPopupWindow?.isFocusable = isFocusableWindow
    }

    fun showAsDropDownMenu(anchorView: View) = apply {
        _materialPopupWindow?.showAsDropDown(anchorView)
    }

    fun showAsDropDownMenu(
        anchorView: View,
        xOffsetInDp: Int,
        yOffsetInDp: Int
    ) = apply {
        _materialPopupWindow?.showAsDropDown(anchorView, xOffsetInDp, yOffsetInDp)
    }

    fun showAsDropDownMenu(
        anchorView: View,
        xOffsetInDp: Int, yOffsetInDp: Int,
        gravity: Int
    ) = apply {
        _materialPopupWindow?.showAsDropDown(anchorView, xOffsetInDp, yOffsetInDp, gravity)
    }

    fun showWindowAtLocation(
        parentView: View,
        gravity: Int,
        xOffsetInDp: Int,
        yOffsetInDp: Int
    ) = apply {
        _materialPopupWindow?.showAtLocation(parentView, gravity, xOffsetInDp, yOffsetInDp)
    }
}