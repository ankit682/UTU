package com.example.utu.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.utu.R
import com.example.utu.data.model.Item


class ItemAdapter(private val itemList: ArrayList<Item>, private val context: Context) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val TAG = "ItemAdapter"

    class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        Log.e(TAG, "Inside oncreate()")
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val item = itemList[position]
        Log.e(TAG, "Inside onBindViewHolder()")

        val linear = LinearLayout(context)
        linear.weightSum = 10F
        linear.orientation = LinearLayout.VERTICAL

        val linearTop = LinearLayout(context)
        linearTop.weightSum = 10F
        linearTop.orientation = LinearLayout.HORIZONTAL

        val linearParamTop = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        linearParamTop.weight = 2F
        linearTop.layoutParams = linearParamTop

        val linearParamM = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        linearParamM.weight = 6F

        val linearBottom = LinearLayout(context)
        linearBottom.weightSum = 10F
        linearBottom.orientation = LinearLayout.HORIZONTAL

        val linearParamBottom = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        linearParamBottom.weight = 2F
        linearBottom.layoutParams = linearParamBottom

        val avatar: ImageView = ImageView(context)
        val images: ImageView = ImageView(context)
        val name: TextView = TextView(context)
        val content: TextView = TextView(context)
        val views: TextView = TextView(context)
        val price: TextView = TextView(context)
        val unit: TextView = TextView(context)

        views.text = item.views

        when (item.feedType) {
            "top-post" -> {
                Log.e(TAG, "top-post")

                Glide.with(context)
                    .load(item.dacAvatar)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .override(150,150)
                    .into(avatar)

                name.text = item.nickName
                content.text = item.content

                if (item.images.isNotEmpty()) {
                    Glide.with(context)
                        .load(item.images[0])
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(images)
                }
                images.layoutParams = linearParamM

                avatar.layoutParams = linearParamTop
                name.layoutParams = linearParamTop

                linearTop.addView(avatar)
                linearTop.addView(name)

                content.layoutParams = linearParamBottom
                views.layoutParams = linearParamBottom

                linearBottom.addView(content)
                linearBottom.addView(views)

                linear.addView(linearTop)
                if (item.images.isNotEmpty()) {
                    linear.addView(images)
                }
                linear.addView(linearBottom)
            }
            "edu-tip" -> {
                Log.e(TAG, "edu-tip")
                Glide.with(context)
                    .load(item.eduAvatar)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .override(150,150)
                    .into(avatar)

                name.text = item.eduName

                avatar.layoutParams = linearParamTop
                name.layoutParams = linearParamTop

                linearTop.addView(avatar)
                linearTop.addView(name)

                content.text = item.title
                content.layoutParams = linearParamM

                views.layoutParams = linearParamBottom
                linearBottom.addView(views)

                linear.addView(linearTop)
                linear.addView(content)
                linear.addView(linearBottom)
            }
            "nft-sale" -> {
                Log.e(TAG, "nft-sale")
                Glide.with(context)
                    .load(item.media.cover)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .override(150,150)
                    .into(avatar)

                name.text = item.nickName
                content.text = item.name
                price.text = item.price
                unit.text = item.unit

                if (item.media.image.isNotEmpty()) {
                    Glide.with(context)
                        .load(item.media.image[0])
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(images)
                }
                images.layoutParams = linearParamM

                avatar.layoutParams = linearParamTop
                name.layoutParams = linearParamTop

                linearTop.addView(avatar)
                linearTop.addView(name)

                content.layoutParams = linearParamBottom
                views.layoutParams = linearParamBottom
                price.layoutParams = linearParamBottom
                unit.layoutParams = linearParamBottom

                linearBottom.addView(content)
                linearBottom.addView(views)
                linearBottom.addView(price)
                linearBottom.addView(unit)

                linear.addView(linearTop)
                if (item.media.image.isNotEmpty()) {
                    linear.addView(images)
                }
                linear.addView(linearBottom)
            }
        }
        holder.cardView.addView(linear)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}