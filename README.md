# XenonStack-Module-D3

## Graph Data Structure in Scala

This is a Scala implementation of a graph data structure using an adjacency list representation. The implementation supports adding vertices and undirected edges between vertices, and performing a breadth-first search to find a path between two vertices.



### For creating Graph 

1. We create a class "Graph.scala" and where we create some method to create vertices and edge.
2. We create a Scala Object "TeasMain.Scala " in this  object we create our Graph instance and add edges and also call the methods of our Graph class.\n
       * For add vertex you just write following code in "TestMain.scala" File :-
              val g: Graph[String] = new Graph  // this will create a graph 
              g.addvertex(value="A") // this code add a vertex in our graph
              g.addvertex(value="B") 
       * For adding an edge you just write following code in "TestMain.scala" file :-  
              g.addEdge(A, B) // this code add an edge A to B    
4. In the Graph class there is a Method "Print"  Through this method we print all the vetices and and all the connected edges.
5. Another method is define in the Graph class is "BFS", Its used for treverse all the vertex by passing a source and destination value.

### DFS (Depth First search) 


