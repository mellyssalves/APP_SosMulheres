package com.mellyssa.sosmulheres

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User

import com.mellyssa.sosmulheres.databinding.ActivityCadastroBinding
import com.mellyssa.sosmulheres.model.UsuarioModel

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCadastroBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        db = FirebaseFirestore.getInstance()
        binding.buttonCadastrar.setOnClickListener {
            val nome: String = binding.editTextNome.text.toString()
            val email: String = binding.textEmailCadastro.text.toString()
            val telefone = binding.editTextPhone.text.toString()
            val senha: String = binding.edittextPasswordCadastro.text.toString()
            val confirmaSenha: String = binding.editConfirmarSenha.text.toString()

            if(email.isNotEmpty() && senha.isNotEmpty() && confirmaSenha.isNotEmpty()){
                if(senha==confirmaSenha){
                    cadastrarUsuario(nome,email,telefone,senha)
                }else{
                    Toast.makeText(this@CadastroActivity, "Senhas não coincidem",Toast.LENGTH_SHORT,).show()
                }
            }else{
                Toast.makeText(this@CadastroActivity, "Preencha os campos acima.",Toast.LENGTH_SHORT,).show()
            }
        }

    }





    private  fun cadastrarUsuario(nome:String, email:String, telefone:String, senha:String){
        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener{ task ->
            if (task.isSuccessful) {
                val id = task.result.user?.uid
                if (id != null) {
                    val usr = UsuarioModel(
                        id, nome, email, telefone
                    )
                    salvarFirestore(usr)
                }
//                Log.d(TAG, "createUserWithEmail:success")
//                Toast.makeText(baseContext, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT,)
//                    .show()
                //val user = auth.currentUser
            }
//            }
            //            else {
//                // If sign in fails, display a message to the user.
//                Log.w(TAG, "createUserWithEmail:failure", task.exception)
//                Toast.makeText(baseContext,"Erro ao se cadastrar.",Toast.LENGTH_SHORT,).show()
//
//            }
        }


    }

    private fun salvarFirestore(usr: UsuarioModel){
        db.collection("usuarios").document(usr.id).set(usr).addOnSuccessListener{
            Toast.makeText(applicationContext, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show()
        startActivity(Intent(this,TelaDeLoginActivity::class.java))
        }.addOnFailureListener{
            Toast.makeText(applicationContext, "Erro ao realizar cadastro", Toast.LENGTH_LONG).show()
        }

    }


    companion object {
        private var TAG= "emailEsenha"
    }


}



