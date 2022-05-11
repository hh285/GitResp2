package myself;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution3 {
//    people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
// 7,0 7,1 6,1 5,0 5,2 4,4
//5,0 7,0 5,2 6,1 4,4 7,1
//    输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o2[0]-o1[0];//降序
                }
                else{
                    return o1[1]-o2[1];//升序
                }
            }
        });
        List<int[]> temp=new ArrayList<>();
        for (int i=0;i<people.length;i++){
            if(temp.size()<=people[i][1]){
                temp.add(people[i]);
            }
            else {
                temp.add(people[i][1],people[i]);
            }
        }
        return temp.toArray(new int[temp.size()][]);
    }
}