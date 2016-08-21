package Arrays;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedExample {
	public static void main(String[] args) throws Exception {

		/*
		 * Type 1
		 * 
		 * BufferedReader br = null;

		try {
			String currentLine;
			br = new BufferedReader(new FileReader("C:\\file.txt"));

			while((currentLine = br.readLine()) != null)
			{
				System.out.println(currentLine);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		finally{
			try{
				if(br != null)
					br.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		 */

		/*
		 * Type 2
		 * 
		 * 
		 * BufferedReader br = null;
		InputStream is = null;
		InputStreamReader isr = null;

		try{
			String currentLine;
			is = new FileInputStream("C:\\file.txt");
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			while((currentLine = br.readLine()) != null)
			{
				System.out.println(currentLine);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				if(br != null)
					br.close();
				if(isr != null)
					isr.close();
				if(is != null)
					is.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		 */	

		/*		
		 * 
		 * Type 3
		 * DataInputStream ds = null;
		FileInputStream fs = null;
		BufferedReader br = null;

		try{
			String currentLine;
			fs = new FileInputStream("C:\\file.txt");
			ds = new DataInputStream(fs);
			br = new BufferedReader(new InputStreamReader(ds));

			while((currentLine = br.readLine()) != null)
			{
				System.out.println(currentLine);
			}

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		finally{
			try{
				if(fs != null)
					fs.close();
				if(ds != null)
					ds.close();
				if(br != null)
					br.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}*/
	}
}