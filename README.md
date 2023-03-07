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


## Prim's Algorithm in Scala

This code implements Prim's algorithm for finding the minimum spanning tree of a connected, undirected graph with weighted edges. The algorithm works by starting at an arbitrary vertex and greedily adding the closest vertex to the tree until all vertices have been added.<br>

### Code Explanation

The code defines two classes, **Edge** and **Vertex**, to represent the edges and vertices of the graph. The **Edge** class has two fields, **to** and **weight**, which represent the vertex to which the edge connects and the weight of the edge, respectively. The **Vertex** class has four fields, **id**, **key**, **parent**, and **visited**, which represent the unique identifier of the vertex, the minimum key value for the vertex, the parent of the vertex in the minimum spanning tree, and whether or not the vertex has been visited, respectively. <br>

The **prim** function takes two arguments, **graph** and **start**, which represent the graph as an array of arrays of **Edge** objects and the starting vertex, respectively. The function first creates an array of **Vertex** objects to represent the vertices of the graph and initializes their key values to infinity, except for the key value of the starting vertex, which is set to 0. The function then creates a priority queue to store the vertices in the order of their key values and adds the starting vertex to the queue.<br>

The function then enters a loop that continues until the priority queue is empty. In each iteration of the loop, the function removes the vertex with the lowest key value from the queue, marks it as visited, and updates the key values of its neighboring vertices if they have not been visited and the weight of the edge between the vertices is less than the neighbor's current key value. The function then adds the neighboring vertices to the priority queue if they have been updated.<br>

After the loop, the function prints the minimum spanning tree by iterating over the vertices and printing the parent-child relationships for each vertex that has a parent.<br>

The **main** function provides an example usage of the **prim** function by defining a sample graph as an array of arrays of **Edge** objects and calling the **prim** function with the graph and a starting vertex.<br>


### Usage 

To use this implementation, simply call the **prim** function with two arguments: the graph represented as an adjacency list of edges, and the starting vertex. For example, to find the minimum spanning tree of a graph with four vertices: <br>


            val graph = Array(
              Array(Edge(1, 2), Edge(2, 1), Edge(3, 3)),
              Array(Edge(0, 2), Edge(2, 4)),
              Array(Edge(0, 1), Edge(1, 4), Edge(3, 5)),
              Array(Edge(0, 3), Edge(2, 5))
            )

            prim(graph, 2)


### Output

The minimum spanning tree is printed to the console in the following format:


                  Minimum Spanning Tree:
                  0 -> 2 (weight = 1)
                  1 -> 0 (weight = 2)
                  3 -> 0 (weight = 3)



## Jug Filling Problem
<br>

This program solves the jug filling problem, which involves two jugs with known capacities and a desired goal capacity. The goal is to fill one or both jugs with water to reach the desired goal capacity.<br>

### Code Description

The **jugbp1** class defines a set of methods to simulate filling and emptying of jugs, and a **checkGoal()** method to check if the goal has been reached. The class has the following properties:


            a_max - maximum capacity of the first jug
            b_max - maximum capacity of the second jug
            a - current amount of water in the first jug
            b - current amount of water in the second jug
            goal - desired goal capacity
            
            
***The following methods are available:***

            fillA() - fills the first jug to its maximum capacity
            fillB() - fills the second jug to its maximum capacity
            transferAtoB() - transfers water from the first jug to the second jug until the second jug is full or the first jug is empty
            emptyA() - empties the first jug
            emptyB() - empties the second jug
            checkGoal() - checks if the goal capacity has been reached and prints a message
            

### Example Usage

                  class jugbp1 {
                    var a_max = 4
                    var b_max = 3
                    var a = 0
                    var b = 0
                    var goal = 2
                    }

                  object jugp1
                  {

                    def main(args: Array[String]) {
                      var w = new jugbp1();
                              w.checkGoal();

                    }
                  }


### Output:
                  {4,0}
                  {1,3}
                  {1,0}
                  {0,1}
                  {4,1}
                  {2,3}
                  {2,0}
                  {0,2}
                  {4,2}
                  Solution found !
### Explation of Output 

The code simulates the **"jug problem"** for two jugs, **A** and **B**, with maximum capacities of **4** and **3** respectively. The goal is to measure out **2** units of liquid using these jugs.

The output of the code is a sequence of println statements that show the state of the jugs at each step of the process. The code first initializes the jugs with zero units of liquid, and then runs the checkGoal function which iteratively fills and empties the jugs until the goal is achieved.

The output starts with the initial state of the jugs: "{0,0}". Then, the code starts to fill jug A, producing the output **"{4,0}"**. Next, it transfers liquid from A to B until B is full, producing the output **"{1,3}", "{0,4}"** . The code then empties jug B, producing the output **"{0,0}"**. Finally, it transfers liquid from A to B until B has 2 units, producing the output **"{2,2}"**, and then the code terminates with the message "Solution found!".

Overall, the code demonstrates a simple algorithm for solving the jug problem, and the output shows the sequence of steps required to achieve the desired goal.


## Missionaries and Cannibals Problem

This is a Scala program that solves the famous Missionaries and Cannibals Problem. The problem is as follows:

On one side of a river, there are three missionaries and three cannibals. There is a boat that can carry up to two people at a time. The goal is to transport all six people to the other side of the river, such that no group of cannibals ever outnumber the missionaries on either side of the river.<br>


### Usage

      1. Clone the repository to your local machine.

      2. Open the terminal and navigate to the project directory.

      3. Run the following command to compile the program:

                        scala missionariesprob.scala

      4. Run the following command to execute the program:

                        scala missionariesprob
                        

### Implementation

The program is implemented using the case class **State**, which represents a state in the puzzle. The class has methods to check if a state is valid, if it is the goal state, and to move the missionaries and cannibals across the river.

The **findSolution** function uses breadth-first search to find the solution to the puzzle. It generates all possible next states from the current state and checks if they are valid and have not been visited before. It then adds the new state to the visited set and creates a new path by appending the new state to the current path.

The main function defines the initial state of the puzzle and finds the solution using the **findSolution** function.

### Output

The program will output the solution to the console, which is a list of states that represent each move in the solution path.

