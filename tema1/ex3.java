import java.util.Scanner;
public class ex3
{
  public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.print("n = ");
        
        int n = reader.nextInt();
        
        int  s = 0;
        for(int i=0;i<=n;i++)
        {
            if(i%3==0 || i%5==0)
            {
                s+=i;
            }
        }    
   
        System.out.println("Suma = "+s);
   }
   
}
