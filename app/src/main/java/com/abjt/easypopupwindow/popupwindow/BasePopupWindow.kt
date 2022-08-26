package com.abjt.easypopupwindow.popupwindow

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

abstract class BasePopupWindow<VB : ViewBinding>(private val context: Context) : PopupWindow() {

    private var _popupWindow: PopupWindow? = null

    private lateinit var _binding: VB

    private val layoutInflater: LayoutInflater
        get() = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)

    val binding: VB
        get() = _binding

    val popupWindow: PopupWindow?
        get() = try {
            _popupWindow
        } catch (npe: NullPointerException) {
            throw npe
        }


    fun create() = apply {
        _popupWindow = PopupWindow(context)
//        attrs?.let {
//            _popupWindow = PopupWindow(context, attrs)
//        } ?: let {
//            _popupWindow = PopupWindow(context)
//        }
        _binding = initBinding(layoutInflater)
    }

    fun setContentView() = apply {
        _popupWindow?.contentView = _binding.root
    }

    fun setContentView(@LayoutRes layoutRes: Int) = apply {
        _popupWindow?.contentView = layoutInflater.inflate(layoutRes, null)
    }

    fun setBackground(drawable: Drawable) = apply {
        _popupWindow?.setBackgroundDrawable(drawable)
    }

    fun setWindowDimensions(
        widthInDp: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
        heightInDp: Int = ViewGroup.LayoutParams.WRAP_CONTENT
    ) = apply {
        _popupWindow.apply {
            width = widthInDp
            height = heightInDp
        }
    }

    fun setWindowFocusable(isFocusableWindow: Boolean) = apply {
        _popupWindow?.isFocusable = isFocusableWindow
    }

    fun showAsDropDownMenu(anchorView: View) = apply {
        _popupWindow?.showAsDropDown(anchorView)
    }

    fun showAsDropDownMenu(
        anchorView: View,
        xOffsetInDp: Int,
        yOffsetInDp: Int
    ) = apply {
        _popupWindow?.showAsDropDown(anchorView, xOffsetInDp, yOffsetInDp)
    }

    fun showAsDropDownMenu(
        anchorView: View,
        xOffsetInDp: Int, yOffsetInDp: Int,
        gravity: Int
    ) = apply {
        _popupWindow?.showAsDropDown(anchorView, xOffsetInDp, yOffsetInDp, gravity)
    }

    fun showWindowAtLocation(
        parentView: View,
        gravity: Int,
        xOffsetInDp: Int,
        yOffsetInDp: Int
    ) = apply {
        _popupWindow?.showAtLocation(parentView, gravity, xOffsetInDp, yOffsetInDp)
    }


    abstract fun initBinding(layoutInflater: LayoutInflater): VB
}