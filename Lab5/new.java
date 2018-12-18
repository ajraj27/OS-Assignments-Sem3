import java.util.*;

class Person{
	private int analytical,reasoning,verbal,luck,round=1;
	private String roll,name;
	private boolean flag=true,match=true;

	Person(String roll,String name,int analytical,int reasoning,int verbal,int luck){
		this.roll=roll;
		this.name=name;
		this.analytical=analytical;
		this.reasoning=reasoning;
		this.verbal=verbal;
		this.luck=luck;
	}

	public String getRoll(){
		return this.roll;
	}

	public String getName(){
		return this.name;
	}

	public int getAnalytical(){
		return this.analytical;
	}

	public int getReasoning(){
		return this.reasoning;
	}

	public int getVerbal(){
		return this.verbal;
	}

	public int getLuck(){
		return this.luck;
	}

	public int getRound(){
		return this.round;
	}

	public void incRound(){
		this.round++;
	}

	public void setEliminate(){
		this.flag=false;
	}

	public boolean getFlag(){
		return this.flag;
	}

	public boolean getMatch(){
		return this.match;
	}

	public void setMatch(){
		this.match=false;
	}

	public void setStartMatch(){
		this.match=true;
	}


}

class List{
	Person students[],ta[];
	int p,q;

	List(int n,int k){
		students=new Person[n];
		ta=new Person[k];
		p=0;q=0;
	}

	public void addStudent(Person temp){
		students[p++]=temp;
	}

	public void addTa(Person temp){
		ta[q++]=temp;
	}

	public void sortByRoll(int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i-1;j++){
				if((students[j].getRoll().compareTo(students[j+1].getRoll()))>0){
					Person temp=students[j];
					students[j]=students[j+1];
					students[j+1]=temp;
				}
			}
		}
	}

	public int calculateScore(Person ta,Person student){
		int score =ta.getAnalytical()*student.getAnalytical()+ta.getReasoning()*student.getReasoning()+ta.getVerbal()+ta.getLuck()*student.getLuck();
		return score;
	}

	public Person search(int n){
		Person temp=null;
		for(int i=0;i<n;i++){
			if(students[i].getFlag()==true && students[i].getMatch==true){
				temp=students[i];
				break;
			}
		}
		
		return temp;

	}

	public void allocate(int n,int k){

		sortByRoll(n);


		while(1){

			int ctr=0,taCtr=0;

			for(int i=0;i<n;i++){
				if(students[i].getFlag()==true){
					ctr++;
				}

				students[i].setStartMatch();

			}

			if(ctr==1){
				break;
			}

			int num=ctr;

			if(num%2==0){

				for(int i=0;i<num/2;i++){
					Person tempTa=ta[taCtr%k];
					Person student1=search(n);
					student1.setMatch();
					Person student2=search(n);
					student2.setMatch();

					int score1=calculateScore(tempTa,student1);
					int score2=calculateScore(tempTa,student2);

					if(score2>score1){
						student2.incRound();
						student1.setEliminate();
					}

					else{
						student1.incRound();
						student2.setEliminate();
					}

					taCtr++;

				}
			}

			else{

				for(int i=0;i<num/2;i++){
					Person tempTa=ta[taCtr%k];
					Person student1=search(n);
					student1.setMatch();
					Person student2=search(n);
					student2.setMatch();

					int score1=calculateScore(tempTa,student1);
					int score2=calculateScore(tempTa,student2);

					if(score2>score1){
						student2.incRound();
						student1.setEliminate();
					}

					else{
						student1.incRound();
						student2.setEliminate();
					}

					taCtr++;

				}

				students[n-1].setMatch();
				students[n-1].incRound();
			}
		}
	}

	public void print(int n){
		for(int i=0;i<n;i++){
			System.out.println(students[i].getRoll()+" "+students[i].getName()+" "+students[i].getRound());
		}
	}
}

class Main{
	public static void main(String[] args){
		int n,k,analytical,reasoning,verbal,luck;
		String roll,name;

		Scanner s=new Scanner(System.in);

		n=s.nextInt();
		k=s.nextInt();

		List list=new List(n,k);

		for(int i=0;i<n;i++){
			roll=s.next();
			name=s.next();
			analytical=s.nextInt();
			reasoning=s.nextInt();
			verbal=s.nextInt();
			luck=s.nextInt();

			Person temp=new Person(roll,name,analytical,reasoning,verbal,luck);
			list.addStudent(temp);
		}

		for(int i=0;i<k;i++){
			roll=s.next();
			name=s.next();
			analytical=s.nextInt();
			reasoning=s.nextInt();
			verbal=s.nextInt();
			luck=s.nextInt();

			Person temp=new Person(roll,name,analytical,reasoning,verbal,luck);
			list.addTa(temp);
		}

		list.allocate(n,k);
		list.print(n);
	}
}