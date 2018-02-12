import java.util.*;

public class Quiz2 {

   private static boolean IsInLanguage(String ip)
   {
   
       
         int numOfAs = 1, numOfBs = 2;
        
         int i;
         for ( i = 0; i<ip.length(); i++)    {
             System.out.println(ip.charAt(i));
           
             if (ip.charAt(i) == 'A' )
                 numOfAs++;
             if (ip.charAt(i) == 'B' )
                 numOfBs++;
           
             // end if
         } // end for loop
           
         // string.charat(number)
       
         String newIp; // new Input string
         newIp = ip.substring(numOfAs);
         IsInLanguage(newIp);
       
                 if ( numOfBs == numOfAs * 2)
              return true;
         else
             return false;

      
     } // end recur function

    
     public static void main(String[] args) {
      
         Scanner sc = new Scanner(System.in);
         String ip = " ";
         ip = sc.next(); 
       
         if ( IsInLanguage(ip))
             System.out.println("Congrats, The string is found in the language");
         else
             System.out.println("Sorry, The string is not found in the language") ;         
       
       
             // call the function pass the ip as parameter
        
       
       
       
     } // end main
   
 } // end public class



