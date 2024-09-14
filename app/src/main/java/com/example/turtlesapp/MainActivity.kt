package com.example.turtlesapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.turtlesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding? = null
    val turtleNames = arrayListOf("Donatello","Michelangelo")

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

        val myAdapter = TurtlesAdapter(this, R.layout.list_turtles, turtleNames)
        binding?.turtlesList?.adapter = myAdapter

        binding?.turtlesList?.setOnItemClickListener { adapterView, view, index, id ->
            Log.d("LISTVIEW", "listview: $adapterView")
            Log.d("LISTVIEW", "view: $view")
            Log.d("LISTVIEW", "index: $index")
            Log.d("LISTVIEW", "id: $id")
            showCharacter(turtleNames[index])
            turtleNames.add("Splinter")
            myAdapter.notifyDataSetChanged()

            val it = Intent(this, TurtleDetailActivity::class.java)
            it.putExtra("TURTLE_NAME",turtleNames[index])
            startActivity(it)
        }
    }

    fun showCharacter(name: String) {
        var id = resources.getIdentifier(name, "drawable", packageName)
        binding?.imgCharacter?.setImageResource(id)
    }
}