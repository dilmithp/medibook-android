package com.example.lab_exam_2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_exam_2.R

data class ServiceCard(val title: String, val iconRes: Int)

class ServiceCardAdapter(
    private val services: List<ServiceCard>,
    private val onServiceClick: (ServiceCard) -> Unit
) : RecyclerView.Adapter<ServiceCardAdapter.ServiceCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_service_card, parent, false)
        return ServiceCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceCardViewHolder, position: Int) {
        val service = services[position]
        holder.ivIcon.setImageResource(service.iconRes)
        holder.tvTitle.text = service.title
        holder.card.setOnClickListener { onServiceClick(service) }
    }

    override fun getItemCount() = services.size

    inner class ServiceCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card: CardView = itemView.findViewById(R.id.cardService)
        val ivIcon: ImageView = itemView.findViewById(R.id.ivServiceIcon)
        val tvTitle: TextView = itemView.findViewById(R.id.tvServiceTitle)
    }
}
