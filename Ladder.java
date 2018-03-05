import java.io.*;
import java.util.Iterator;
import java.util.HashSet;


public class Ladder
{
	public static void main(String[] args)
	{
		HashSet dic = new HashSet();

		String fname = "";

		FileReader out = null;
		while(true){
            try{
                System.out.print("Dictionary file name? ");
                BufferedReader in = new BufferedReader(
					new InputStreamReader(System.in));
			    fname = in.readLine();

                // create a file object with filename
                out = new FileReader(fname);
                break;
            }catch(FileNotFoundException ex){
                System.out.println("Unable to open that file.   Try again.\n");
            }
            catch(IOException e){
                System.out.println("Unable to open that file.   Try again.\n");
            }
		}


//		try{
//			BufferedReader in = new BufferedReader(
//				new InputStreamReader(System.in));
//			fname = in.readLine();
//		}catch(IOException e){}
//		System.out.println("You have entered: "+s);
	}
}
