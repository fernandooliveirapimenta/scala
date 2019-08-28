package br.com.livro.flickr

import br.com.livro.flickr.ClassesAbstratasETraita.MediaSealed
import br.com.livro.flickr.tipagemAvancada.FotoTA

object ProgramacaoFuncional extends App{

  def te: String = "ola"

  def ola(fun:  => String): String = fun

  println(ola(te))

  val sets = Set("a","b","c")

  sets.filter(s => s.length > 1)
  sets.filter(_.length > 1)

  def filt(a: String) = a == "a"
  println(sets.filter(s => s == "a"))
  println(sets.filter(filt))


  def fotosDoJCranky(f: Foto) = f.owner == "jcranky"
  val p: Foto => Boolean = fotosDoJCranky

  //poderiia usar funcao ou val


  val list = List("a")
  list.sortWith((x, y) => y > x)


  def cres(x: Int, y: Int): Boolean = x < y
  val numbers = List(2,4,1,3)

  println(numbers.sortWith((x,y) => x < y))
  println(numbers.sortWith(cres))
  println(numbers sortWith cres)

}

object ex1 extends App {

  val desordenada = List("b", "z", "a", "a", "c")

  def ordenarFun(x: String, y: String): Boolean = x < y
//  val ordenarProperty: Boolean => (String, String) = ???
  val ordenarProperty = (x: String, y: String) => x > y
  println(desordenada.sortWith((pstr, ustr) => pstr < ustr))
  println(desordenada.sortWith(ordenarProperty))
  println(desordenada sortWith ordenarFun)

  println(desordenada.find(_ == "a"))
  println(desordenada.find(p => p == "d"))
  println(desordenada.filter(_ == "a"))

  val fotos = List(Foto(3, "fefe", "f", 3),
    Foto(3, "bruna", "f", 3)
  )


  def reusavel(x: String, alvo: Foto) = alvo.owner == x


  println(fotos.filter(reusavel("fefe", _)))

  def geraLi(f: Foto): scala.xml.Elem = <li>{f.title}</li>
  val li = fotos.map(f => <li>{f.title}</li>)
  println(li)
  println(fotos.map(geraLi))

  val tags: Option[List[String]] = Some(List("dog", "car"))

  println(tags.map(t => t.mkString(",")))

  println(tags.getOrElse(Nil).flatMap(t => s"&tags=$t"))

  val tags2 = List("scala","java","typesafe")

  def buscaFotos(tag: Option[String]): List[String] = {
    println(tag.map("&tags=" + _).getOrElse(""))

    List(tag.get)
  }

  println()
  println()
  println()
  val t = tags2.flatMap(tag => buscaFotos(Some(tag)))
  println(t)
}


object ReduceFold extends App {
  val numeros = List(1,2,3,4,5)

  def funSum(ac: Int, x: Int) = ac + x

  val soma = numeros.reduce(funSum)
  val somaLef = numeros.reduceLeft(funSum)
  val somaRight = numeros.reduceRight(funSum)
  val somaFacil = numeros.sum
  println(soma)
  println(somaLef)
  println(somaRight)
  println(somaFacil)

  val fotos = List(
    Foto(3, "fefe", "d", 3),
      Foto(3, "bruna", "d", 3),
      Foto(3, "ana", "d", 3)
  )

 val tags:  Option[List[String]] = Some(List("scala","java","python"))

  val prices = List(1.5, 2.0, 2.5)

  println(prices.foldLeft(0.0)( (variavel, principal) => variavel + principal))
  println(prices.foldLeft(0.0)( _ + _))

  println()
  println()
  println()
  val donuts: Seq[String] = Seq("Plain","Strawberry","Glazed")
  println(s"Elements of donuts1 = $donuts")

  val foldE = donuts.fold("")(_ + _ + " Donut ")
  println(foldE)

}


object tipagemAvancada extends App {

  val f1 = Foto(3, "fefe", "d", 3)
  val f2 = Foto(3, "bruna", "d", 3)
  val f3 = Foto(3, "ana", "d", 3)

  val fotos: Set[Foto] = Set(f1,f2,f3)
  println(fotos)

  val fotos2 = Set(f1,f2,f3, "Strring")
  println(fotos2)

  val listaVazia = List.empty

  val listaStringVazia = List.empty[String]

  println()
  println()
  println()

  trait Media {
    val tags: Set[String]
  }

  case class FotoTA(id: Int, tags: Set[String]) extends Media
  case class VideoTA(id: Int, tags: Set[String]) extends Media

  val fotosN = Set(FotoTA(1, Set("scala","jcranky")),
    FotoTA(2, Set("jvm","jcranky")))


  val videosN = Set(VideoTA(1, Set("praia","ipanema")),
    VideoTA(2, Set("campo","ferias")))


  def acumulaTags(media: Media, outraMedia: Media): Media =
    new Media {
      val tags: Set[String] = media.tags ++ outraMedia.tags
    }


  val tagsFotos = fotosN.reduceLeft(acumulaTags)
  println(tagsFotos)
  val tagsVideos = videosN.reduceLeft(acumulaTags)
  println(tagsVideos)

