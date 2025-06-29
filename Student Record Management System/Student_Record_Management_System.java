import java.util.*;

import static java.lang.System.exit;

class Student
{
    String name;
    int id,marks;

    Student(int id,String name,int marks)
    {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }
}

class Practice
{
    static void viewall(ArrayList<Student> students){
        for( Student s : students){
            System.out.println("ID: "+s.id+" Name: "+s.name+" Marks: "+s.marks);
        }
    }
    static void searchbyID(ArrayList<Student> students,int ID){
        boolean found = false;
        for(Student s : students){
            if(s.id == ID){
                found = true;
                System.out.println("ID: "+s.id+" Name: "+s.name+" Marks: "+s.marks);
            }
        }
        if(!found) System.out.println(ID + " not found!!");
    }
    static void update(ArrayList<Student> students,int ID){
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        for(Student s : students){
            if(s.id == ID){
                found = true;
                System.out.println("\n\n1. Update Marks\n2. Update ID:");
                int choice = sc.nextInt();
                if(choice == 1){
                    System.out.println("\nEnter the marks to update: ");
                    int marks = sc.nextInt();
                    System.out.println(s.id+"'s marks updated from: "+s.marks+" to "+marks);
                    s.marks = marks;
                }
                else if(choice == 2){
                    System.out.println("\nEnter the id to update: ");
                    int id = sc.nextInt();
                    System.out.println(s.id+"'s id updated from: "+s.id+" to "+id);
                    s.id = id;
                }
                else{
                    System.out.println("INVALID!!");
                }
            }
        }
        if(!found) System.out.println(ID + " not found!!");
    }
    static void delete(ArrayList<Student> students,int ID){
        Iterator<Student> itr = students.iterator();
        boolean found = false;
        while(itr.hasNext()){
            Student s = itr.next();
            if(s.id == ID){
                found = true;
                System.out.println(s.id+" has been removed!!");
                itr.remove();break; }
        }
        if(!found) System.out.println(ID + " not found!!");
    }
    public static void main(String[] args)
    {
        int id,marks; String name;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        while(true)
        {
            System.out.println("\n-------------------STUDENT RECORD------------------------");
            System.out.println("\n\n1. Add\n2. View\n3. Update\n4. Delete\n5. Exit");
            System.out.println("\nEnter the options: ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("\nEnter Name, ID, Marks (press enter after each): "); sc.nextLine();
                    name = sc.nextLine(); id = sc.nextInt(); marks = sc.nextInt();
                    students.add(new Student(id,name,marks)); break;
                case 2:
                    if(students.size() == 0) {System.out.println("\nRECORD EMPTY!!"); break;}
                    int choice2;
                    System.out.println("\n1. View All\n2. Search by ID");
                    choice2 = sc.nextInt();
                    if(choice2 == 1) viewall(students);
                    else{
                        System.out.println("\nEnter id: ");
                        int ID = sc.nextInt();
                        searchbyID(students,ID);
                    }
                    break;
                case 3:
                    if(students.size() == 0) {System.out.println("\nRECORD EMPTY!!"); break;}
                    System.out.println("\nEnter the id: ");
                    int ID = sc.nextInt();
                    update(students,ID); break;
                case 4:
                    if(students.size() == 0) {System.out.println("\nRECORD EMPTY!!"); break;}
                    System.out.println("\nEnter the id: ");
                    ID = sc.nextInt();
                    delete(students,ID); break;
                case 5:
                    System.out.println("EXITING.......");
                    exit((1));
            }

        }
    }
}
