package a.a.fff

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            startActivity(Intent(MainActivity@ this, MainActivity1::class.java))
        }
    }


}