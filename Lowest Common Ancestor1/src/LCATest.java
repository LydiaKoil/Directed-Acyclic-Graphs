import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

class LCATest {
	@Test
	void testConstructorNode() {
		Node node= new Node(1);
		
		assertEquals(1, node.data);
		//assertSame(null,node.left);
		
	}
	
	
	@Test
	void testConstructorTree() {
		LCA tree= new LCA();
	    tree.root = new Node(1); 
	    tree.root.left = new Node(2); 
	    tree.root.right = new Node(3); 
	    tree.root.left.left = new Node(4); 
	    tree.root.left.right = new Node(5); 
	    tree.root.right.left = new Node(6); 
	    tree.root.right.right = new Node(7); 
	    
	    
	    assertEquals(1, tree.root.data);
	    assertEquals(2, tree.root.left.data);
	    assertEquals(3, tree.root.right.data); 
	    assertEquals(4, tree.root.left.left.data); 
		
	}
	
	@Test
	void testFindPath() {
		LCA tree = new LCA(); 
	    tree.root = new Node(1); 
	    tree.root.left = new Node(2); 
	    tree.root.right = new Node(3); 
	    tree.root.left.left = new Node(4); 
	    tree.root.left.right = new Node(5); 
	    tree.root.right.left = new Node(6); 
	    tree.root.right.right = new Node(7); 
		
	    List<Integer> pathFourActual = new ArrayList<>();
	    List<Integer> pathFour = new ArrayList<>();
	    pathFour.add(1);
	    pathFour.add(2);
	    pathFour.add(4);
	    
	    tree.findPath(tree.root, 4, pathFourActual);
	    assertIterableEquals(pathFourActual,pathFour);// to see if correct path is being stored
	    //System.out.println(Arrays.deepToString(pathFourActual.toArray()));
	}
	
	
	
	@Test
	void testfindLCAInternal() {
		LCA tree = new LCA(); 
	    tree.root = new Node(1); 
	    tree.root.left = new Node(2); 
	    tree.root.right = new Node(3); 
	    tree.root.left.left = new Node(4); 
	    tree.root.left.right = new Node(5); 
	    tree.root.right.left = new Node(6); 
	    tree.root.right.right = new Node(7); 
		
	    assertEquals(2, tree.findLCA(4,5));
	    assertEquals(1, tree.findLCA(4,6));
	    assertEquals(1, tree.findLCA(3,4));
	    assertEquals(2, tree.findLCA(2,4));
	}
	
	
	@Test
	void testNonExNum() {
		LCA tree= new LCA();
	    tree.root = new Node(1); 
	    tree.root.left = new Node(2); 
	    tree.root.right = new Node(3); 
	    tree.root.left.left = new Node(4); 
	    tree.root.left.right = new Node(5); 
	    tree.root.right.left = new Node(6); 
	    tree.root.right.right = new Node(7); 
	    
	    assertEquals(-1, tree.findLCA(12,5)); //1st number missing
	    assertEquals(-1, tree.findLCA(4,10)); //2nd number missing
	    assertEquals(-1, tree.findLCA(20,10)); //both numbers missing
	    
	}
	
	@Test
	void testNegativeTree() {
		LCA tree = new LCA(); 
	    tree.root = new Node(-1); 
	    tree.root.left = new Node(-2); 
	    tree.root.right = new Node(-3); 
	    tree.root.left.left = new Node(-4); 
	    tree.root.left.right = new Node(-5); 
	    tree.root.right.left = new Node(-6); 
	    tree.root.right.right = new Node(-7); 
		
	    assertEquals(-2, tree.findLCA(-4,-5));
	    assertEquals(-1, tree.findLCA(-4,-6));
	    assertEquals(-1, tree.findLCA(-3,-4));
	    assertEquals(-2, tree.findLCA(-2,-4));
	}
}
