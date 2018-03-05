import java.io.*;
import java.util.Iterator;
import java.util.HashSet;


public class Ladder
{
	public static void main(String[] args) throws IOException
	{
		HashSet dic = new HashSet();


		String fname = "";
	//	Reader infile = null;
		FileReader infile1 = null;
		while(true){
            try{
                System.out.print("Dictionary file name? ");
                BufferedReader in = new BufferedReader(
					new InputStreamReader(System.in));
			    fname = in.readLine();

                // create a file object with filename
                infile1 = new FileReader(fname);
         //       infile = infile1;
                break;
            }catch(FileNotFoundException ex){
                System.out.println("Unable to open that file.   Try again.\n");
            }
            catch(IOException e){
                System.out.println("Unable to open that file.   Try again.\n");
            }
		}
         String line = "";
		BufferedReader infile2 = new BufferedReader(infile1);
        infile1.close();
        while((line = infile2.readLine()) != null){
		    dic.add(line);
         //   System.out.println(line);
        }
		infile2.close();

        bool input_stat = true;
        while(true){
            String begin = "";
            String end = "";

        }
//		try{
//			BufferedReader in = new BufferedReader(
//				new InputStreamReader(System.in));
//			fname = in.readLine();
//		}catch(IOException e){}
//		System.in.println("You have entered: "+s);
	}
}
