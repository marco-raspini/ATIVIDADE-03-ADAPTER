package com.example.atividadeformulariodealunos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class AlunosAdapter (

    private val context: Context,
    private val listaAlunos : MutableList<Alunos>) : ArrayAdapter<Alunos>(context, 0, listaAlunos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // Pega a tareda atual do "FOR"
        val alunosList = listaAlunos.get(position)

        // Aponta qual layout será utulizado
        val view = LayoutInflater.from(context).inflate(R.layout.aluno_cadastro, parent, false)

        // Pega os campos do layout escolhido
        val nome = view.findViewById<TextView>(R.id.txtNome)
        val area = view.findViewById<TextView>(R.id.txtArea)
        val data = view.findViewById<TextView>(R.id.txtData)

        // Joga o valor da tarefa para o campo da tela
        nome.text = alunosList.nome
        area.text = alunosList.area
        data.text = alunosList.data

        return view
    }
}

