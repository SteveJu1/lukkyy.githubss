package com.yao.qq;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MyMap {
	
	Node[] nodes = new Node[100];
	
	//泛型
	class Node<K, V> {
		K key;
		V value;
		Node next;
	}
	
	public void add(String name, Student stu) {
		Node node = new Node();
		node.key = name;
		node.value = stu;
		
		//散列算法
		int code = name.hashCode();
		if(nodes[code%nodes.length] != null) {
			Node oldNode = nodes[code%nodes.length];
			oldNode.next = node;
		} else {
			nodes[code%nodes.length] = node;
		}
		
	}

	public static void main(String[] args) {
		HashMap<String,Student> map = new HashMap<String,Student>();
		
		//存取
		for(int i=0; i<10; i++) {
			Student stu = new Student();
			stu.name = "name"+i;
			stu.score = 20+i;
			
			map.put(stu.name, stu);
		}
		
		Student stu = map.get("name3");
		if(stu != null) {
			System.out.println(stu.toString());
		}
		
		//遍历
		//根据key遍历
		Set<String> sets = map.keySet();
		Iterator<String> iterator = sets.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			Student stu2 = map.get(key);
			System.out.println(stu2);
		}
		//迭代循环
		for(String str : sets) {
			Student stu2 = map.get(str);
			System.out.println(stu2);
		}
		
		//values遍历
		Collection<Student> coll = map.values();
//		coll.iterator()
		for(Student stu3 : coll) {
			System.out.println(stu3);
		}
		
		//Entry遍历
		Set<Entry<String, Student>> sets2 = map.entrySet();
		for(Entry<String, Student> entry : sets2) {
			String key = entry.getKey();
			Student stu4 = entry.getValue();
			System.out.println(stu4);
		}
	}

}
