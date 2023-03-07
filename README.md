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

              val graph = Map( 
              0 -> List(1,2,3), 
              1 -> List(0,3,4), 
              2 -> List(0,3), 
              3 -> List(0,1,2,4),
              4 -> List(1,3) 
            )

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
This code uses the **scala.collection.mutable** package to implement mutable data structures like Map and Set. No additional dependencies are required.
<br>
<br>

### Usage
<br>

1. To use this implementation, simply define your graph as an adjacency list in the format of a **Map[Int, Map[Int, Int]]**, where the keys of the outer map are the vertices of the graph, and the values are inner maps that represent the edges emanating from each vertex. The keys of the inner maps are the vertices that the edge connects to, and the values are the weights of the edges <br>

2. Once you have defined your graph, call the **dijkstra** function with the graph and the starting vertex as arguments to get a **Map[Int, Int]** that represents the shortest distances from the starting vertex to all other vertices in the graph.<br>

            val graph = Map( 
              1 -> Map(2 -> 7, 3 -> 9, 6 -> 14),
              2 -> Map(1 -> 7, 3 -> 10, 4 -> 15),
              3 -> Map(1 -> 9, 2 -> 10, 4 -> 11, 6 -> 2),
              4 -> Map(2 -> 15, 3 -> 11, 5 -> 6),
              5 -> Map(4 -> 6, 6 -> 9),
              6 -> Map(1 -> 14, 3 -> 2, 5 -> 9)
            )

            val distances = dijkstra(graph, 1)

<br>

3. The resulting **Map** can be used to determine the shortest distance from the starting vertex to any other vertex in the graph.
<br>
<br>

## Kruskal's Algorithm in Scala
<br>

This program implements Kruskal's algorithm in Scala, a greedy algorithm that finds a minimum spanning tree for a weighted, connected graph.<br>
<br>

### Input
<br>
The input to the program is an edge list with weights, defined as a list of tuples **(u, v, w)**, where **u** and **v** are the endpoints of an edge and **w** is its weight.<br>

            
                        val edges = List(
                          (1, 2, 7), (1, 3, 9), (1, 6, 14),
                          (2, 3, 10), (2, 4, 15),
                          (3, 4, 11), (3, 6, 2),
                          (4, 5, 6),
                          (5, 6, 9)
                        )
                        
                        
 ### Output
 <br>
 
 The program outputs the edges in the minimum spanning tree, which is stored as a list of tuples **(u, v)**.
 <br>
 
 
                        println("Minimum spanning tree:")
                        for ((u, v) <- mst) {
                          println(s"$u -- $v")
                        }
                        
                        
### Code Explanation     
<br>

The code starts by defining the **kruskal** function, which takes the list of edges as input and returns a list of edges in the minimum spanning tree. <br>

The function starts by initializing the disjoint-set data structure using a mutable map **parents**, which maps each vertex to its parent in the set. The **find** function recursively finds the parent of a vertex and performs path compression, while the **union** function joins two sets by setting the parent of one vertex to the parent of the other.<br> <br>


                        val parents = mutable.Map[Int, Int]()
                        def find(x: Int): Int = parents.getOrElseUpdate(x, x) match {
                          case y if y == x => x
                          case y => find(y)
                        }
                        def union(x: Int, y: Int): Unit = parents(find(x)) = find(y)
                        
                        
The edges are sorted by weight using the sortBy function.


                        val sortedEdges = edges.sortBy(_._3)


The minimum spanning tree is found by iterating over the sorted edges and adding them to the tree if they connect two disjoint sets.<br>


                        val mst = mutable.ListBuffer[(Int, Int)]()
                        for ((u, v, w) <- sortedEdges) {
                          if (find(u) != find(v)) {
                            union(u, v)
                            mst += ((u, v))
                          }
                        }


Finally, the function returns the minimum spanning tree as a list.<br>


                        mst.toList


The main function of the program defines the input graph, calls the kruskal function to find the minimum spanning tree, and prints the edges in the tree.<br>



 








            





