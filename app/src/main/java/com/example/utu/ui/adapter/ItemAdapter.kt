package com.example.utu.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.utu.R
import com.example.utu.data.model.Item

class ItemAdapter(private val itemList: ArrayList<Item>, val context: Context) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    lateinit var clickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

    class ItemViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val frameLayout: FrameLayout = itemView.findViewById(R.id.item_frame_layout)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_item, parent, false),
            clickListener
        )
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val item = itemList[position]

        val avatar: ImageView = ImageView(context)


        when (item.feedType) {
            "top-post" -> {

                Glide.with(context)
                    .load("Your image url parse this place")
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .thumbnail(0.1f)
                    .into(avatar)


            }
            "edu-tip" -> {

            }
            "nft-sale" -> {

            }
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}