package com.example.atividadeformulariodealunos


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val alunoList = mutableListOf<Alunos>()
    //private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Busca as variáveis de acordo com o ID setado em tela.

        val txtAluno= findViewById<EditText>(R.id.txtNome);
        val txtArea = findViewById<EditText>(R.id.txtArea);
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        //val btnRemover = findViewById<Button>(R.id.btnRemover)
        val listViewTAlunos= findViewById<ListView>(R.id.listViewAlunos)


        // Criando uma porte e usando o Layout do Android
        //adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDeTarefas)


        val adapter = AlunosAdapter (this,alunoList)


        // Vinculando o meu adapter com a minha view
       listViewTAlunos.adapter = adapter

        btnInserir.setOnClickListener{

            val nomeAluno = txtAluno.text.toString()
            val areaEscolhida = txtArea.text.toString()
            val dataAtual = SimpleDateFormat("dd/MM", Locale.getDefault()).format(Date())

            if(nomeAluno.isNotEmpty()){

                val novoAluno = Alunos (nomeAluno, areaEscolhida, dataAtual )

                alunoList.add(novoAluno)
                adapter.notifyDataSetChanged()

                Toast.makeText(this, "Aluno ${nomeAluno} ", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "Área Escolhida ${areaEscolhida}", Toast.LENGTH_LONG).show()

                txtAluno.text.clear()
                txtArea.text.clear()
            }
        }

        listViewTAlunos.setOnItemLongClickListener{ _,_, position, _ ->
            val removeAluno = alunoList.removeAt(position)
            adapter.notifyDataSetChanged()

            Toast.makeText(this, "Aluno Removido", Toast.LENGTH_LONG).show()
            true
        }
    }
}