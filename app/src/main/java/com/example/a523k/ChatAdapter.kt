package com.example.a523k

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(var context:Context, var items: ArrayList<Chat>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]
        if (holder is MessageViewHolder) {
            val shapeableImageView: ShapeableImageView = (holder as MessageViewHolder).iv_profile
            val textView: TextView = (holder as MessageViewHolder).tv_fullname
            shapeableImageView.setImageResource(chat.profile)
            textView.text = chat.fullname
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MessageViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_profile = itemView.findViewById(R.id.iv_profile)
            tv_fullname = itemView.findViewById(R.id.fullname)
        }
    }
}

