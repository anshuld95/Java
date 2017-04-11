class queue{
	private int[] myArr;
	private int front;
	private int rear;

	public queue(int maxsize){
		myArr = new int[maxsize];
		rear = -1;
		front = 0;
	}

	public void insert(int data){
		myArr[++rear] = data;
	}

	public int delete(){
		return myArr[front++];
	}

	public int peek(){
		return myArr[front];
	}

	public static void main(String[] args)
	{
		queue q = new queue(10);
		q.insert(5);
		q.insert(6);
		q.insert(9);
		q.insert(1);
		q.insert(6);
		q.insert(2);
		for (int i =0; i<3;i++){
			System.out.println(q.delete());
		}

	}
}