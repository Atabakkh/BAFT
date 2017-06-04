package ir.ata.baft;

import ir.ata.baft.model.Node;
import ir.baft.databasehelper.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Greedy {

	static DatabaseConnection dbConn;
	static Connection conn;
	static ResultSet rs;
	Node heap[];
	int seen[];
	int heapSize;
	public static final int MAX_VERTICES = 100;
	public static final int INFINITY = 1000010000;

	public Greedy() {
		init();
	}

	void init() {
		dbConn = new DatabaseConnection();
		conn = dbConn.mySqlConnection();
		heapSize = 0;
		// heap = new Node()
		// heap[0].setWeight(1000);
		// heap[0].setVertex("-1");
	}

	public String[][] run(ResultSet resultSet) {

		int[][] graph = new int[MAX_VERTICES][MAX_VERTICES];
		int[] size = new int[] { 0 };
		int[] distance = new int[MAX_VERTICES];
		int[][] cost = new int[MAX_VERTICES][MAX_VERTICES];
		int vertices = 0, edges = 0, weight = 0;
		int iter;
		/*
		 * vertices represent number of vertices and edges represent number of
		 * edges in the graph.
		 */
		System.out.println(vertices + " -" + edges);
		try {
			return (String[][]) ((greedySelection(resultSet) != null) ? greedySelection(resultSet)
					: 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int from = 0, to = 0;
		for (iter = 0; iter < edges; iter++) {
			System.out.print(from + "," + to + "," + weight);
			assert (from >= 0 && from < vertices);
			assert (to >= 0 && to < vertices);
			graph[from][size[from]] = to;
			cost[from][size[from]] = weight;
			size[from]++;
		}
		int source = 0;
		System.out.print(source);
		Node temp = new Node();
		for (iter = 0; iter < vertices; iter++) {
			if (iter == source) {
				temp.setWeight(0);
				distance[0] = 0;
			} else {
				temp.setWeight(INFINITY);
				distance[iter] = INFINITY;
			}
			temp.setVertex(String.valueOf(iter));
			insert(temp);
		}
		while (heapSize != 0) {
			Node min = deleteMin();
			int presentVertex = (int) min.getWeight();
			if (seen[presentVertex] != 0) {
				/* This has already been processed */
				continue;
			}
			seen[presentVertex] = 1;
			for (iter = 0; iter < size[presentVertex]; iter++) {
				int to1 = graph[presentVertex][iter];
				if (distance[to1] > distance[presentVertex]
						+ cost[presentVertex][iter]) {
					distance[to1] = distance[presentVertex]
							+ cost[presentVertex][iter];
					/*
					 * Instead of updating it in the queue, insert it again.
					 * This works because the updated distance is less than
					 * previous distance which makes it to pop out of the queue
					 * early
					 */
					temp.setVertex(String.valueOf(to1));
					temp.setWeight(distance[to1]);
					insert(temp);
				}
			}
		}
		for (iter = 0; iter < vertices; iter++) {
			System.out.print("vertex is " + iter + ", its distance is "
					+ distance[iter] + "\n");
		}

		return null;

		// return rs;
	}

	// / Standard deviation (STDEV) for existing nodes and pick the number who
	// are less than SD.
	// (we can use AVG instead of SD)
	String[][] greedySelection(ResultSet rs) throws SQLException {
		float weight[] = new float[100], worthWeight[] = new float[100], weightTemp, sum = 0;
		String node[][] = new String[100][2], temp;
		int n = 0, i = 0, j = 0, k = 0, m = 0, q = 0;
		rs.beforeFirst();

		while (rs.next()) {
			if (rs.getString(2) != null) {
				node[m][0] = rs.getString(2);
				node[m][1] = rs.getString(3);
				weight[m] = rs.getFloat(4);
				sum += rs.getFloat(4);
				m++;
			}
		}
		n = m;

		for (i = 0; i < n; i++) {
			if (node[i][0] != null) {
				for (j = i + 1; j < n; j++) {
					if (weight[i] > weight[j]) {
						temp = node[j][0];
						node[j][0] = node[i][0];
						node[i][0] = temp;

						weightTemp = weight[j];
						weight[j] = weight[i];
						weight[i] = weightTemp;

						temp = node[j][1];
						node[j][1] = node[i][1];
						node[i][1] = temp;
					}
				}
				q++;
			}
		}
		float STDEV = sum / q;
		int p = 0;
		String network[][] = new String[100][2];
		for (k = 0; k < n; k++) {
			if (weight[k] <= STDEV && node[k][0] != null) {
				network[p][0] = node[k][0];
				network[p][1] = node[k][1];
				worthWeight[p] = weight[k];
				p++;
			}
		}
		return network;
	}

	/* Insert an element into the heap */
	void insert(Node element) {
		heapSize++;
		heap[heapSize] = element; /* Insert in the last place */
		/* Adjust its position */
		int now = heapSize;
		while (heap[now / 2].getWeight() > element.getWeight()) {
			heap[now] = heap[now / 2];
			now /= 2;
		}
		heap[now] = element;
	}

	Node deleteMin() {
		/*
		 * heap[1] is the minimum element. So we remove heap[1]. Size of the
		 * heap is decreased. Now heap[1] has to be filled. We put the last
		 * element in its place and see if it fits. If it does not fit, take
		 * minimum element among both its children and replaces parent with it.
		 * Again See if the last element fits in that place.
		 */
		Node minElement, lastElement;
		int child, now;
		minElement = heap[1];
		lastElement = heap[heapSize--];
		/* now refers to the index at which we are now */
		for (now = 1; now * 2 <= heapSize; now = child) {
			/*
			 * child is the index of the element which is minimum among both the
			 * children
			 */
			/* Indexes of children are i*2 and i*2 + 1 */
			child = now * 2;
			/*
			 * child!=heapSize beacuse heap[heapSize+1] does not exist, which
			 * means it has only one child
			 */
			if (child != heapSize
					&& heap[child + 1].getWeight() < heap[child].getWeight()) {
				child++;
			}
			/*
			 * To check if the last element fits ot not it suffices to check if
			 * the last element is less than the minimum element among both the
			 * children
			 */
			if (lastElement.getWeight() > heap[child].getWeight()) {
				heap[now] = heap[child];
			} else /* It fits there */
			{
				break;
			}
		}
		heap[now] = lastElement;
		return minElement;
	}

}