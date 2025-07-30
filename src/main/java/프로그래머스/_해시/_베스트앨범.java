package 프로그래머스._해시;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class _베스트앨범 {

    static class Song{
        int idx;
        int playCnt;

        Song(int idx, int playCnt){
            this.idx = idx;
            this.playCnt = playCnt;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, List<Song>> map = new HashMap<>();
        Map<String, Integer> genreTotal = new HashMap<>();

        for(int i=0; i<genres.length; i++) {
            if(!map.containsKey(genres[i])) map.put(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new Song(i, plays[i]));
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> genreOrder = genreTotal.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> albumSongIdxs = new ArrayList<>();
        for(String genre : genreOrder) {
            List<Song> songs = map.get(genre);
            songs.sort(
                    (o1, o2) -> {
                        if(o2.playCnt != o1.playCnt) return o2.playCnt - o1.playCnt;
                        else return o1.idx - o2.idx;
                    }
            );

            albumSongIdxs.add(songs.get(0).idx);
            if(songs.size() > 1) albumSongIdxs.add(songs.get(1).idx);
        }

        return albumSongIdxs.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] genres = br.readLine().replace("[","")
                                    .replace("]","")
                                    .replace("\"","")
                                    .replace(" ","")
                                    .split(",");
        for (int i = 0; i < genres.length; i++) {
            genres[i] = genres[i].trim();
        }

        String[] strPlays = br.readLine().replace("[","")
                                        .replace("]","")
                                        .replace(" ","")
                                        .split(",");

        int[] plays = new int[strPlays.length];
        for (int i = 0; i < strPlays.length; i++) {
            plays[i] = Integer.parseInt(strPlays[i].trim());
        }

        System.out.println(Arrays.toString(solution(genres, plays)));

        br.close();
    }
}
