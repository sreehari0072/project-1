import java.util.Scanner;
class basicpay
{
    int age;
    float p,basic_pay,new_bp;
    basicpay(int age,int basic_pay)
    {
        this.age=age;
        this.basic_pay=basic_pay;
    }
    void input()
    {
        p=(age>56)?(0.2f):(age>=45&&age<=56)?(0.15f):(0.1f);
    }
    void calculate()
    {
        new_bp=basic_pay+(basic_pay*p);
    }
    void display()
    {
        System.out.println("The new basic pay is ="+new_bp);
    }
    public static void main(String[]args)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter age and basc pay"); 
        int x=in.nextInt();
        int y=in.nextInt();
        basicpay c=new basicpay(x,y);
        c.input();
        c.calculate();
        c.display();
    }

}
