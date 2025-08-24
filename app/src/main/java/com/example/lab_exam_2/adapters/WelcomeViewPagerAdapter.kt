package com.example.lab_exam_2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_exam_2.R

class WelcomeViewPagerAdapter(private val items: List<WelcomeItem>)
    : RecyclerView.Adapter<WelcomeViewPagerAdapter.WelcomeViewHolder>() {

    data class WelcomeItem(val imageRes: Int, val title: String, val description: String)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WelcomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_welcome_pager, parent, false)
        return WelcomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: WelcomeViewHolder, position: Int) {
        val item = items[position]
        holder.ivWelcome.setImageResource(item.imageRes)
        holder.tvTitle.text = item.title
        holder.tvDescription.text = item.description
    }

    override fun getItemCount() = items.size

    inner class WelcomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivWelcome: ImageView = itemView.findViewById(R.id.ivWelcome)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }
}
