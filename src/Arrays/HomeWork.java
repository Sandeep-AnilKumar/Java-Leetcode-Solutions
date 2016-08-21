package Arrays;

public class HomeWork {
	
	public float a, b;
	public int c, d;
	int y = 1;
	public HomeWork()
	{
		a = 8.0f;
		d = 9;
		y = 2;
		f();
	}
	
	public HomeWork(int a, int b)
	{
		this.c = a;
		this.d = b;
	}
	
	public HomeWork(float a, float b)
	{
		this.a = a;
		this.b = b;
	}
	
	public void f()
	{
		System.out.println("Inside outer class with value of y =" + y);
	}
	
	public int sum(int a, int b)
	{
		return a + b;
	}
	
	public float sum(float a, float b)
	{
		return a + b;
	}
	
	public float value()
	{
		this.a = 22;
		return this.a;
	}
	
	public int changeToInt(float f)
	{
		return (int) f;
	}
	
	public float changeToFloat(int i)
	{
		return i;
	}
	
	public int valueOf(char s)
	{
		return (int) s;
	}
	
	public char valueOfInt(int i)
	{
		return (char) i;
	}
	
	public static class second extends HomeWork
	{
		int y = 3;
		public second()
		{
			f();
		}
		public void f()
		{
			System.out.println("Inside inner class with value of y =" + y);
		}
	}
}
