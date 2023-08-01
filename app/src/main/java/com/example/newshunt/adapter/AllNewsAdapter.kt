package com.example.newshunt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newshunt.AllNewsItem
import com.example.newshunt.R

class AllNewsAdapter(private val newsList: List<AllNewsItem>) :
    RecyclerView.Adapter<AllNewsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.allnews_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = newsList[position]

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
