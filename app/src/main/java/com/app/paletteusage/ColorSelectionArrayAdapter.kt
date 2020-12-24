package com.app.paletteusage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.color_selection_item_layout.view.*

class ColorSelectionArrayAdapter(private val colorsList: List<ColorsModel>): BaseAdapter() {
    override fun getCount(): Int {
        return colorsList.size
    }

    override fun getItem(position: Int): ColorsModel {
        return colorsList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView
                ?: LayoutInflater.from(parent?.context).inflate(R.layout.color_selection_item_layout, null, false)
        val icon = view.image_view_color_image
        val name = view.text_view_color_name

        icon.setImageResource(getItem(position).colorImage)
        name.text = getItem(position).colorImage.toString()
        return view
    }
}