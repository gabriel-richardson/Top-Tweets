import twitter4j.*;
import java.util.*;

/**
 * Created by Gabriel Richardson on 4/15/2016.
 */
class Timeline {

    public LinkedHashMap<Status, Integer> timelineMap;

    public Timeline() {
        timelineMap = new LinkedHashMap<>();
    }

    public Timeline(LinkedHashMap<Status, Integer> status){
        timelineMap = status;
    }

    public void ascendingSort() {
        List<Map.Entry<Status, Integer>> list = new LinkedList<>(timelineMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Status, Integer>>() {
            @Override
            public int compare(Map.Entry<Status, Integer> o1, Map.Entry<Status, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        } );

        timelineMap.clear();
        for (Map.Entry<Status, Integer> entry : list) {
            timelineMap.put(entry.getKey(), entry.getValue());
        }
    }

    public void descendingSort() {
        List<Map.Entry<Status, Integer>> list = new LinkedList<>(timelineMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Status, Integer>>() {
            @Override
            public int compare(Map.Entry<Status, Integer> o1, Map.Entry<Status, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        } );

        timelineMap.clear();
        for (Map.Entry<Status, Integer> entry : list) {
            timelineMap.put(entry.getKey(), entry.getValue());
        }
    }

    public String print() {
        String output = "";
        for(Map.Entry<Status, Integer> entry : timelineMap.entrySet()){
            String tweet = "@" + entry.getKey().getUser().getScreenName() + " - " + entry.getKey().getText();
            Integer favorites = entry.getValue();
            output += tweet + " (" + favorites + " favorites)\n";
        }
        return output;
    }
}
