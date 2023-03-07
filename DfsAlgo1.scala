

object DfsAlgo1 {
  import scala.collection.mutable.Stack

def dfsIterative(graph: Map[Int, List[Int]], start: Int): List[Int] = {
  var visited = Set[Int]()
  var stack = Stack[Int]()
  var result = List[Int]()

  stack.push(start)

  while (stack.nonEmpty) {
    val current = stack.pop()

    if (!visited.contains(current)) {
      visited += current
      result = current :: result

      for (neighbor <- graph(current)) {
        if (!visited.contains(neighbor)) {
          stack.push(neighbor)
        }
      }
    }
  }

  result.reverse
}
def main(args: Array[String]): Unit = {
  

val graph = Map(
  0 -> List(1,2,3),
  1 -> List(0,3,4),
  2 -> List(0,3),
  3 -> List(0,1,2,4),
  4 -> List(1,3)
)

val dfsResult = dfsIterative(graph, 0)
println(dfsResult)
}

}
