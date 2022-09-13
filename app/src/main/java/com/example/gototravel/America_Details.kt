package com.example.gototravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.gototravel.databinding.ActivityAmericaDetailsBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class America_Details : AppCompatActivity() {

    lateinit var binding: ActivityAmericaDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAmericaDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.ofwhite)


        binding.backAmerica.setOnClickListener {
            finish()
        }

        binding.americaImage.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()

        list.add(
            CarouselItem(
                imageUrl = "https://img4.goodfon.ru/original/2560x1600/8/3e/philadelphia-pennsylvania-united-states-of-america-usa-skysc.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://img1.goodfon.com/original/2112x1320/8/aa/ssha-kaliforniya-california-san-5887.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://s1.1zoom.me/big7/606/USA_Houses_San_Diego_497410.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://img2.goodfon.com/original/2768x1554/f/f4/philly-waking-up-philadelphia.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://yesofcorsa.com/wp-content/uploads/2018/06/Seattle-Wallpaper-Gallery.jpg",
            )
        )
        binding.americaImage.setData(list)

        binding.formAmerica.setOnClickListener {
            var intent = Intent(this,Booking_Form::class.java)
            intent.putExtra("price","3,00,000")
            intent.putExtra("place","America")
            intent.putExtra("value",5)

            startActivity(intent)
        }
    }
}