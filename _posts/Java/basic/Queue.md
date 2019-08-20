**Queue： 基本上，一个队列就是一个先入先出（FIFO）的数据结构**

队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作



```java
java中基于数组实现队列
//基于数组建立一个队列
public class Queue {
//	int first_position=0;
	int last_position=0;
	int trueArrayLen=0;
	String[] strArray = new String[1];    //相同的表达：String Array[]  = new String[1];
	

//	public String[] add(String str)
	public void  add(String str){
		
		trueArrayLen++;
//		System.out.println(trueArrayLen);
		if(strArray.length==1){		
			String[] new_strArray = new String[strArray.length + 10];
			new_strArray[0]=str;
		}
		
		if(strArray.length==trueArrayLen){
			String[] new_strArray = new String[strArray.length + 10];
			for(int i=0;i<strArray.length;i++){		
				new_strArray[i]=strArray[i];
				new_strArray[strArray.length]=str;		
			}
		this.strArray=new_strArray;
		}
		else{		
		    last_position=trueArrayLen;
		    strArray[last_position]=str;

//		    System.out.println(strArray[0]);   
		}
		System.out.println(strArray[0]);
		}
		
//	public void remove(){
//		
//	}
//
//
//
//    public void insert(){
//    	
//    }
//
//	
//	public String get(){
//		return sa.length;
//	}

//	public void insert(){
//		
//	}
	
	public static void main(String[] args){
		Queue Addtest = new Queue();
		Addtest.add("qwer");
//		String Array[]= test.add("qwe");
//		System.out.println(strArray[0]);
	}

}
```

