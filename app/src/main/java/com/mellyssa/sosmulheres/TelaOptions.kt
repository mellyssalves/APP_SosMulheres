package com.mellyssa.sosmulheres
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.mellyssa.sosmulheres.databinding.ActivityTelaOptionsBinding
import org.w3c.dom.Text


class TelaOptions : AppCompatActivity() {


    private val REQUEST_PHONE_CALL=1
    private val binding by lazy{
        ActivityTelaOptionsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val btnProtect: ImageView = findViewById(R.id.btnProtect)
        val textMessage: TextView = findViewById(R.id.textMessage)
        btnProtect.setOnClickListener {
            Thread(Runnable{
                Thread.sleep(5000)
                runOnUiThread{
                    textMessage.text= "Redirecionando para site de medida protetiva!"
                }
            }).start()
        }

        val btnInfo: ImageView = findViewById(R.id.btnInfo)
        val textMessage2: TextView = findViewById(R.id.textMessage2)
        btnInfo.setOnClickListener {
            Thread(Runnable{
            Thread.sleep(5000)
            runOnUiThread {
                textMessage2.text = "Informações verificadas"
            }
        }).start()
        }


        val botaoContatos: ImageView  = findViewById(R.id.imageView6)
        val botaoInformaoces: ImageView = findViewById(R.id.btnInfo)
        val botaoSOS: ImageView = findViewById(R.id.imageView2)

        botaoContatos.setOnClickListener {
            val intent = Intent(this, ListaContatosActivity::class.java)
            startActivity(intent)
        }

        botaoInformaoces.setOnClickListener {
            val bntInformações = Intent(this, TelaInformacoes::class.java)
            startActivity(bntInformações)
        }

        botaoSOS.setOnClickListener {
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!=
                PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE ),
                    REQUEST_PHONE_CALL)
            }else{
                val dialIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + 89994610479))
                startActivity(dialIntent)
            }
        }

//

        inicializaToolbar()


        }





    private fun inicializaToolbar(){
        val toolbar = binding.toolbarOptions.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.apply{
            title = "SOS MULHERES"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun checkPermission(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), 101)
        }
    }




}