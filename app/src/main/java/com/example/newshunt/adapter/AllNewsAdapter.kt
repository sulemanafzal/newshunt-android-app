package com.example.newshunt.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.newshunt.Model.NewsModel
import com.example.newshunt.R
import com.example.newshunt.fragment.NewsDetailFragment

class AllNewsAdapter : RecyclerView.Adapter<AllNewsAdapter.ViewHolder>() {

    private val newsItems = arrayOf(
        NewsModel(
            R.drawable.heatwave,
            "Heatwave: Hospitals under KMC put on standby...",
            R.drawable.ary_news_logo,
            "ARY News",
            "12.May.12",
            R.drawable.share_icon,
            R.drawable.arch_logo,
            "Description 1"
        ),
        NewsModel(
            R.drawable.image_kalash,
            "Kalaish Valley: The Hidden Secrets of the people...",
            R.drawable.ajjnewslogo,
            "AAj News", "31 June 32",
            R.drawable.share_icon,
            R.drawable.arch_logo,
            "Description 2",
        ),
        NewsModel(
            R.drawable.shahabazsharip,
            "Pakistan will spare no effort to dismantle terrorist...",
            R.drawable.inter_logo,
            "InterNitional News", "12.August.23",
            R.drawable.share_icon,
           R.drawable.arch_logo,
            "Description 3"
        ),
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.title_image)
        val title = itemView.findViewById<TextView>(R.id.card_title_politcs)
        val tvLogo = itemView.findViewById<ImageView>(R.id.channel_logo_politcs)
        val channelName = itemView.findViewById<TextView>(R.id.channel_name)
        val postDate = itemView.findViewById<TextView>(R.id.date_detail)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickitem = newsItems[position]

                    val fragment = NewsDetailFragment()
                    val bundle = Bundle()
                    bundle.putInt("image", clickitem.image)
                    bundle.putString("title", clickitem.title)
                    bundle.putInt("newsLogo", clickitem.channelLogo)
                    bundle.putInt("shareLogo", clickitem.shareLogo)
                    bundle.putInt("archLogo", clickitem.archLogo)
                    bundle.putString("channelName", clickitem.channelName)
                    bundle.putString("desc", clickitem.desc)
                    bundle.putString("postDate", clickitem.postDate)

                    fragment.arguments = bundle

                    val transaction: FragmentTransaction =
                        (itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.framelayout, fragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }


                Toast.makeText(it.context, "Click On the item", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.allnews_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = newsItems[position]
        holder.title.text = item.title
        holder.channelName.text = item.channelName
        holder.postDate.text = item.postDate
        holder.tvLogo.setImageResource(item.channelLogo)
        holder.image.setImageResource(item.image)
    }

    override fun getItemCount(): Int = newsItems.size
}
