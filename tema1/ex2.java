import java.util.Scanner;

public class ex2
{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.print("Input first integer: ");
        
        int a = reader.nextInt();
        
        System.out.print("Input second integer: ");
        
        int b = reader.nextInt();
        
        if(a != b)
        {
            System.out.println(a+"!="+b);
        }
    
        if(a<b)
        {
            System.out.println(a+"<"+b);
        }

        if(a<=b)
        {
            System.out.println(a+"<="+b);
        }  

    }
}
