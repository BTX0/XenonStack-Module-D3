# XenonStack-Module-D3

## Graph Data Structure in Scala

This is a Scala implementation of a graph data structure using an adjacency list representation. The implementation supports adding vertices and undirected edges between vertices, and performing a breadth-first search to find a path between two vertices.



### For creating Graph 

1. We create a class **"Graph.scala"** and where we create some method to create vertices and edge.
2. We create a Scala Object **"TeasMain.Scala "** in this  object we create our Graph instance and add edges and also call the methods of our Graph class.<br>
       * For add vertex you just write following code in **"TestMain.scala"** File :- <br> <br>
              **val g: Graph[String] = new Graph**  // this will create a graph <br>
              **g.addvertex(value="A")** // this code add a vertex in our graph <br>
              **g.addvertex(value="B")**  <br><br>
       * For adding an edge you just write following code in **"TestMain.scala"** file :-  <br><br>
              **g.addEdge(A, B)** // this code add an edge A to B    <br><br>
4. In the Graph class there is a Method "Print"  Through this method we print all the vetices and and all the connected edges.
5. Another method is define in the Graph class is "BFS", Its used for treverse all the vertex by passing a source and destination value.

## DFS (Depth First search) 
<br>
This is a Scala implementation of the Depth-First Search algorithm using an iterative approach. The implementation uses a stack data structure to keep track of vertices and their neighbors in the graph. <br><br>

In the **"DfsAlgo1.scala"** file we write function to Visit all the vertex from the given source our Method Takes 2 Value as a arguement First one is Graph And second is the Source Vertex. it will return a list of all the connected Vertex. <br> <br>

### Usage
<br>
To use this implementation of the Depth-First Search algorithm, follow these steps: <br>
1. Create a graph represented as a Map where the keys are integers representing the vertices and the values are lists of integers representing the neighboring vertices.<br>
              val graph = Map( <br>
              0 -> List(1,2,3), <br>
              1 -> List(0,3,4), <br>
              2 -> List(0,3), <br>
              3 -> List(0,1,2,4),<br>
              4 -> List(1,3) <br>
            )<br>

2. Call the dfsIterative method and pass in the graph and the starting vertex as arguments. This method will return a list of integers representing the order in which the vertices were visited during the Depth-First Search traversal. <br> 
               **val dfsResult = dfsIterative(graph, 0)** <br>
               
3. Print the result of the Depth-First Search traversal. <br>
            **println(dfsResult)** 
            
            
## Dijkstra's Algorithm in Scala
<br>
This is an implementation of Dijkstra's Algorithm in Scala, which is used to find the shortest path between nodes in a graph. The algorithm takes a graph represented as an adjacency list and a starting vertex as input, and outputs the shortest distances from the starting vertex to all other vertices in the graph. <br> <br>
### Functionality
<br>
The dijkstra method takes two arguments: the graph and the starting vertex. It returns a map of shortest distances from the starting vertex to all other vertices in the graph. <br>

The algorithm works by maintaining two sets: the visited set and the unvisited set. Initially, all vertices are unvisited and the distance to all vertices is set to infinity except for the starting vertex, which is set to 0. The algorithm repeatedly selects the unvisited vertex with the smallest distance and updates the distances of its neighbors. Once all vertices have been visited, the algorithm terminates and returns the map of shortest distances.<br> <br>


### Dependencies
<br>
This code uses the ***scala.collection.mutable*** package to implement mutable data structures like Map and Set. No additional dependencies are required.
<br>
<br>

### Usage
<br>

1. To use this implementation, simply define your graph as an adjacency list in the format of a **Map[Int, Map[Int, Int]]**, where the keys of the outer map are the vertices of the graph, and the values are inner maps that represent the edges emanating from each vertex. The keys of the inner maps are the vertices that the edge connects to, and the values are the weights of the edges <br>

2. Once you have defined your graph, call the **dijkstra** function with the graph and the starting vertex as arguments to get a **Map[Int, Int]** that represents the shortest distances from the starting vertex to all other vertices in the graph.<br>

            val graph = Map( <br>
              1 -> Map(2 -> 7, 3 -> 9, 6 -> 14),<br>
              2 -> Map(1 -> 7, 3 -> 10, 4 -> 15),<br>
              3 -> Map(1 -> 9, 2 -> 10, 4 -> 11, 6 -> 2),<br>
              4 -> Map(2 -> 15, 3 -> 11, 5 -> 6),<br>
              5 -> Map(4 -> 6, 6 -> 9),<br>
              6 -> Map(1 -> 14, 3 -> 2, 5 -> 9)<br>
            )<br>

            val distances = dijkstra(graph, 1)<br><br>
           
3. The resulting **Map** can be used to determine the shortest distance from the starting vertex to any other vertex in the graph.           






            





