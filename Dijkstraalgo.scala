
import scala.collection.mutable

object Dijkstraalgo {
  def main(args: Array[String]): Unit = {
    // Define the graph as an adjacency list
    val graph = Map(
      1 -> Map(2 -> 7, 3 -> 9, 6 -> 14),
      2 -> Map(1 -> 7, 3 -> 10, 4 -> 15),
      3 -> Map(1 -> 9, 2 -> 10, 4 -> 11, 6 -> 2),
      4 -> Map(2 -> 15, 3 -> 11, 5 -> 6),
      5 -> Map(4 -> 6, 6 -> 9),
      6 -> Map(1 -> 14, 3 -> 2, 5 -> 9)
    )

    // Run Dijkstra's algorithm starting from vertex 1
    val distances = dijkstra(graph, 1)

    // Print the shortest distances to all vertices
    for ((vertex, distance) <- distances) {
      println(s"Shortest distance from 1 to $vertex is $distance")
    }
  }

  def dijkstra(graph: Map[Int, Map[Int, Int]], start: Int): Map[Int, Int] = {
    // Initialize the distances and visited sets
    val distances = mutable.Map[Int, Int]().withDefaultValue(Int.MaxValue)
    distances(start) = 0
    val visited = mutable.Set[Int]()

    // Loop until all vertices are visited
    while (visited.size < graph.size) {
      // Find the unvisited vertex with the smallest distance
      val (current, distance) = distances.filterKeys(!visited.contains(_)).minBy(_._2)

      // Update the distances of its neighbors
      for ((neighbor, weight) <- graph(current) if !visited.contains(neighbor)) {
        val totalDistance = distance + weight
        if (totalDistance < distances(neighbor)) {
          distances(neighbor) = totalDistance
        }
      }

      // Mark the current vertex as visited
      visited += current
    }

    distances.toMap
  }
}
