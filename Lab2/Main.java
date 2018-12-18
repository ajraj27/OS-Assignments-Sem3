import java.util.*;

class Event{
	private String id,name,desc,time;
	private int day,duration;
	private int totalTime;

	Event(String id,String name,String desc,String time,int day,int duration){
		this.id=id;
		this.name=name;
		this.desc=desc;
		this.time=time;
		this.day=day;
		this.duration=duration;
	}

	public String getId(){
		return this.id;
	}

	public String getName(){
		return this.name;
	}

	public String getDesc(){
		return this.desc;
	}

	public String getTime(){
		return this.time;

	}

	public int getDay(){
		return this.day;
	}

	public int geDuration(){
		return this.duration;
	}

	public int getTotalTime(){
		return this.totalTime;
	}

	public void setTotalTime(int totalTime){
		this.totalTime=totalTime;
	}
}

class List{
	Event event[];
	int p,totalTime;
	String timeInString1,timeInString2;


	 List(int n){
		event=new Event[n];
		p=0;
	}

	public void addEvent(String id,String name,String desc,String time,int day,int  duration){
		Event temp=new Event(id,name,desc,time,day,duration);
		event[p]=temp;
		p++;

	}

	public void sortByDay(int n){
		int i,j;

		for(i=0;i<n-1;i++)
		{
			int iMin=i;

			for(j=i+1;j<n;j++)
			{
				if(event[j].getDay()<event[iMin].getDay())
					iMin=j;
			}

			Event temp=event[i];
			event[i]=event[iMin];
			event[iMin]=temp;
		}
	}

	public void sortByTime(int n){
		int i,j;

		for(i=0;i<n-1;i++)
		{
			int iMin=i;

			for(j=i+1;j<n;j++)
			{
				if(event[j].getDay()==event[iMin].getDay() && event[j].getTime().compareTo(event[iMin].getTime())<0)
					iMin=j;
			}

			Event temp=event[i];
			event[i]=event[iMin];
			event[iMin]=temp;
		}
	}

	public void sortById(int n){
		int i,j;

		for(i=0;i<n-1;i++)
		{
			int iMin=i;

			for(j=i+1;j<n;j++)
			{
				if(event[j].getDay()==event[iMin].getDay() && event[j].getTime().compareTo(event[iMin].getTime())==0 && event[j].getId().compareTo(event[iMin].getId())<0)
					iMin=j;
			}

			Event temp=event[i];
			event[i]=event[iMin];
			event[iMin]=temp;
		}
	}

	public void print(int n){
		int tempDay=0;

		for(int i=0;i<n;i++){
			if(tempDay!=event[i].getDay())
				System.out.println("Day "+event[i].getDay());

			System.out.println(event[i].getTime()+"("+event[i].geDuration()+") "+event[i].getId()+" "+event[i].getName()+" "+event[i].getDesc());

			tempDay=event[i].getDay();

		}
	}


}

class Main{
	public static void main(String []args){
		Scanner s=new Scanner(System.in);

		int t,day,duration;
		String id,name,desc,time;
		t=s.nextInt();

		while(t-- > 0){
			int n;
			n=s.nextInt();
			List list=new List(n);

			for(int i=0;i<n;i++){
				id=s.next();
				name=s.next();
				desc=s.next();
				day=s.nextInt();
				time=s.next();
				duration=s.nextInt();

				list.addEvent(id,name,desc,time,day,duration);
			}

			list.sortByDay(n);
			list.sortByTime(n);
			list.sortById(n);
			list.print(n);


		}
	}
}