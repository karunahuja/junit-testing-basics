package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	MathUtils mathUtils;
	
	@BeforeAll
	static void beforeAllInit() {
		
		System.out.println("This needs to run");
	}
	
	@BeforeEach
	void init() {
		
			mathUtils=new MathUtils();
		
		
	}
	
	@AfterEach 
	void cleanup() {
		
		System.out.println("Cleaning up");
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	void test() {
		
		
		
		int expected=3;
		
		int actual=mathUtils.add(1, 2);
		
		assertEquals(expected, actual,"The add method should add two numbers");
		
		
	}
	
	@RepeatedTest(3)
	void testComputeCircleRadius() {
		
			
			assertEquals(314.1592653589793,mathUtils.computeCircleArea(10));
		
		
	}
	
	@Test
	void testMultiply() {
		
		
		assertAll(
				()->{
					assertEquals(4, mathUtils.multiply(2, 2));
				},
				
				()->{
					assertEquals(46, mathUtils.multiply(23, 2));
				},
				()->{
					assertEquals(40, mathUtils.multiply(20, 2));
				}
				);
	}
	
	
	@Test
	void testDivide() {
		
		boolean isServerUp=false;
		
		assumeTrue(isServerUp);

		assertThrows(ArithmeticException.class, ()->mathUtils.divide(1,0),"Divide by zero should throw");
		
		
	}
	
	@Nested
	class AddTest{
		@Test
		void testAddPositive() {
			
			assertEquals(2,mathUtils.add(1, 1));
			
		}
		@Test
		void testAddNegative() {
			
			assertEquals(-2,mathUtils.add(-1, -1));
		}
		
		
	}

}
