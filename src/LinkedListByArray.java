
public class LinkedListByArray {
	
	private int headIndex;
	
	private int arr[][] = new int[5][2];
	
	LinkedListByArray(){
		arr[0][0] = 0;
		arr[0][1] = -1;
		arr[1][0] = 0;
		arr[1][1] = -1;
		arr[2][0] = 0;
		arr[2][1] = -1;
		arr[3][0] = 0;
		arr[3][1] = -1;
		arr[4][0] = 0;
		arr[4][1] = -1;
		headIndex = 0;
	}

	public int getHeadIndex() {
		return headIndex;
	}

	public void setHeadIndex(int headIndex) {
		this.headIndex = headIndex;
	}

	public int[][] getArr() {
		return arr;
	}

	public void setArr(int[][] arr) {
		this.arr = arr;
	}
	
	public void addNewElement(int data){
		int count=0;
		for(int i=0; i<5; i++){
			if(arr[i][1]==-1){
				count=count+1;
			}
		}
		if(count==5){
			arr[0][0]=data;
			arr[0][1]=-2;
			headIndex=0;
		}
		else if(count<5 && count>0){
			for(int j=0; j<5; j++){
				if(arr[j][1]==-1){
					arr[j][0]=data;
					arr[j][1]=headIndex;
					headIndex=j;
					break;
				}
			}
		}
		else if(count==0){
			System.out.println("List full");
		}
	}
	
	public void deleteElement(int data){
		int head = this.getHeadIndex();
		int headPrev = 0;
		while(head!=-2){
			if(arr[head][0]==data){
				arr[headPrev][1]=arr[head][1];
				arr[head][0]=0;
				arr[head][1]=-1;
				break;
			}
			else{
				headPrev = head;
				head=arr[head][1];
			}
		}
	}
	
	public void printLinkedList(){
		System.out.println("Head Index: "+this.getHeadIndex());
		int head = this.getHeadIndex();
		while(head!=-2){
			System.out.println("data: "+arr[head][0]+" "+"index: "+head+" "+"Next Index: "+arr[head][1]);
			head=arr[head][1];
		}
	}
	
	public static void main(String []args){
		LinkedListByArray ll1 = new LinkedListByArray();
		ll1.addNewElement(4);
		ll1.addNewElement(3);
		ll1.addNewElement(2);
		ll1.addNewElement(1);
		ll1.addNewElement(5);
		ll1.deleteElement(2);
		ll1.addNewElement(6);
		ll1.printLinkedList();
	}
}
