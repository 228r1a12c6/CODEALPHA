import java.util.Scanner;

public class Task1{
    public static void main(String[]args){
        System.out.println("STUDENT GRADE TRACKER");
        Scanner s =new Scanner(System.in);
        System.out.println( "Enter the total number of students :");
        int totalstudents=s.nextInt();
        int  [] marks =new int[totalstudents];
        for(int i=0;i<totalstudents;i++) {
            System.out.println("Enter marks of student " + (i + 1) + ":");//this statement is used because we have to print marks of every student separately that is one after the other
            marks[i]=s.nextInt();
        }
        float Average=0;
        for(int i=0;i<totalstudents;i++){
            Average+=marks[i];
        }
        System.out.println("Average Score in Class is :"+Average/totalstudents);
        int Highest =0;
        for(int i=0;i<totalstudents;i++){
            if( marks[i]>Highest){
                Highest=marks[i];
            }
        }
        System.out.println("Highest Score in Class is : "+Highest);
        int lowest=marks[0];
        for(int i=0;i<totalstudents;i++){
            if(marks[i]<lowest) {
                lowest = marks[i];
            }
        }
        System.out.println("Lowest Score in Class is: "+lowest);
    
    s.close();
    }
}