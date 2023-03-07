
import scala.collection.mutable
class Graph[v] {
  
  var vertices : List[v]= List()
  var edges : mutable.Map[v, List[v]]= mutable.Map()
  
  
  def addvertex(value : v): v =
  {
    vertices= value :: vertices
    edges += (value ->List())
    value
  }
  
  def addEdge(v1 : v, v2 : v): Unit ={
    edges(v1) = v2 :: edges(v1)
    edges(v2) = v1 :: edges(v2)
  }
  
  
  
  def bfs(src : v, dst :v): Unit = {
  val toVisited : mutable.Queue[v] = mutable.Queue()
  val visited : mutable.Set[v] =mutable.Set()
  
  toVisited.enqueue(src)
  visited +=src
  while(toVisited.nonEmpty)
  {
    val v0= toVisited.dequeue()
    println("BFS : "+ v0)
    
    for(v <- edges(v0) )
    {
      if(! visited.contains(v))
      {
        toVisited.enqueue(v)
        visited+=v
      }
    }
  }
  }
  
  
  def print(): Unit ={
    
    println("======Vertices=====")
    for(v<- vertices)
    {
      println(v.toString())
    }
    
    println("======Edges=====")
     for(e<- edges)
    {
      println(e.toString())
    }
    
    println("======Done=====")
  }
  
  
}
