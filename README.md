--------------------------------------------------------------------------------
							Algorithms
--------------------------------------------------------------------------------

1) Finding shortest path in Undirected graphs using Dijkstra Algorithm.

	Runtime Analysis:-

- Priority Queue is used. Java Priority Queue uses heap structure.
- Each vertex insertion and the corresponding heapify operation takes
	O(log n) time. So, Total = n log n.
- Each vertex removal along with heapify operation takes O(log n) time. So, Total = n log n.
- Each vertex modified along with heapify operation takes O(log n) time. The modification is done for each edge, for total m edges. So, Total = m log n.
- The total time = n log n + m log n + n log n = O((m+n) log n).

2) Finding the Minimum spanning tree using Prims Algorithm.

	Runtime Analysis:-

- Priority Queue is used. Java Priority Queue uses heap structure.
- Each vertex insertion and the corresponding heapify operation takes
	O(log n) time. So, Total = n log n.
- Each vertex removal along with heapify operation takes O(log n) time. So, Total = n log n.
- Each vertex modified along with heapify operation takes O(log n) time. Each vertex will be modified for maximum of its incident edges. So, total m edges. Hence, Total = m log n.
- The total time = n log n + m log n + n log n = O((m+n) log n).
