import java.util.Scanner;

class basicpay
{
    int age;
    float p, basic_pay, new_bp;

    basicpay(int age, float basic_pay)
    {
        this.age = age;
        this.basic_pay = basic_pay;
    }
    
    void process()
    {
        p = (age > 56) ? 0.2f : (age >= 45 && age <= 56) ? 0.15f : 0.1f;
    }

    void process(float percentage)
    {
        this.p = percentage;
        new_bp = basic_pay + (basic_pay * p);
    }


    void process()
    {
        System.out.println("The new basic pay is = "+ new_bp);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter age and basic pay"); 
        int x = in.nextInt();
        float y = in.nextFloat();  

        basicpay c = new basicpay(x, y);

        c.process();          
        c.process(c.p);        
        c.process();  
    }
}
