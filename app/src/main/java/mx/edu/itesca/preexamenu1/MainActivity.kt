package mx.edu.itesca.preexamenu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cent = findViewById<EditText>(R.id.etC)
        val far = findViewById<EditText>(R.id.etF)
        val f = findViewById<Button>(R.id.btnGF)
        val c = findViewById<Button>(R.id.btnGC)

        c.setOnClickListener {
            val c1 = cent.text.toString().toLongOrNull()
            val f1 = cent.text.toString().toLongOrNull()

            if(f1 != null){
                val res = (f1-32)/1.8
                cent.setText((res).toString())
            }else{
                cent.setText("Por favor, ingrese números vállidos.")
            }
        }

        f.setOnClickListener {
            val c1 = cent.text.toString().toLongOrNull()
            val f1 = cent.text.toString().toLongOrNull()

            if(c1 != null){
                val res = c1*1.8+32
                far.setText((res).toString())
            }else{
                far.setText("Por favor, ingrese números vállidos.")
            }
        }
    }
}