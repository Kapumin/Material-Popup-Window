package com.abjt.easypopupwindow.popupwindow

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abjt.easypopupwindow.databinding.ListPopupWindowBinding

class MaterialListPopupWindow<A : RecyclerView.Adapter<*>>(private val context: Context) :
    AbsMaterialPopupWindow<ListPopupWindowBinding>(context) {

    override fun initBinding(layoutInflater: LayoutInflater): ListPopupWindowBinding =
        ListPopupWindowBinding.inflate(layoutInflater)


    private lateinit var _adapter: A
    private lateinit var _layoutManager: RecyclerView.LayoutManager

    init {
        _layoutManager = GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)
    }

    var adapter: A
        get() = _adapter
        set(value) {
            _adapter = value
        }

    var layoutManager
        get() = _layoutManager
        set(value) {
            _layoutManager = value
        }

    fun updateRecyclerView() {
        binding.rvListPopupWindow.apply {
            adapter = _adapter
            layoutManager = _layoutManager
        }
    }

    fun show(builder: MaterialListPopupWindow<A>.() -> Unit): MaterialListPopupWindow<A> =
        apply(builder)

}