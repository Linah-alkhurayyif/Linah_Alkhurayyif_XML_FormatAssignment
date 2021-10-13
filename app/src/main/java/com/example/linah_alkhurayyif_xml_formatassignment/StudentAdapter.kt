package com.example.linah_alkhurayyif_xml_formatassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_item.view.*

class StudentAdapter(private val studentNames: List<Student>) : RecyclerView.Adapter<StudentAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.student_item
                ,parent
                ,false
            )
        )

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val studentName =studentNames[position]

        holder.itemView.apply{
            name_tv.text=studentName.name
            marks_tv.text =studentName.marks.toString()
        }

    }

    override fun getItemCount() = studentNames.size

}