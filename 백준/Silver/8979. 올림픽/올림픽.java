
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Olimpic[] olimpics = new Olimpic[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            olimpics[i] = new Olimpic(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(olimpics);
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (k == olimpics[i].index) {
                System.out.println(cnt);
                return;
            }
            if (i != n-1 && olimpics[i].isEqual(olimpics[i + 1])) {
                continue;
            }
            cnt++;
        }
    }
}

class Olimpic implements Comparable<Olimpic> {
    int index;
    int gold;
    int silver;
    int bronze;

    public Olimpic(int index, int gold, int silver, int bronze) {
        this.index = index;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public boolean isEqual(Olimpic olimpic) {
        if (this.gold == olimpic.gold && this.silver == olimpic.silver && this.bronze == olimpic.bronze) {
            return true;
        }
        return false;
    }


    @Override
    public int compareTo(Olimpic o) {
        if (this.gold == o.gold) {
            if (this.silver == o.silver) {
                return o.bronze - this.bronze;
            }
            return o.silver - this.silver;
        }
        return o.gold - this.gold;
    }
}