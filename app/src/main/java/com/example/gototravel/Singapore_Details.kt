package com.example.gototravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.gototravel.databinding.ActivitySingaporeDetailsBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class Singapore_Details : AppCompatActivity() {

    lateinit var binding: ActivitySingaporeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySingaporeDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.ofwhite)

        binding.backSingapore.setOnClickListener {
            finish()
        }

        binding.singaporeImage.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()

        list.add(
            CarouselItem(
                imageUrl = "https://www.gap360.com/tpl/lib/img/public/compressed-images/tpl/lib/img/private/media/hu-chen-cblrzlstg-unsplash-1480x1004-85.jpeg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://images.pexels.com/photos/2880606/pexels-photo-2880606.jpeg?auto=compress&cs=tinysrgb&fit=crop&h=627&w=1200"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://delood.com/wp-content/uploads/2011/07/ssp-delood-02.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://suomik.com/images/stories/singapore-merlion.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://wavemaker.vc/sea/wp-content/uploads/GettyImages-505451902.jpeg"
            )
        )
        binding.singaporeImage.setData(list)

        binding.formSingapore.setOnClickListener {
            var intent = Intent(this,Booking_Form::class.java)
            intent.putExtra("price","1,40,000")
            intent.putExtra("place","Singapore")
            intent.putExtra("value",3)
            startActivity(intent)
        }

    }
}