package br.com.basico

object App{

  def main(args: Array[String]): Unit = {

    println("Hello world!")

    val a = new Animal()
    val b = new Animal("vaca")

    println(a.getNome)
    println(b.getNome)


  }

  class Animal(nome: String = "cachorro") {

    def getNome: String ={
      this.nome
    }

  }


}
