package com.example.gototravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.gototravel.databinding.ActivityMascowDetailsBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class Mascow_Details : AppCompatActivity() {

    lateinit var binding: ActivityMascowDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMascowDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.ofwhite)

        binding.backMoscow.setOnClickListener {
            finish()
        }

        binding.moscowImg.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()

        list.add(
            CarouselItem(
                imageUrl = "https://img5.goodfon.ru/wallpaper/original/a/36/moskva-siti-presnenskaia-naberezhnaia-moskva-reka-moskva-r-1.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://www.fintechfutures.com/files/2016/07/moscow.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://wallpapercave.com/wp/wp4650666.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://img-fotki.yandex.ru/get/32/30348152.1a0/0_8324d_d4993c9a_orig"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://pbs.twimg.com/media/CVZOhjIU8AATmOa?format=jpg&name=medium"
            )
        )
        binding.moscowImg.setData(list)

        binding.formMoscow.setOnClickListener {
            var intent = Intent(this,Booking_Form::class.java)
            intent.putExtra("price","90,000")
            intent.putExtra("place","Moscow")
            intent.putExtra("value",4)

            startActivity(intent)
        }
    }
}