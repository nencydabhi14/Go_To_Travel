package com.example.gototravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.gototravel.databinding.ActivityBaliDetailsBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class Bali_Details : AppCompatActivity() {

    lateinit var binding: ActivityBaliDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBaliDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.ofwhite)


        binding.backBali.setOnClickListener {
            finish()
        }

        binding.BaliImage.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()

        list.add(
            CarouselItem(
                imageUrl = "https://digital.ihg.com/is/image/ihg/intercontinental-bali-4056117479-2x1?fit=fit,1&wid=2880&hei=1440&qlt=85,0&resMode=sharp2&op_usm=1.75,0.9,2,0"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://www.baliblogger.info/wp-content/uploads/2020/02/Final-Thoughts-in-Bali.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://img-cdn.herbeauty.co/wp-content/uploads/2015/07/Bali-%E2%80%93-Heaven-On-Earth-6.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://www.balitoursandmore.com/wp-content/uploads/2019/08/Mason-Adventures-Sky-Tours-West-Coast-Cruise-Gallery.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://www.honeymoonbug.com/blog/wp-content/uploads/2018/09/Bali-Resorts-compressed.jpg"
            )
        )
        binding.BaliImage.setData(list)

        binding.formBali.setOnClickListener {
            var intent = Intent(this,Booking_Form::class.java)
            intent.putExtra("price","60,000")
            intent.putExtra("place","Bali")
            intent.putExtra("value",2)

            startActivity(intent)
        }
    }
}