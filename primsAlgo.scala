import scala.collection.mutable
import scala.util.control.Breaks._
object primsAlgo {
// Define a class to represent an edge in the graph
case class Edge(to: Int, weight: Int)

// Define a class to represent a vertex in the graph
case class Vertex(id: Int, var key: Int, var parent: Option[Int], var visited: Boolean)

def prim(graph: Array[Array[Edge]], start: Int): Unit = {
  // Create an array to store the vertices of the graph
  val vertices = Array.tabulate(graph.length)(i => Vertex(i, Int.MaxValue, None, visited = false))
  // Set the key of the start vertex to 0
  vertices(start).key = 0

  // Create a priority queue to store the vertices in the order of their keys
  val queue = mutable.PriorityQueue.empty[(Int, Int)](Ordering.by(-_._2))
  // Add the start vertex to the queue
  queue.enqueue((start, 0))

  while (queue.nonEmpty) {
    // Get the vertex with the lowest key
    val (vertexId, _) = queue.dequeue()

    // Mark the vertex as visited
    vertices(vertexId).visited = true

    // Update the keys of the neighboring vertices
    for (edge <- graph(vertexId)) {
      val neighborId = edge.to
      val neighbor = vertices(neighborId)
      if (!neighbor.visited && edge.weight < neighbor.key) {
        neighbor.key = edge.weight
        neighbor.parent = Some(vertexId)
        queue.enqueue((neighborId, neighbor.key))
      }
    }
  }

  // Print the minimum spanning tree
  println("Minimum Spanning Tree:")
  for (vertex <- vertices if vertex.parent.isDefined) {
    val parentId = vertex.parent.get
    println(s"$parentId -> ${vertex.id} (weight = ${vertex.key})")
  }
}
def main(args: Array[String]): Unit = {
  

// Example usage
val graph = Array(
  Array(Edge(1, 2), Edge(2, 1), Edge(3, 3)),
  Array(Edge(0, 2), Edge(2, 4)),
  Array(Edge(0, 1), Edge(1, 4), Edge(3, 5)),
  Array(Edge(0, 3), Edge(2, 5))
)

prim(graph, 2)

}
}
