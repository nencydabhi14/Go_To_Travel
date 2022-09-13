package com.example.gototravel

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gototravel.databinding.ActivityHomePageScreenBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class Home_page_Screen : AppCompatActivity() {

    lateinit var binding: ActivityHomePageScreenBinding
    var image = arrayOf(R.drawable.dubai,R.drawable.maldiu,R.drawable.bali,R.drawable.singapole,R.drawable.mosko,R.drawable.america)
    var plce_name = arrayOf("Dubai","Maldives","Bali","Singapore","Moscow","America")

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomePageScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)

        var adaptor = Selection_Image(this, image,plce_name)
        var lm = GridLayoutManager(this,2)
        binding.recyclerImage.layoutManager = lm
        binding.recyclerImage.adapter = adaptor

        binding.carousel.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()

        list.add(
            CarouselItem(
                imageUrl = "https://images.pexels.com/photos/162031/dubai-tower-arab-khalifa-162031.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://i.pinimg.com/736x/8f/a9/2d/8fa92d19eb7b8ccc6c3779303191276a.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://theiphonewalls.com/wp-content/uploads/2013/03/Highway-To-The-City.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://i.pinimg.com/originals/e0/a8/32/e0a832c34d8ee0c96c33f3b560bd3f89.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://i.pinimg.com/originals/17/d6/8b/17d68be2bd71b957e5006df210eb26ed.jpg",
            )
        )
        binding.carousel.setData(list)


        binding.bookingTickets.setOnClickListener {
            var intent = Intent(this, All_Tickets::class.java)
            startActivity(intent)
        }

    }
}