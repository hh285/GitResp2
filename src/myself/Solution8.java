package myself;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Solution8 {
    public float sqrt(float target){
        float left=0.0f,right=target;
        float mid=left+(right-left)/2.0f;
        float cz=0.001f;
        while(Math.abs(mid*mid-target)>cz){
            if(mid*mid<target){
                left+=0.001;
            }
            else if(mid*mid>target){
                right-=0.001;
            }
            else {
                return mid;
            }
            mid=left+(right-left)/2.0f;
        }
        return mid;
    }
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        float target=10;
//        float sqrt = new Solution8().sqrt(target);
//        System.out.println(sqrt);
        ArrayList list = new ArrayList();
        list.add("e1");
        list.add("e2");
        list.add("d");
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            String str = (String)var2.next();
            if("e1".equals(str)) {
                list.remove("e1");
            }

            if("e2".equals(str)) {
                System.out.println("element 2 fetched");
            }
        }
    }
}
