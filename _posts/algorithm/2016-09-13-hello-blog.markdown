---
layout:     post
title:      "个人博客 "
date:       2016-09-13 
categories: algorithm
tags: 算法
---


从100万个数字里选出最大的10个数
```Java

import java.util.Random;

public class HeapSort {
	/**
	 * 对数组进行堆排序;
	 * 输入一个数组，比如   int[]  array =[2,4,1,3,5];
	 * 返回一个从小到大排好序的数组  array =[1,2,3,4,5]
	 */
	
	public void heapsort(int[] array){
		heapMax(array,array.length);
		
		for (int i=array.length-1;i>1;i--){
			swap(array,1,i);
			heapMax(array,i);
//		    HeapAdjust(array,1,i-1);			    
		}
	}
	
	//把数组array构建成大根堆	
	public  void heapMax(int[] array,int computerLenth){
		for (int i=computerLenth/2;i>0;i--){
			HeapAdjust(array,i,computerLenth);
		}
    }
	
	//若节点比最大的子节点小，则与最大的子节点交换
	public void HeapAdjust (int[] array,int s,int length) {
		int temp;
		temp= array[s];
		
		int left = s * 2; // 左子节点
		int right = s * 2 + 1; // 右子节点
		
		if(left < length && array[s]<array[s*2] ){
			array[s]=array[s*2];
			array[s*2]=temp;
		}
		if(right < length && array[s]<array[s*2+1] ){
			array[s]=array[s*2+1];
			array[s*2+1]=temp;
		}
		else{
			return;
		}	
	}
	// 数组元素交换
	public void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	/**
	 * 输入100万个数的数组，
	 * 选择最大的10个数，count=10
	 */
 
	int[] maxNubmerArr;
	public void getMaxSort(int count,int[] data){
		maxNubmerArr = new int[count];
		for(int k=0;k<count;k++){
			maxNubmerArr[k]=data[k];
		}
		
		heapsort(maxNubmerArr);
		//将数组中的每个数组与maxNubmerArr最小的值比大小
		//若比最小的值大则替换掉，重新运行堆排序
//		for(int i=10;i<data.length;i++){
//			if(data[i]>maxNubmerArr[0]){
//				maxNubmerArr[0]=data[i];
//				heapsort(maxNubmerArr);
//			}
//		}
		for(int i=0;i< maxNubmerArr.length;i++){
		System.out.print(maxNubmerArr[i]+",");}

	}
	public static void main(String[] args) {
		
//    	Random random = new Random();
//    	int[] data = new int[20];
//    	for(int i=0;i<20;i++){
//    		data[i]=random.nextInt(100);
//    		System.out.print(data[i]+",");
//    	}
//    	int[] data = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
    	int[] data = new int[]{ 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };

		HeapSort test = new HeapSort();
		test.getMaxSort(10, data);	
		
	}

}

```