package myself;

import java.util.Arrays;

public class Solution14 {

        public int[] sortArray(int[] nums) {
            int low=0,high=nums.length-1;
            quickSort(nums,low,high);
            return nums;
        }
        public void quickSort(int[] nums,int low,int high){
            if(low>high){ return; }
            int temp,start=low,end=high;
            temp=nums[low];
            while(low<high){
                while(low<high&&nums[high]>=temp){high--;}
                while(low<high&&nums[low]<=temp){low++;}
                if(low<high){
                    int p=nums[low];
                    nums[low]=nums[high];
                    nums[high]=p;
                }
            }
            nums[start]=nums[low];
            nums[low]=temp;
            quickSort(nums,start,low-1);
            quickSort(nums,low+1,end);
        }




    class Solution {
        int[] temp;
        public int[] sortArray(int[] nums) {
            int low=0,high=nums.length-1;
            temp=new int[nums.length];
            Sort(nums,low,high);
            return nums;
        }
        public void Sort(int[] nums,int start,int end){
            if(start<end){
                int mid=start+(end-start)/2;
                Sort(nums,start,mid);
                Sort(nums,mid+1,end);
                merge(nums,start,mid,mid+1,end);
            }
        }
        public void merge(int[] nums,int start1,int end1,int start2,int end2){
            int p=start1;
            int q=start2,t=0;
            while(p<=end1&&q<=end2){
                if(nums[p]<=nums[q]){
                    temp[t++]=nums[p];
                    p++;
                }
                else{temp[t++]=nums[q];q++;}
            }
            while(p<=end1){//将左边剩余元素填充进temp中
                temp[t++] = nums[p++];
            }
            while(q<=end2){//将右序列剩余元素填充进temp中
                temp[t++] = nums[q++];
            }
            t=0;
            while(start1<=end2){
                nums[start1++]=temp[t++];
            }
        }
    }


    class ListNode{
        int value;
        ListNode next;
        ListNode(int val){
            value=val;
        }
        ListNode(int val,ListNode next){
            value=val;
            this.next=next;
        }
    }
//    public class CLASS02 {
//        public ListNode Sort(ListNode head){
//            if(head==null||head.next==null){return head;}
//            ListNode temp=head;
//            ListNode findmid = findmid(temp);
//            ListNode nexthead=findmid.next;
//            findmid.next=null;
//            head=Sort(head);
//            nexthead=Sort(nexthead);
//            ListNode res=merge(head,nexthead);
//            return res;
//        }
//        public ListNode findmid(ListNode head){
//            ListNode slow=head;
//            ListNode fast=head;
//            while(fast.next!=null&&fast.next.next!=null){
//                fast=fast.next.next;
//                slow=slow.next;
//            }
//            return slow;
//        }

    ListNode findMid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;//每次走两步
            slow=slow.next;//每次走一步
        }//1 2 3 4找的是3
        return slow;
    }
//        public  ListNode merge(ListNode head1,ListNode head2){
//            ListNode dummy=new ListNode(-1);
//            ListNode head=dummy;
//            while (head1!=null&head2!=null){
//                if(head1.value<=head2.value){
//                    dummy.next=head1;
//                    dummy=head1;
//                    head1=head1.next;
//                }
//                else {
//                    dummy.next=head2;
//                    dummy=head2;
//                    head2=head2.next;
//                }
//            }
//            if(head1!=null){
//                dummy.next=head1;
//            }
//            else if(head2!=null){
//                dummy.next=head2;
//            }
//            return head.next;
//        }
//        public static void main(String[] args) {
//            ListNode head = new ListNode(5);
//            ListNode p1=new ListNode(4);
//            ListNode p2=new ListNode(1);
//            ListNode p3=new ListNode(9);
//            ListNode p4=new ListNode(0);
//            head.next=p1;
//            p1.next=p2;
//            p2.next=p3;
//            p3.next=p4;
//            ListNode sort = new CLASS02().Sort(head);
//            while(sort!=null){
//                System.out.print(sort.value);
//                sort=sort.next;
//            }
//        }
//    }


//    public class HeapSort {
//        public static void main(String []args){
//            int []arr = {7,6,7,11,5,12,3,0,1};
//            System.out.println("排序前："+ Arrays.toString(arr));
//            sort(arr);
//            System.out.println("排序前："+Arrays.toString(arr));
//        }
//
//        public static void sort(int []arr){
//            //1.构建大顶堆
//            for(int i=arr.length/2-1;i>=0;i--){
//                //从第一个非叶子结点从下至上，从右至左调整结构
//                adjustHeap(arr,i,arr.length);
//            }
//            //2.调整堆结构+交换堆顶元素与末尾元素
//            for(int j=arr.length-1;j>0;j--){
//                swap(arr,0,j);//将堆顶元素与末尾元素进行交换
//                adjustHeap(arr,0,j);//重新对堆进行调整
//            }
//
//        }
//
//        /**
//         * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
//         * @param arr
//         * @param i
//         * @param length
//         */
//        public static void adjustHeap(int []arr,int i,int length){
//            int temp = arr[i];//先取出当前元素i
//            for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
//                if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
//                    k++;
//                }
//                if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
//                    arr[i] = arr[k];
//                    i = k;
//                }else{
//                    break;
//                }
//            }
//            arr[i] = temp;//将temp值放到最终的位置
//        }
//
//        /**
//         * 交换元素
//         * @param arr
//         * @param a
//         * @param b
//         */
//        public static void swap(int []arr,int a ,int b){
//            int temp=arr[a];
//            arr[a] = arr[b];
//            arr[b] = temp;
//        }
//    }
}
