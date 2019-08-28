package br.com.livro.flickr

import java.util.Properties

import br.com.livro.flickr.ClassesAbstratasETraita.MediaSealed

object ClientFlickrAnotacoes extends App{

  val FOTOS = 1
  val VIDEOS = 2
  val TODAS = 3

  val media = FOTOS

  media match {
    case FOTOS => println("fotos")
    case VIDEOS => println("videos")
    case _ => println("TODOS")
  }

  val props = new Properties
  props.load(getClass.getClassLoader
    .getResourceAsStream("config.properties"))

  val apiKey = props.getProperty("flickr.api.key")

  val secret = "caa7d6fda9fd3997"
  val method = "flickr.photos.search"
  val tags = "scala"

  val url
  = s"https://api.flickr.com/services/rest/" +
    s"?method=$method&api_key=$apiKey&tags=$tags"

  scala.io.Source.fromURL(url).getLines().foreach(println)

  private val caller = new FlickrCaller(apiKey)

//  println(caller.api)
//  println(caller.buscaFotos("scala"))
//  println(caller.buscaFotos(userId = "userId"))

//  val fotos = MediaCase("fotos")
//  val videos = MediaCase("videos")
//  val all = MediaCase("all")
//
//  println(fotos == videos)
//  println(videos)
//
//  val copia = fotos.copy(value = "videos")
}

//class FlickrCaller(val api: String) {
//
//  def buscaFotos(tag: String = "",
//                 userId: String = ""): Seq[Foto] = ???
//
//}

case class MediaCase(value: String)

case object MediaCaseObject {

}


//abstract class Media(val value: String)
//object Fotos extends Media("fotos")
//object Videos extends Media("videos")
//object Todas extends Media("all")

object PatternMatching extends App{

  val midia = 1

  val texto = midia match {
    case 1 => "fotos"
    case 2 => "videos"
    case _  => "todos"
  }

  val resultado = midia match {
    case 1 => "fotos"
    case 2 => "videos"
    case _ => -1
  }


  println(texto)
  println(resultado)

  val foto = Foto(33, "jcranky", "oi", 3);
  val foto2 = Foto(33, "jcranky", "oi", 3);
  val foto3 = Foto(33, "jcranky", "oi", 3);

  val fotos = List(foto,foto2,foto3)

  println(fotos(1))
  println(fotos.apply(0))

  val teste = foto match {
    case  Foto(_, "jcranky", _, _ ) => true
    case _ => false
  }

  val teste2 = foto match {
    case  Foto(_, "jcranky", _, _ ) if 7 == 7 => true
    case _ => false
  }
 println(teste)

//  foto.copy(owner = "vic") match {
//    case Foto(_, "jcranky", _, _) => println("foto jcranky")
//    case f => println(s"outra: $f")
//  }

  val dobro: Int = new IntDobrado(10).dobrado
  println(dobro)
}

object ApiScala extends App{

  //Option, some, none

}

class IntDobrado(val x: Int) extends AnyVal {
  def dobrado: Int = x * 2
}

object Colecoes extends App {

  val listFoto: List[Foto] = List[Foto](new Foto(33, "f", "gdg", 3 ))

  def imprimeFoto(f: Foto): String = {
    s"${f.id}"
  }

  listFoto.foreach(f => println(imprimeFoto(f)))

  val sets = Set[String]("2","2","Fernando","Pimenta")

  val novoSets = sets + "Fer"
  println(sets)

  sets.foreach(println)
  novoSets.foreach(print)

  novoSets - "fer" foreach println

  val listJeitoFeio = "a" :: "b" :: "c" :: Nil
  val listNovoJeito: List[String] = "c" :: "a" :: Nil

  println()
  println()
  println()

//  listNovoJeito :+ "fefe" foreach println
   listNovoJeito +: "fefe"

  val strings: List[String] = List("Fernando", "Bruna", "tkdsjf", "b")

  def varrer(): Unit = strings match {
//      head :: tail
    case a :: b => println(a)
  }

  def varrer2 = strings match {
    case head  :: Nil => println(head)
    case _ =>
  }

  println(varrer())
  println(varrer2)

  def printaLista(list: List[String]): Unit = {
    list match {

      case head :: Nil => println(head)

      case head :: tail =>
        println(head)
        printaLista(tail)

      case Nil =>
    }
  }

  println()
  println()
  println()

  printaLista(strings)
}

object Tuplas extends App {

  val dadosFotos: (String, String) = ("Fefe","scala")

  val (nome, linguagem) = dadosFotos

  println(s"${dadosFotos._1} - ${dadosFotos._2}")
  println(s"$nome - $linguagem")

  def comMatch(): Unit = dadosFotos match {
    case (nome: String, linguagem: String) => println(s"$nome, $linguagem")
  }

  println(comMatch())
}

object Mapas extends App {


  val services = Map[String, String](
    ("busca", "flickr.photos.search"),
    ("tamanhos", "flickr.photos.getSizes")
  )

  services.foreach(println)

  val mapaMelhot = Map(
    "chave" -> "valor",
    "fefe" -> "nando"
  )

  mapaMelhot.foreach(println)

  println(services("busca"))

  println(services.getOrElse("dskjfs", "dgd"))


  val novoMap = services + ("Ruby" -> "Rails")
  println(novoMap)

  val removerMap = novoMap - "busca"
  println(removerMap)

  val atualizaMap = novoMap.updated("busca", "novo")
  println(atualizaMap)

}

object Arrays extends App {

  val array = Array("a","b","c")

  println(array(1))
}

