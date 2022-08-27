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

    val adapter: A
        get() = _adapter


    val layoutManager
        get() = _layoutManager


    fun setupListWindow(
        adapter: A,
        layoutManager: RecyclerView.LayoutManager = this.layoutManager
    ) {
        _adapter = adapter
        _layoutManager = layoutManager
        updateRecyclerView()
    }

    private fun updateRecyclerView() {
        binding.rvListPopupWindow.apply {
            adapter = _adapter
            layoutManager = _layoutManager
        }
    }

    fun show(builder: MaterialListPopupWindow<A>.() -> Unit): MaterialListPopupWindow<A> =
        apply(builder)

}