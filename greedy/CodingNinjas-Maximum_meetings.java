// https://www.codingninjas.com/codestudio/problems/1062658?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
import java.util.*;

public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) { 
        ArrayList<Meeting> meets = new ArrayList();
        List<Integer> res = new ArrayList();
        
        for(int i = 0; i < start.length; i++){
            meets.add(new Meeting(start[i], end[i], i + 1));
        }
        
        MeetComparator comparator = new MeetComparator();
        Collections.sort(meets, comparator);
        
        res.add(meets.get(0).pos);
        int endTime = meets.get(0).end;
        for(Meeting meet: meets){
            if(meet.start <= endTime) continue;
            
            res.add(meet.pos);
            endTime = meet.end;
        }
        
        return res;
    }
}
class Meeting {
    int start, end, pos;
    Meeting(int start,int end,int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetComparator implements Comparator<Meeting>{
    @Override
    public int compare(Meeting m1, Meeting m2){
        if(m1.end < m2.end) return -1;
        else if(m1.end > m2.end) return 1;
        else if(m1.pos < m2.pos) return -1;
        else return 1;
    }
}
