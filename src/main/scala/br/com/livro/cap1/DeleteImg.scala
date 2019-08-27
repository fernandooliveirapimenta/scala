package br.com.livro.cap1

import java.io.File

object DeleteImg extends App{

  val arquivos = new File(".").listFiles
  val extensoesImgs = List(".jpg", ".jpeg", ".gif", ".png")

  def ehImagem(nomeArq: String)
  = extensoesImgs.exists(nomeArq.endsWith)

  arquivos.filter(arq => ehImagem(arq.getName))
    .foreach(_.delete())
//  arquivos.filter(arq => ehImagem(arq.getName))
//    .foreach((f: File) => f.delete)

}
