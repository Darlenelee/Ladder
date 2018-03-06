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

        while((line = infile2.readLine()) != null){
		    dic.add(line);
         //   System.out.println(line);
        }
        infile1.close();
        infile2.close();

        boolean input_stat = true;
        while(true){
            String begin = "";
            String end = "";
            while(true){
                System.out.println("\nWord #1 (or Enter to quit): ");
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(System.in));
                //input.mark(10);
                //int ch1 = input.read();
                //if(ch1 == -1){
                //    input_stat = false;
                //    System.out.println("quitting");
                //    break;
                //}
                //else{
                //    input.reset();
                //}
                begin = input.readLine();
                if(begin.length()<=0){
                    input_stat = false;
                    System.out.println("quitting");
                    break;
                }

                System.out.println("\nWord #2 (or Enter to quit): ");
                //input.mark(10);
                //int ch2 = input.read();
                //if(ch2 == -1){
                //    input_stat = false;
                //    System.out.println("quitting");
                //    break;
                //}
                //else{
                //    input.reset();
                //}
                end = input.readLine();
                if(end.length()<=0){
                    input_stat = false;
                    System.out.println("quitting");
                    break;
                }
                // check existence
                if(dic.contains(begin) == false || dic.contains(end) == false){
                    System.out.println("The two words must be found in the dictionary.\n");
                }
                else {
                    if (begin.equals(end)){
                        System.out.println("The two words must be different.\n");
                    }
                    else if (begin.length() != end.length()){
                        System.out.println("The two words must be the same length.\n");
                    }
                    else break;
                }

            }
            if(input_stat == false) break;
            // words already appeared in stacks
            HashSet wordpool = new HashSet();
        }
        return;
//		try{
//			BufferedReader in = new BufferedReader(
//				new InputStreamReader(System.in));
//			fname = in.readLine();
//		}catch(IOException e){}
//		System.in.println("You have entered: "+s);
	}
}
