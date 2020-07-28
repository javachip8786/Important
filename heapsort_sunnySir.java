
//public class heapsort_sunnySir {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}


import java.util.*;
class heapsort_sunnySir{


    static ArrayList<Integer> ans=new ArrayList<>();
    static boolean nature=true;

   

   static void PriorityQue(int[] arr,boolean max){
        nature=max;
        
        for(int i=arr.length-1;i>=0;i--){
            downheapify(arr,i,arr.length-1);
        }
    //   System.out.println(Arrays.toString(arr));
    
    for(int i=0;i<arr.length;i++){
        // System.out.println(Arrays.toString(arr));
        swap(arr, 0, arr.length-i-1);
        downheapify(arr, 0,arr.length-i-1);
    }
    // System.out.println(Arrays.toString(arr));

    }

   static void downheapify(int[] arr,int pri,int range){
        int copypri=pri;
        int lchi=(2*pri+1);
        int rchi=(2*pri+2);

        if(lchi<range && higherpriority(arr[lchi],arr[copypri])){
              copypri=lchi;
            }
        if(rchi<range && higherpriority(arr[rchi],arr[copypri])){
                copypri=rchi;
                

        }

        if(pri!=copypri){
           swap(arr,copypri, pri);
           downheapify(arr,copypri,range);

        }

    }

    
    static void swap(int[] arr,int chi,int pri){
        int temp=arr[chi];
        arr[chi]=arr[pri];
        arr[pri]=temp;

    }

    
    static boolean higherpriority(int chval,int prval){
        if(nature){
            if(chval>prval){
                return true;
            }else{   
                return false;
            }

        }
        else{
            if(chval<prval){
                return true;
            }else{
                return false;
            }
        }
    }


    public static void main(String[] args){
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
        PriorityQue(arr, true);
    }

}