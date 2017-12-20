/**
 * Created by Kateryna on 06/12/2017.
 */


    class gg {

        static int search(int[] arr, int e, int l, int r){
            int res = -1;
            if(l>r){
                return res;
            }
            int mid = (r-l)/2;
            if(arr[l+mid] == e){
                return l+mid;
            } else if(arr[l+mid] > e) {
                res = search(arr, e, l, l+mid-1);
            } else {
                res = search(arr, e, l+mid+1, r);
            }
            return res;
        }
        public static void main(String args[]) {
            int[] arr = new int[]{1, 3, 5 ,6 , 8 ,11, 12, 15 ,16, 17};
            int element = 12;
            System.out.println(search(arr,element, 0, arr.length-1));
        }
    }


