import java.io.*;
import java.util.*;

public class StudentCSV {

    static String fileName = "file.csv";

    public static void main(String[] args) {
        try {
            addStudents();
            updateMarks();
            calculatePercentage();
            deleteStudent(2);
            displayFile();
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    public static void addStudents() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

        bw.newLine();
        bw.write("3,Rohan,CS,50,55,60,0,0,0");

        bw.newLine();
        bw.write("4,Neha,AI,80,85,90,0,0,0");

        bw.newLine();
        bw.write("5,Karan,IT,65,70,75,0,0,0");

        bw.close();
        System.out.println("Added 3 students");
    }

    public static void updateMarks() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = br.readLine()) != null) {

            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");

            if (data.length == 9 && !data[0].equals("studentId")) {
                data[6] = "80";
                data[7] = "85";
                line = String.join(",", data);
            }

            lines.add(line);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : lines) {
            bw.write(l);
            bw.newLine();
        }
        bw.close();

        System.out.println("Marks updated");
    }

    public static void calculatePercentage() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = br.readLine()) != null) {

            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");

            if (data.length == 9 && !data[0].equals("studentId")) {
                int total = 0;

                for (int i = 3; i <= 7; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double percentage = total / 5.0;
                data[8] = String.valueOf(percentage);

                line = String.join(",", data);
            }

            lines.add(line);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : lines) {
            bw.write(l);
            bw.newLine();
        }
        bw.close();

        System.out.println("Percentage calculated");
    }

    public static void deleteStudent(int id) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = br.readLine()) != null) {

            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");

            if (data.length == 9) {
                if (data[0].equals("studentId") || Integer.parseInt(data[0]) != id) {
                    lines.add(line);
                }
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : lines) {
            bw.write(l);
            bw.newLine();
        }
        bw.close();

        System.out.println("Deleted student with ID: " + id);
    }

    public static void displayFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        System.out.println("\nFinal Data:");
        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                System.out.println(line);
            }
        }

        br.close();
    }
}