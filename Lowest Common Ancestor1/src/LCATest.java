import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class LCATest {
	
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
	
	
	
}
