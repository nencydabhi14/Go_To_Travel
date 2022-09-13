package com.example.gototravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.gototravel.databinding.ActivityMaldivesDetailsBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class Maldives_Details : AppCompatActivity() {

    lateinit var binding: ActivityMaldivesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMaldivesDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.ofwhite)

        binding.backMaldives.setOnClickListener {
            finish()
        }

        binding.maldivesImage.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()

        list.add(
            CarouselItem(
                imageUrl = "https://static2.abitare.it/wp-content/uploads/2019/11/01-Kudadoo-Maldives-Yuji-Yamazaki-p.jpg?v=395361"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://www.seal-superyachts.com/wp-content/uploads/2017/07/Kanuhura-Maldives-1.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://rupseholidays.com/assets/images/maldives.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://www.welgrowgroup.com/blog/wp-content/uploads/2021/05/WhatsApp-Image-2021-05-17-at-1.11.38-PM.jpeg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://pbs.twimg.com/media/D9-rjxxXsAU933d.jpg"
            )
        )

        binding.maldivesImage.setData(list)


        binding.formMaldives.setOnClickListener {
            var intent = Intent(this,Booking_Form::class.java)
            intent.putExtra("price","1,00,000")
            intent.putExtra("place","MalDives")
            intent.putExtra("value",1)

            startActivity(intent)
        }
    }
}