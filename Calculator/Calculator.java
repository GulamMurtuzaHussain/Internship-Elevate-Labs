import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

class Practice
{
        static int n = 0;
        static Scanner sc = new Scanner(System.in);
    static double addition(List<Double> numbers){
        double sum = 0;
        for(int i=0;i<n;i++){
            sum += numbers.get(i);
        }
        return sum;
    }
    static double substract(List<Double> numbers){
        Double sub = numbers.get(0);
        for(int i=1;i<n;i++){
            sub -= numbers.get(i);
        }
        return sub;
    }
    static double multiplication(List<Double> numbers){
        double mul = 1;
        for(int i=0;i<n;i++){
            mul *= numbers.get(i);
        }
        return mul;
    }
    static double division(List<Double> numbers){
        double div = numbers.get(0);
        for(int i=1;i<n;i++){
            if(numbers.get(i)==0){
                System.out.println("\nDivide by 0 error!!"); return Double.NaN;
            }
            div /= numbers.get(i);
        }
        return div;
    }
    static List<Double> numbers(int n){
        List<Double> l = new ArrayList<>();
        System.out.println("\nEnter the operand(s): ");
        for(int i=0;i<n;i++) l.add(sc.nextDouble());
        return l;

    }
    public static void main(String[] args){
        double total = 0;
        List<Double> l = new ArrayList<>();
        System.out.println("-------------CALCULATOR----------------");
        while(true){
            System.out.println("\n1. Addition \n2. Substraction \n3. Multiplication\n4. Division\n5. Reset \n6. Exit");
            System.out.println("\n\nEnter the operation: ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("\nEnter the number of Operand(s)");
                    n = sc.nextInt();
                    l = numbers(n);
                    total += addition(l);
                    System.out.printf("\nComputed: %.2f",total); break;
                case 2:
                    System.out.println("\nEnter the number of Operand(s):");
                    n = sc.nextInt();
                    l = numbers(n);
                    total -= substract(l);
                    System.out.printf("\nComputed: %.2f",total); break;
                case 3:
                    System.out.println("\nEnter the number of Operand(s):");
                    n = sc.nextInt();
                    l = numbers(n);
                    total *= multiplication(l);
                    System.out.printf("\nComputed: %.2f",total); break;
                case 4:
                    System.out.println("\nEnter the number of Operand(s):");
                    n = sc.nextInt();
                    l = numbers(n);
                    double res = division(l);
                    if(!Double.isNaN(res)){
                        total /= res;
                        System.out.printf("\nComputed: %.2f",total); break;
                    }
                    else{
                        System.out.println("\nDivision Aborted!!");
                    }
                case 5:
                    total = 0; l.clear(); break;
                case 6:
                    System.out.println("\n\nExiting....");exit(0);
                default:
                    System.out.println("\nInvalid Input!!");
            }
        }
    }
}
