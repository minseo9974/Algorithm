
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
        int n = Integer.parseInt(br.readLine());
        Station[] stations = new Station[n];
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stations[i] = new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(stations);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalDistance = Integer.parseInt(st.nextToken());
        long originGas = Long.parseLong(st.nextToken());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && originGas < stations[i].distance) {
                originGas += q.poll();
                cnt++;
            }
            if (originGas < stations[i].distance) {
                System.out.println(-1);
                return;
            }
            q.add(stations[i].gas);
        }
        while (!q.isEmpty() && originGas < totalDistance) {
            originGas += q.poll();
            cnt++;
        }
        if (originGas >= totalDistance) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
}

class Station implements Comparable<Station> {
    int distance;
    int gas;

    public Station(int distance, int gas) {
        this.distance = distance;
        this.gas = gas;
    }

    @Override
    public int compareTo(Station o) {
        return this.distance - o.distance;
    }
}