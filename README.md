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
                  **val graph = Map(
              0 -> List(1,2,3),
              1 -> List(0,3,4),
              2 -> List(0,3),
              3 -> List(0,1,2,4),
              4 -> List(1,3)
            )** <br>

2. Call the dfsIterative method and pass in the graph and the starting vertex as arguments. This method will return a list of integers representing the order in which the vertices were visited during the Depth-First Search traversal. <br> 
               **val dfsResult = dfsIterative(graph, 0)** <br>
               
3. Print the result of the Depth-First Search traversal. <br>
            **println(dfsResult)** 
            
            
## Dijkstra's Algorithm Implementation
<br>


            





