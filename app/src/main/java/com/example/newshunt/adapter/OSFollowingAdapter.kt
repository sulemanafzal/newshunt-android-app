package com.example.newshunt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newshunt.Model.OSFollowingItem
import com.example.newshunt.R
import com.example.newshunt.databinding.OpinionsSelectionItemBinding

class OSFollowingAdapter(val dataList:ArrayList<OSFollowingItem>, var context: Context):RecyclerView.Adapter<OSFollowingAdapter.OSFollowingViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OSFollowingViewHolder {
       /* var view = LayoutInflater.from(context).inflate(R.layout.opinions_selection_item, parent, false)
        return OSFollowingViewHolder(view)*/

        var binding = OpinionsSelectionItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return OSFollowingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OSFollowingViewHolder, position: Int) {
        holder.binding.channelLogoPolitcs.setImageResource(dataList.get(position).logoResId)
        holder.binding.exitLogo.setImageResource(dataList.get(position).exitResId)
        holder.binding.tvPoliticsName.text  = dataList.get(position).journalistName
        holder.binding.tvLocation.text  = dataList.get(position).location
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class OSFollowingViewHolder(var binding:OpinionsSelectionItemBinding):RecyclerView.ViewHolder(binding.root){

    }
}