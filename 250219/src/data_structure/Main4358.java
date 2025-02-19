package data_structure;
import java.io.*;
import java.util.*;

// 4358 생태학 
public class Main4358 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> treeCount = new HashMap<>();
        int total = 0;
        
        String tree;
        while ((tree = br.readLine()) != null && !tree.isEmpty()) {
            treeCount.put(tree, treeCount.getOrDefault(tree, 0) + 1);
            total++;
        }

        List<String> trees = new ArrayList<>(treeCount.keySet());
        // 사전순 정렬
        Collections.sort(trees); 

        StringBuilder sb = new StringBuilder();
        for (String t : trees) {
            double percentage = (treeCount.get(t) * 100.0) / total;
            sb.append(t).append(" ").append(String.format("%.4f", percentage)).append("\n");
        }

        System.out.print(sb);
    }
}
