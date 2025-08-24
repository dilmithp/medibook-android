package com.example.lab_exam_2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_exam_2.R

// Data model for welcome screens
data class WelcomeScreen(
    val imageRes: Int,
    val title: String,
    val description: String
)

class WelcomeViewPagerAdapter(private val items: List<WelcomeScreen>) :
    RecyclerView.Adapter<WelcomeViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.ivWelcome)
        val titleView: TextView = view.findViewById(R.id.tvTitle)
        val descView: TextView = view.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_welcome_pager, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageRes)
        holder.titleView.text = item.title
        holder.descView.text = item.description
    }

    override fun getItemCount(): Int = items.size
}
