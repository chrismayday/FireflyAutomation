package practicejava;

public class StaticClassDemo0 {

	static{
		
	}
	
	
	public static void main(String[] args){
		//���Ծ�̬����
		StaticClass.inc("This is a string");
		{
			
		}
		//���Ծ�̬����
		StaticClass v1,v2;
		v1 = new StaticClass();
		v2 = new StaticClass();
		System.out.println("v1.i="+v1.i+" v2.i="+v2.i);
		v1.inc();
		System.out.println("v1.i="+v1.i+" v2.i="+v2.i);	
		
	}
}
