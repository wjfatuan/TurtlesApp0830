package com.example.turtlesapp

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class TurtlesAdapter(val ctx: MainActivity, val layout: Int, val data: ArrayList<String>)
    : ArrayAdapter<String>(ctx, layout, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = ctx.layoutInflater.inflate(layout, null, false)
        val tv = view.findViewById<TextView>(R.id.turtle_name)
        tv.text = data[position]
        return view
    }
}