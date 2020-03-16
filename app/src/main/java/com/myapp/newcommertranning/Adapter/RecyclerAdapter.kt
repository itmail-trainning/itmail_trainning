package com.myapp.newcommertranning.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapp.newcommertranning.R
import kotlinx.android.synthetic.main.item_search_list.*

class RecyclerAdapter(context: Context, val data: List<String>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_search_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        // データ数
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // ラベルに行番号をセット
        holder.lblNumber.text = (position + 1).toString()
        // 内容にデータをセット
        holder.lblItem.text = data[position]

        if((position + 1) % 5 == 0) {
            holder.lblNumber.setBackgroundColor(Color.RED)
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // ラベル
        val lblNumber: TextView = itemView.findViewById(R.id.lblNumber)
        // 内容
        val lblItem: TextView = itemView.findViewById(R.id.lblItem)

    }

}