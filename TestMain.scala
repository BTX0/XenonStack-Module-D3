
object TestMain {
  def main(args: Array[String]): Unit = {
  
    val g: Graph[String] = new Graph
    
    val gkp = g.addvertex(value="Gorakhpur")
    val gol = g.addvertex(value="Gola")
    val kush = g.addvertex(value="Kushinagar")
    val deo = g.addvertex(value="Deoria")
    val hata = g.addvertex(value="Hata")
    
    g.addEdge(gkp, gol)
    g.addEdge(gkp, kush)
    g.addEdge(kush, gol)
    g.addEdge(gol, deo)
    g.addEdge(kush, deo)
    g.addEdge(deo, hata)
    
    g.bfs(gkp, deo)
    //g.print()
  }
}
