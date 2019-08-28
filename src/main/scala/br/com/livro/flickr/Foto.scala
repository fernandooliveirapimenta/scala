package br.com.livro.flickr

class Foto(val id: Long,
           val owner: String,
           val title: String,
           val farm: Int) {


  override def toString = s"Foto($id, $owner, $title, $farm)"
}

object Foto {
  def unapply(foto: Foto):
  Option[(Long, String, String, Int)] =
    Some((foto.id, foto.owner, foto.title, foto.farm))

  def apply( id: Long ,
   owner: String,
   title: String,
   farm: Int ): Foto = new Foto(id,owner,title,farm)
}
