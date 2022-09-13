package com.example.gototravel

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView

class Selection_Image(
    val homePageScreen: Home_page_Screen,
    val image: Array<Int>,
    val plce_name: Array<String>
) : RecyclerView.Adapter<Selection_Image.ViewData>() {


    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text_view = itemView.findViewById<TextView>(R.id.text_view)
        var image_view = itemView.findViewById<ImageView>(R.id.image_view)
        var details = itemView.findViewById<RelativeLayout>(R.id.details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view =
            LayoutInflater.from(homePageScreen).inflate(R.layout.view_selection, parent, false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.text_view.text = plce_name[position]
        holder.image_view.setImageResource(image[position])

        holder.details.setOnClickListener {

            if (position == 0) {
                var intent = Intent(homePageScreen, Dubai_Details::class.java)
                homePageScreen.startActivity(intent)
            }
            if (position == 1) {
                var intent = Intent(homePageScreen, Maldives_Details::class.java)
                homePageScreen.startActivity(intent)
            }
            if (position == 2) {
                var intent = Intent(homePageScreen, Bali_Details::class.java)
                homePageScreen.startActivity(intent)
            }
            if (position == 3) {
                var intent = Intent(homePageScreen, Singapore_Details::class.java)
                homePageScreen.startActivity(intent)
            }
            if (position == 4) {
                var intent = Intent(homePageScreen, Mascow_Details::class.java)
                homePageScreen.startActivity(intent)
            }
            if (position == 5) {
            var intent = Intent(homePageScreen, America_Details::class.java)
            homePageScreen.startActivity(intent)
        }

        }

    }

    override fun getItemCount(): Int {
        return image.size
    }
}