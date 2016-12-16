package interfaces;

import java.util.Iterator;

public interface GraphADT<T>
{
   /** Adds a vertex to this graph, associating object with vertex. */
   public void addVertex (T vertex);

   /** Removes a single vertex with the given value from this graph. */
   public void removeVertex (T vertex);

   /** Inserts an edge between two vertices of this graph. */
   public void addEdge (T vertex1, T vertex2);

   /** Removes an edge between two vertices of this graph. */
   public void removeEdge (T vertex1, T vertex2);

   /** Retruns a breadth first iterator starting with the given vertex. */
   public Iterator iteratorBFS(T startVertex);

   /** Retruns a depth first iterator starting with the given vertex. */
   public Iterator iteratorDFS(T startVertex);

   /** Returns an iterator that contains the shortest path between
       the two vertices. */
   public Iterator iteratorShortestPath(T startVertex, T targetVertex);

   /** Returns true if this graph is empty, false otherwise. */
   public boolean isEmpty();

   /** Returns true if this graph is connected, false otherwise. */
   public boolean isConnected();

   /** Returns the number of vertices in this graph. */
   public int size();

   /** Returns a string representation of the adjacency matrix. */
   @Override
public String toString();
}