import java.io.*;
import java.util.Scanner;

import static java.lang.System.exit;

class Practice
{
    public static void readFile(String name)
    {
        if (name.trim().isEmpty()) {
            System.out.println("Invalid file name.");
            return;
        }
        File f = new File(name);
        if(f.exists()) {
            try {
                System.out.println("\nREADING FROM: " + name +"\n");
                FileReader fr = new FileReader(name);
                BufferedReader bf = new BufferedReader(fr);
                String line;
                while ((line = bf.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("\nREADING FINISHED!");
                bf.close();
            } catch (IOException e) {
                System.out.println(e + e.getMessage());
            }
        }
        else{
            System.out.println("FILE DOES NOT EXISTS!!");
        }
    }
    public static void writeFile(String name)
    {
        if (name.trim().isEmpty()) {
            System.out.println("Invalid file name.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        try
        {
            File f = new File(name);
            if(f.createNewFile())
            {
                System.out.println("FILE CREATED!!");
            }
            else
            {
                System.out.println("FILE ALREAD EXISTS!!");
            }
            FileWriter fw = new FileWriter(name,true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("\nEnter the text to add (type exit to finish) : ");
            while(true)
            {
                String line = sc.nextLine();
                if(line.equalsIgnoreCase("exit")) break;
                bw.write(line);
                bw.newLine();
            }
                System.out.println("Successfully written"); bw.close();
        }
        catch(IOException e)
        {
            System.out.println(e + e.getMessage());
        }
    }
    public static void viewFiles(String name)
    {
        if (name.trim().isEmpty()) {
            System.out.println("Invalid file name.");
            return;
        }
        File currentDir = new File(name);
        String[] filesList = currentDir.list();
        System.out.println("\n--- Files and directories in current folder ---");
        if (filesList == null) {
            System.out.println("Invalid directory or access denied!");
            return;
        }
        for (String Name : filesList) {
            System.out.println(Name);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("\n\n------------------NOTES MANAGER---------------\n\n");
            System.out.println("\n1. READ\n2. WRITE\n3. VIEW FILES\n4. EXIT");
            System.out.println("\nENTER THE OPTION: ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("\nEnter the file name with path: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    readFile(name); break;
                case 2:
                    System.out.println("\nEnter the file name with path: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    writeFile(name); break;
                case 3:
                    System.out.println("\nEnter the directory: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    viewFiles(name); break;
                case 4:
                    System.out.println("\nEXITING......"); exit(1);
            }
        }
    }
}
