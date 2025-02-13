package implementation;
import java.io.*;
import java.util.*;

// 22860 폴더 정리 (small)
public class Main22860 {
    // 폴더 구조를 저장할 맵 
	// 키는 폴더명, 값은 해당 폴더 내 항목 (파일 및 하위 폴더) 목록
    static Map<String, List<String>> folderStructure = new HashMap<>();
    // 각 항목이 폴더인지 파일인지 구분할 맵
    // 키는 항목명, 값은 폴더인지 파일인지 여부 (true=폴더, false=파일)
    static Map<String, Boolean> isDirectory = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 폴더 개수
        int numFolders = Integer.parseInt(st.nextToken());
        // 파일 개수
        int numFiles = Integer.parseInt(st.nextToken());

        // 파일 및 폴더 정보 저장
        for (int i = 0; i < numFolders + numFiles; i++) {
            st = new StringTokenizer(br.readLine());
            // 부모 폴더의 이름
            String parent = st.nextToken();
            // 자식 폴더 또는 파일의 이름
            String child = st.nextToken();
            // 자식이 폴더인지 파일인지 (1=폴더, 0=파일)
            int type = Integer.parseInt(st.nextToken());

            // 부모 폴더에 자식 폴더/파일을 추가
            folderStructure.putIfAbsent(parent, new ArrayList<>());
            folderStructure.get(parent).add(child);
            
            // 자식 항목이 폴더인지 파일인지 구분하여 저장
            // 1이면 폴더, 0이면 파일
            isDirectory.put(child, type == 1);
        }

        int numQueries = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 쿼리 처리
        for (int i = 0; i < numQueries; i++) {
            String query = br.readLine();
            // 경로를 '/'를 기준으로 나누어서 각 폴더로 탐색
            String[] pathParts = query.split("/");

            // 'main' 폴더부터 시작하여, '/' 이후 경로를 따라가면서 폴더를 탐색
            String currentFolder = "main";
            for (int j = 1; j < pathParts.length; j++) {
                currentFolder = pathParts[j];
            }

            // 파일 개수 및 종류 계산
            // 중복 파일을 방지하기 위한 Set
            Set<String> uniqueFiles = new HashSet<>();
            int totalFileCount = countFiles(currentFolder, uniqueFiles);

            sb.append(uniqueFiles.size()).append(" ").append(totalFileCount).append("\n");
        }

        System.out.print(sb);
    }

    // DFS로 폴더 내 파일 개수 계산
    private static int countFiles(String folder, Set<String> uniqueFiles) {
        // 폴더가 비어있는 경우
        if (!folderStructure.containsKey(folder)) return 0;

        int totalCount = 0;
        
        // 현재 폴더 내 항목들(파일 및 하위 폴더)을 순차적으로 탐색
        for (String item : folderStructure.get(folder)) {
            if (isDirectory.getOrDefault(item, false)) {
            	// 폴더인 경우, 재귀적으로 하위 폴더를 탐색
                totalCount += countFiles(item, uniqueFiles);
            } else {
            	// 파일인 경우, 고유한 파일 목록에 추가하고 파일 개수 증가
                uniqueFiles.add(item);
                totalCount++;
            }
        }

        return totalCount;
    }
}
