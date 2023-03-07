
import scala.collection.mutable

object kruskalalgo {
  def main(args: Array[String]): Unit = {
    // Define the graph as an edge list with weights
    val edges = List(
      (1, 2, 7), (1, 3, 9), (1, 6, 14),
      (2, 3, 10), (2, 4, 15),
      (3, 4, 11), (3, 6, 2),
      (4, 5, 6),
      (5, 6, 9)
    )

    // Find the minimum spanning tree of the graph
    val mst = kruskal(edges)

    // Print the edges in the minimum spanning tree
    println("Minimum spanning tree:")
    for ((u, v) <- mst) {
      println(s"$u -- $v")
    }
  }

  def kruskal(edges: List[(Int, Int, Int)]): List[(Int, Int)] = {
    // Initialize the disjoint-set data structure
    val parents = mutable.Map[Int, Int]()
    def find(x: Int): Int = parents.getOrElseUpdate(x, x) match {
      case y if y == x => x
      case y => find(y)
    }
    def union(x: Int, y: Int): Unit = parents(find(x)) = find(y)

    // Sort the edges by weight
    val sortedEdges = edges.sortBy(_._3)

    // Find the minimum spanning tree using Kruskal's algorithm
    val mst = mutable.ListBuffer[(Int, Int)]()
    for ((u, v, w) <- sortedEdges) {
      if (find(u) != find(v)) {
        union(u, v)
        mst += ((u, v))
      }
    }

    mst.toList
  }
}
