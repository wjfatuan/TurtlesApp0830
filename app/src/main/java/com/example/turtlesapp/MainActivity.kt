package com.example.turtlesapp

import android.os.Bundle
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

        binding?.btnRaphael?.setOnClickListener {
            showCharacter("raphael")
        }

        binding?.btnDonatello?.setOnClickListener {
            showCharacter("donatello")
        }

        binding?.btnMike?.setOnClickListener {
            showCharacter("michelangelo")
        }
    }

    fun showCharacter(name: String) {
        when (name) {
            "raphael" -> binding?.imgCharacter?.setImageResource(R.drawable.raphael)
            "donatello" -> binding?.imgCharacter?.setImageResource(R.drawable.donatello)
            "michelangelo" -> binding?.imgCharacter?.setImageResource(R.drawable.michelangelo)
        }
    }
}