  def printaFotos(medias: Set[Media]): Unit = medias foreach println
  def printaFotos2[T <: Media](medias: Set[T]): Unit
  = medias.foreach(println)

  val setDeFotos: Set[FotoTA] = Set(FotoTA(1,Set.empty))

//  printaFotos(setDeFotos)
  printaFotos2(setDeFotos)

  def printaFotosNovo(fotos: Set[FotoTA]): Unit = fotos.foreach(println)


  printaFotosNovo(setDeFotos)

  class FotoDetalhada(dono: String, id: Int, tags: Set[String])
    extends FotoTA(id, tags)

  val fotosDet = Set(new FotoDetalhada("fefe", 33, Set.empty))

//  printaFotosNovo(fotosDet)

  val fotosListaNova : List[FotoTA] = List(FotoTA(1, Set.empty))
  val fotosDetLista = List(new FotoDetalhada("fefe", 33, Set.empty))

  def printaFotosNovoList(fotos: List[FotoTA]): Unit = fotos.foreach(println)
  printaFotosNovoList(fotosListaNova)
  printaFotosNovoList(fotosDetLista)

  val printaFoto: FotoTA => Unit = println

  val printaFotoDetalhada: FotoDetalhada
    => Unit = (foto: FotoTA) => println(foto)

//  val printaFotoTipado: FotoTA => Unit =
//    (foto: FotoDetalhada) => println(foto)

}

object ForComprehensions extends App {

  val tags = Set("scala", "java", "jvm")

  def buscarFotos(tag: String): Set[String]
  = Set("scala","devdojo")


  tags.foreach {
    tag =>
      val fotos = buscarFotos(tag)
      fotos foreach println
  }

  println()
  println()
  println()

  for {
    tag <- tags
    foto <- buscarFotos(tag)
  } println(foto)


  val fotos = tags.flatMap(tag => buscarFotos(tag))
  fotos foreach println

  println()
  println()
  println()

  val fotosAcucar = for {
    tag <- tags
    foto <- buscarFotos(tag)
  } yield foto


  fotosAcucar foreach println

  println()
  println()
  println()

  val nomesFiltrados = tags.filter(_.startsWith("j"))
    .flatMap(tag => buscarFotos(tag))

  nomesFiltrados foreach println


  println()
  println()
  println()

  val nomesFiltradosFor = for {
    tag <- tags if tag.startsWith("j")
    foto <- buscarFotos(tag)
  } yield foto

  nomesFiltradosFor foreach println


  println()
  println()
  println()

  val tagsOptional: Option[Set[String]] =
    Some(Set("java","scala","javascript","dart","kotlin","C#"))

  val tagText: String = tagsOptional.map(t => "&tags=" + t).getOrElse("")

  println(tagText)

  val tagsSemOptional: Set[String] =
    Set("java","scala","javascript","dart","kotlin","C#")

  val semOpt = tagsSemOptional.map(t => "&tags=" + t)
  println(semOpt)

  println()
  println()

  val tagText2 = for {
    t <- tagsOptional
  } yield "&tags=" + t

  println(tagText2)

  println()
  println()
  println()

  val userOpt = Option("fefe")
  val passOpt = Option("123")

  def autenticar(u: String, p: String): Option[String] =
    if(u == "fefe" && p == "123") Some("token")
    else None

  val tokenOpt: Option[String] = for {
    user <- userOpt
    pass <- passOpt
    token <- autenticar(user, pass)
  } yield token




}

object ClassesAbstratasETraita extends App {

//  abstract class ResponsParser {
//    def parse(str: String): Set[FotoTA]
//  }



  trait Logger {
    def log(msg: String): Unit = println(msg)
  }

  trait ResponsParser {
    def parse(str: String): Set[FotoTA]
  }

  abstract class XMLParser extends ResponsParser with Logger {
    override def parse(str: String): Set[FotoTA] = ???
  }

  class JsonParser extends ResponsParser with Logger with Ordered[JsonParser]{
    override def parse(str: String): Set[FotoTA] = ???

    override def compare(that: JsonParser): Int = ???
  }

  trait ConsoleLogger extends Logger {

    override def log(msg: String): Unit
    = println(msg)

  }

  val parser = new JsonParser with ConsoleLogger

  sealed abstract class MediaSealed(val value: String)
  object FotosS extends MediaSealed("fotos")
  object VideosS extends MediaSealed("videos")
  object TodasS extends MediaSealed("all")


  trait LogBase {
    def log(msg: String): Unit
  }

  trait LogArquivo extends LogBase {
   abstract override def log(msg: String): Unit
    = {
      super.log(msg)
      println(s"logando $msg no arquivo")
    }
  }

  trait LogConsole extends LogBase{
   abstract override def log(msg: String): Unit = {
      super.log(msg)
      println(s"logando $msg no console")
    }
  }

  class EmptyLogger extends LogBase {
    override def log(msg: String): Unit = {}
  }

  println()
  println()
  println()
  new EmptyLogger with LogArquivo {}.log("olá trait")

  println()
  println()
  println()

  val logger = new EmptyLogger with LogArquivo with LogConsole

  logger.log("importante!")


  println()
  println()
  println()

  val logger2 = new EmptyLogger with LogConsole with LogArquivo

  logger.log("importante!")
}


