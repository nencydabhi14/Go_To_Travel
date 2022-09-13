package com.example.gototravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.gototravel.databinding.ActivityDubaiDetailsBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class Dubai_Details : AppCompatActivity() {

    lateinit var binding: ActivityDubaiDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDubaiDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.ofwhite)

        binding.backDubai.setOnClickListener {
            finish()
        }

        binding.dubaiImage.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()

        list.add(
            CarouselItem(
                imageUrl =  "https://bigpicture.ru/wp-content/uploads/2014/03/Dubai04.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://iso.500px.com/wp-content/uploads/2015/08/dubai_cover.jpeg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://www.thedubainow.com/wp-content/uploads/2020/07/DUKES_VIEW_01.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://www.arabnews.com/sites/default/files/main-image/2020/12/27/2402351-1375992260.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://www.elysian.com/uploads/news/thumb-dubai-timeshare-law0.jpg",
            )
        )
        binding.dubaiImage.setData(list)

            binding.formDubai.setOnClickListener {
                var intent = Intent(this,Booking_Form::class.java)
                intent.putExtra("price","2,00,000")
                intent.putExtra("place","Dubai")
                intent.putExtra("value",0)
                startActivity(intent)
            }

    }
}