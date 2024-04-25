
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[n];
        int[] bag = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, price);
        }
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
        Arrays.sort(jewels);
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (index < n) {
                if (bag[i] < jewels[index].weight) {
                    break;
                }
                q.add(jewels[index++].price);
            }
            if (!q.isEmpty()) {
                sum += q.poll();
            }
        }
        System.out.println(sum);
    }

    static class Jewel implements Comparable<Jewel> {
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            if (this.weight == o.weight) {
                return o.price - this.price;
            }
            return this.weight - o.weight;
        }
    }
}