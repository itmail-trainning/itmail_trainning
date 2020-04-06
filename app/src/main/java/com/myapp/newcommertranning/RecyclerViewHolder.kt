package com.myapp.newcommertranning

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapp.newcommertranning.R

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // 独自に作成したListener
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val itemTextView: TextView = view.findViewById(R.id.text_1)
    val itemImageView: ImageView = view.findViewById(R.id.image)

    init {
        // layoutの初期設定するときはココ
    }

}
