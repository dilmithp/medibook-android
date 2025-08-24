package com.example.lab_exam_2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_exam_2.R

data class Doctor(val name: String, val specialization: String, val hospital: String, val photoRes: Int)

class DoctorListAdapter(private val doctors: List<Doctor>)
    : RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctors[position]
        holder.tvName.text = doctor.name
        holder.tvSpecialization.text = doctor.specialization
        holder.tvHospital.text = doctor.hospital
        holder.ivPhoto.setImageResource(doctor.photoRes)
    }

    override fun getItemCount() = doctors.size

    inner class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvDoctorName)
        val tvSpecialization: TextView = itemView.findViewById(R.id.tvSpecialization)
        val tvHospital: TextView = itemView.findViewById(R.id.tvHospital)
        val ivPhoto: ImageView = itemView.findViewById(R.id.ivDoctorPhoto)
    }
}
