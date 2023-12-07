package com.mellyssa.sosmulheres
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.mellyssa.sosmulheres.databinding.ActivityMainBinding
import com.mellyssa.sosmulheres.databinding.ActivityTelaOptionsBinding
import com.mellyssa.sosmulheres.databinding.TelaDeLoginBinding


class TelaOptions : AppCompatActivity() {


    private val REQUEST_PHONE_CALL=1
    private val binding by lazy{
        ActivityTelaOptionsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val botaoContatos: ImageView  = findViewById(R.id.imageView6)
        val botaoInformaoces: ImageView = findViewById(R.id.imageView5)
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