import java.util.Scanner;

class basicpay
{
    int age;
    float p, basic_pay, new_bp;

    // Constructor
    basicpay(int age, float basic_pay)
    {
        this.age = age;
        this.basic_pay = basic_pay;
    }

    // Overloaded method 1: calculate percentage p
    void process()
    {
        p = (age > 56) ? 0.2f : (age >= 45 && age <= 56) ? 0.15f : 0.1f;
    }

    // Overloaded method 2: calculate new basic pay using p
    void process(float percentage)
    {
        this.p = percentage;
        new_bp = basic_pay + (basic_pay * p);
    }

    // Overloaded method 3: display result
    void process(String msg)
    {
        System.out.println(msg + new_bp);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter age and basic pay"); 
        int x = in.nextInt();
        float y = in.nextFloat();  // changed to float so basic_pay can have decimals

        basicpay c = new basicpay(x, y);

        c.process();           // calls process() -> sets p
        c.process(c.p);        // calls process(float) -> calculates new_bp
        c.process("The new basic pay is = ");  // calls process(String) -> displays
    }
}
