package br.bruno.whatsapp.data

import br.bruno.whatsapp.data.Pessoa

class PessoaBuilder {

    var listaDePessoas = mutableListOf<Pessoa>()

    fun add(nome : String, foto : Int, msg: String){
        var pessoa = Pessoa(nome,foto,msg)
        listaDePessoas.add(pessoa)
    }
}