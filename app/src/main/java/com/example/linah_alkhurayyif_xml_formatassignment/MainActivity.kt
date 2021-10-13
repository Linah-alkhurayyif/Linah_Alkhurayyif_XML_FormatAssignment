package com.example.linah_alkhurayyif_xml_formatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var student_tv: TextView
    private lateinit var students: ArrayList<Student>
    private lateinit var My_students: ArrayList<Student>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try{
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("studentdetails.xml")
            students = parser.parse(iStream) as ArrayList<Student>
            My_students = arrayListOf()
            var text = ""
            for(student in students){
                My_students.add(Student(student.id,student.name,student.marks))
            }
        }catch (e: IOException) {
            println("ISSUE: $e")
        }
        recyclerView.adapter = StudentAdapter(My_students)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}