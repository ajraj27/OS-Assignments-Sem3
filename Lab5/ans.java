import java.util.*;

class Student{

	private String roll,name;
	private int numSweets,numGotSweets=0;
	private Student arr[];

	Student(String roll,String name,int numSweets,int n){
		this.roll=roll;
		this.name=name;
		this.numSweets=numSweets;
		this.arr=new Student[n];
	}

	public String getRoll(){
		return this.roll;
	}

	public String getName(){
		return this.name;
	}

	public int getNumSweets(){
		return this.numSweets;
	}

	public void addArray(Student temp){
		arr[numGotSweets++]=temp;
	}

	public int getNumGotSweets(){
		return this.numGotSweets;
	}

	public Student getArray(){
		return this.arr;
	}


}


class List{

	private Student student[];
	int p;

	List(int n){
		student=new Student[n];
		p=0;
	}

	public void addStudent(String roll,String name,int numSweets,int n){
		Student temp=new Student(roll,name,numSweets,n);
		student[p++]=temp;
	}

	public Student findStudent(String roll,int n){
		for(int i=0;i<n;i++){
			if(student[i].getRoll().equals(roll)){
				return student[i];
			}
		}
	}

	public void allotment(String roll,int k,String rollArr[]){
		Student temp=findStudent(roll);
		int r=min(temp.getNumSweets(),k);

		for(int i=0;i<r;i++){
			Student temp1=findStudent(rollArr[i]);
			temp1.addArray(temp);
		}

	}

	public void sortByRoll(Student arr[],int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i-1;j++){
				if(arr[j].getRoll().compareTo(arr[j+1].getRoll())>0){
					Student temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}

	public void print(int n){
		sortByRoll(student,n);

		for(int i=0;i<n;i++){
			int num=student[i].getNumGotSweets();
			System.out.println(student[i].getRoll()+" "+num);
			Student arr=student[i].getArray();
			sortByRoll(arr,num);
			for(int j=0;j<num;j++){
				System.out.println(arr[j].getRoll());
			}

		}
	}

}	


class Main{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);

		int n,numSweets,k;
		String roll,name,rollArr[];

		n=s.nextInt();
		List list=new List(n);

		for(int i=0;i<n;i++){
			roll=s.next();
			name=s.next();
			numSweets=s.nextInt();

			list.addStudent(roll,name,numSweets,n);
		}

		for(int i=0;i<n;i++){
			int q=0;

			roll=s.next();
			k=s.nextInt();
			rollArr=new String[k];

			for(int j=0;j<k;j++)
				rollArr[q++]=s.next();

			list.allotment(roll,k,rollArr);
			list.print(n);

		}
	}
}