package com.example.linah_alkhurayyif_xml_formatassignment

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class MyXmlPullParserHandler {
    private val students = ArrayList<Student>()
    private var text: String? = null
    private var studentName = ""
    private var studentId = 0
    private var studentMarks = 0
    fun parse(inputStream: InputStream): List<Student> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("name", ignoreCase = true) -> {
                            studentName = text.toString()
                        }
                        tagName.equals("id", ignoreCase = true) -> {
                            studentId = text!!.toInt()
                        }
                        tagName.equals("marks", ignoreCase = true) -> {
                            studentMarks = text!!.toInt()
                        }
                        tagName.equals("StudentDetails", ignoreCase = true) -> {

                        }
                        else -> students.add(Student(studentId, studentName,studentMarks))
                    }
                    else -> {
                    }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return students
    }
}