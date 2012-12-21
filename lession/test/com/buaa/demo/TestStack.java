package com.buaa.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStack {
	
	@Test
	public void check_push(){
		MyStack stack=new MyStack(5);
		assertEquals(true,stack.push(1));
		assertEquals(true,stack.push(2));
		assertEquals(true,stack.push(3));
		assertEquals(true,stack.push(4));
		assertEquals(true,stack.push(5));
		assertEquals(true,stack.push(6));
	}
	
	@Test
	public void check_stack_empty(){
		MyStack stack=new MyStack(5);
		assertEquals(true,stack.isEmpty());
	}
	
	@Test 
	public void check_pop(){
		MyStack stack=new MyStack(100);
		assertEquals(true,stack.push(1));
		assertEquals(true,stack.push(2));
		assertEquals(true,stack.push(3));
		System.out.print(stack.pop());
		assertEquals(true,stack.push(5));
		assertEquals(true,stack.push(6));
		System.out.print(stack.pop());
		System.out.print(stack.pop());
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
}
/**
 * 
 * 1.初始化stack
 * 2.stack是否为空
 */
