
import static org.junit.Assert.*;

import org.junit.Test;


public class DAGTest {

	// Test for lca dag constructor
		@Test
		public void testLCADAGConstructor() {
		 	DAG graph = new DAG(-1);
		 	assertEquals(0,graph.V());
		 	DAG graph2= new DAG(2);
		 	assertEquals(2,graph2.V());
		 	assertEquals(0,graph2.E());
		 	
		}
	

	
		// test for v() function
		@Test
		public void testV() {
			DAG graph = new DAG(4);
			graph.addEdge(0, 1);
			graph.addEdge(0, 2);
			graph.addEdge(0, 3);
			
			assertEquals(4, graph.V());
		}
		
		@Test
		public void testE() {
			DAG graph = new DAG(4);
			graph.addEdge(0, 1);
			graph.addEdge(0, 2);
			graph.addEdge(0, 3);
			
			assertEquals(3, graph.E());
		}

		// Test to see if a vertex is valid
		@Test
		public void testValidateVertex() {
			DAG graph = new DAG(4);
			
			assertTrue(graph.validateVertex(0));
			assertTrue(graph.validateVertex(1));
			assertTrue(graph.validateVertex(2));
			assertTrue(graph.validateVertex(3));
			assertFalse(graph.validateVertex(4));
			
			
		}

		@Test
		public void testAddEdge() {
			DAG graph = new DAG(4);
			graph.addEdge(0, 1);
			graph.addEdge(0, 2);
			graph.addEdge(0, 3);
			assertEquals(3, graph.E());

		}

		@Test
		public void testRemoveEdge() {
			DAG graph = new DAG(4);
			graph.addEdge(0, 1);
			graph.addEdge(0, 2);
			graph.addEdge(0, 3);
			assertEquals(3, graph.E());

			graph.removeEdge(0, 1);

			// removed the edge so there is only one less edge
			assertEquals(2, graph.E());
		}

		@Test
		public void testoutDegree() {
			DAG graph = new DAG(4);
			graph.addEdge(0, 1);
			graph.addEdge(0, 2);
			graph.addEdge(0, 3);

			assertEquals(3, graph.outdegree(0));
			assertEquals(0, graph.outdegree(1));
			assertEquals(0, graph.outdegree(2));
			
		
		}

		@Test
		public void testINDegree() {
			DAG graph = new DAG(4);
			graph.addEdge(0, 1);
			graph.addEdge(0, 2);
			graph.addEdge(0, 3);

			assertEquals(1, graph.indegree(1));
			assertEquals(0, graph.indegree(0));
			
		}
		
		@Test
		public void testHasCycle() {
			DAG graph = new DAG(4);
			graph.addEdge(0, 1);
			graph.addEdge(0, 2);
			graph.addEdge(0, 3);
			assertFalse(graph.hasCycle());
	

			DAG graph2 = new DAG(4);
			graph2.addEdge(0, 1);
			graph2.addEdge(1, 2);
			graph2.addEdge(2, 3);
			graph2.addEdge(3, 0);
			assertTrue(graph2.hasCycle());
		}
		
		
		@Test(expected = NullPointerException.class)
		public void testLCA() {

			DAG graph = new DAG(4);
			graph.addEdge(0, 1);
			graph.addEdge(1, 2);
			graph.addEdge(2, 3);
			assertEquals(2, graph.findLCA(1,2));
			

			DAG graph2 = new DAG(4);
			graph2.addEdge(0, 1);
			graph2.addEdge(1, 2);
			graph2.addEdge(2, 3);
			graph2.addEdge(3, 0);
			assertTrue(graph2.hasCycle());

			//throws an illegal exception
			assertEquals(null, graph2.findLCA(1,2));
			

		}
		
		
		@Test(expected = NullPointerException.class)
		public void testLCANonEx() {

			DAG graph = new DAG(4);
			graph.addEdge(0, 1);
			graph.addEdge(1, 2);
			graph.addEdge(2, 3);
			//throws an illegal exception
			assertEquals(null, graph.findLCA(1,8));
			

		}
		
		
		


}