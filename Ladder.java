import java.io.*;
import java.util.Iterator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

                begin = input.readLine();
                if(begin.length()<=0){
                    input_stat = false;
                    break;
                }

                System.out.println("Word #2 (or Enter to quit): ");

                end = input.readLine();
                if(end.length()<=0){
                    input_stat = false;
                    break;
                }
                // check existence
                if(dic.contains(begin) == false || dic.contains(end) == false){
                    System.out.println("The two words must be found in the dictionary.\n");
                }
                else if (begin.equals(end)){
                    System.out.println("The two words must be different.\n");
                }
                else if (begin.length() != end.length()){
                    System.out.println("The two words must be the same length.\n");
                }
                else break;

            }
            if(input_stat == false) break;

            int len = begin.length();

            // words already appeared in stacks
            HashSet wordpool = new HashSet();
            wordpool.add(begin);
            // the original word
            Stack<String> s1 = new Stack<String>();
            Queue<Stack<String>> wordladder = new LinkedList<Stack<String>>();
            s1.push(begin);
            wordladder.offer(s1);
            boolean status = false;

            while (wordladder.isEmpty()!=true){
                for(int i = 0;i<len;i++){
                    for(int j=97;j<=122; j++){
                        Stack<String> cur_stack = wordladder.peek();
                        String cur_word = cur_stack.peek();
                        String neighbor = cur_word;
                        neighbor = neighbor.substring(0,i)+(char)j+neighbor.substring(i+1);
                        if(wordpool.contains(neighbor)!=true && dic.contains(neighbor) == true) {
                            wordpool.add(neighbor);
                            if (end.equals(neighbor)) {
                                status = true;
                                //successfully find a path
                                cur_stack.push(neighbor);
                                System.out.println("A ladder from " + end + " to " + begin + ":");
                                while (cur_stack.isEmpty() != true) {
                                    System.out.println(cur_stack.peek());
                                    cur_stack.pop();

                                }
                                break;
                            }
                            else {
                                Stack<String> s = cur_stack;
                                s.push(neighbor);
                                wordladder.offer(s);
                            }
                        }

                    }

                }
                wordladder.poll();
            }
            if(status == false) {
                System.out.println("No word ladder found from " + end + " back to " + begin + ".\n");
            }
        }
        System.out.println("Have a nice day.");

        return;

	}
}
