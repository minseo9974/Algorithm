
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[n+1];
            Student[] students = new Student[m];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(students);
            int sum = 0;
            for (Student s : students) {
                for (int i = s.a; i <=s.b ; i++) {
                    if (!visited[i]) {
                        visited[i]=true;
                        sum++;
                        break;
                    }
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);


    }
}

class Student implements Comparable<Student>{
    int a;
    int b;

    public Student(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Student o) {
        return this.b - o.b;
    }
}