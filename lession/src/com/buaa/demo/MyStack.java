package com.buaa.demo;

public class MyStack {

	private static final int EMPTY_FLAG=-1;
	public int totalSize=10;
	public int curIndex=EMPTY_FLAG;
	public Object[] objs=null;
	
	public MyStack(int size){
		if(size<=0){
			this.totalSize=10;
		}
		this.totalSize=size;
		this.objs=new Object[this.totalSize];
	}
	public MyStack(){
		this.objs=new Object[this.totalSize];
	}
	public boolean isEmpty(){
		return curIndex==EMPTY_FLAG;
	}
	public  boolean isFull(){
		return curIndex==totalSize-1;
	}
	public synchronized int getSize(){
		return this.curIndex+1;
	}
	public synchronized Object pop(){
		if(isEmpty()){
			return null;
		}
		Object o=objs[curIndex];
		curIndex--;
		return o;
	}
	public synchronized boolean push(Object o){
		if(isFull()){
			return false;
		}
		if(o==null){
			return false;
		}
		curIndex++;
		objs[curIndex]=o;
		return true;
	}
}
