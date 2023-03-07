package com.example.lorenzodwishlist


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wishlistmaker)
        val button = findViewById<Button>(R.id.submitButton)
        val Link = findViewById<EditText>(R.id.editTextUrl)
        val Money = findViewById<EditText>(R.id.editTextPrice)
        val Name = findViewById<EditText>(R.id.editTextName)
        button.setOnClickListener{
            val link = Link.getText().toString()
            val money = Money.getText().toString()
            val Tname = Name.getText().toString()
                lifecycleScope.launch(Dispatchers.IO)
                {
                    (application as ItemApplication).db.itemDao().insertAll(
                        ItemEntity(
                            name = Tname,
                            price = money,
                            url = link,
                        )
                    )
                }
                super.finish()

        }

    }


}