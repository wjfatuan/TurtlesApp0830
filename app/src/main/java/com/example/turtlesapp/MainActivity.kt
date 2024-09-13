package com.example.turtlesapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.turtlesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding?.turtlesList?.setOnItemClickListener { adapterView, view, index, id ->
            Log.d("LISTVIEW", "listview: $adapterView")
            Log.d("LISTVIEW", "view: $view")
            Log.d("LISTVIEW", "index: $index")
            Log.d("LISTVIEW", "id: $id")
            val tv = view as TextView
            showCharacter(tv.text.toString().lowercase())

            val it = Intent(this, TurtleDetailActivity::class.java)
            it.putExtra("TURTLE_NAME",tv.text.toString())
            startActivity(it)
        }
    }

    fun showCharacter(name: String) {
        var id = resources.getIdentifier(name, "drawable", packageName)
        binding?.imgCharacter?.setImageResource(id)
    }
}