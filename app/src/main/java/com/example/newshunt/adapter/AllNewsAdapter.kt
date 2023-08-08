package com.example.newshunt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.newshunt.AllNewsItem
import com.example.newshunt.R

class AllNewsAdapter : RecyclerView.Adapter<AllNewsAdapter.ViewHolder>() {

    private val itemTitle = arrayOf(
        "Heatwave: Hospitals under KMC put on standby for heatstroke patients",
        "Kalaish Valley: The Hidden Secrets of the people living there",
        "Pakistan will spare no effort to dismantle terrorist networks: COAS",
        "Govt withdraws Pemra amendments bill on journalists concerns"
    )
    private val itemchannelname = arrayOf(
        "ARY News ", "AAj News",
        "InterNitional News", "GEO NEWS"
    )
    private val postDate = arrayOf("12.May.12 ", "31.June.32", "12.August.23", "12.December.12")
    private val item_channel_logo = intArrayOf(
        R.drawable.ary_news_logo,
        R.drawable.ajjnewslogo,
        R.drawable.inter_logo,
        R.drawable.geologo,
    )
    private val item_image = intArrayOf(
        R.drawable.heatwave,
        R.drawable.image_kalash,
        R.drawable.inter_news,
        R.drawable.marriyum_aurangzeb_updates,
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView
        var tv_logo: ImageView
        var channelName: TextView
        var post_date: TextView

        init {
            image = itemView.findViewById(R.id.title_image)
            title = itemView.findViewById(R.id.card_title)
            tv_logo = itemView.findViewById(R.id.channel_logo)
            channelName = itemView.findViewById(R.id.channel_name)
            post_date = itemView.findViewById(R.id.date)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.allnews_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = itemTitle[position]
        holder.channelName.text = itemchannelname[position]
        holder.post_date.text = postDate[position]
        holder.tv_logo.setImageResource(item_channel_logo[position])
        holder.image.setImageResource(item_image[position])

        holder.itemView.setOnClickListener { v: View ->
            Toast.makeText(v.context, "Click On the item", Toast.LENGTH_LONG).show()

        }

    }

    override fun getItemCount(): Int {
        return itemTitle.size
    }
}
