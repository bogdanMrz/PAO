import java.util.Scanner;
public class ex4_7
{
    
    
    public static int factorial(int n){
        if(n == 0)
            return 1;
        
        int i = 1;
        int fact = 1;
        while(i <= n){
            fact *= i;
            i ++;
        
        }
        return fact;
    }
    public static boolean prim(int n){
        
        if(n%2 == 0)
            return false;
        
            
        for(int i=3;i<n/2;i++)
        {
            if(n%i == 0)
                return false;
        }
        
        return true;
    }
    
    public static int fact_prim(int n)
    {
        for(int i=n;i>=2;i--)
        {
            if(n%i==0 && prim(i))
                return i;
        }
        
        return -1;
    
    }
    
    public static int fibonacci(int n)
    {
        if(n == 1 || n == 2)
            return 1;
            
        int a = 1;
        int b = 1;
        
        for(int i=3;i<=n;i++)
        {
            int aux = a + b;
            a = b;
            b = aux;
        }
        
        return b;
        
    }
    public static void main(String[] args){
          Scanner reader = new Scanner(System.in);
          System.out.print("n = ");
        
          int n = reader.nextInt();
          
          System.out.print("Fibonacci = "+fibonacci(n)); 
          

    }
    
}
