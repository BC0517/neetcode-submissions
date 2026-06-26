class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Merge the arrays, find the center point, if the merged array is even find the 2 center points and find the average

        //Step 1: Create an array the size of both arrays, insert smallest first
        int totalSize = nums1.length + nums2.length;
        int[] merged = new int[totalSize];

        /*
        Mistake: Didn't create pointers for both arrays
        This meant when both values were checked it would skip to the next index instead of checking for the smallest value
        */ 
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        int num = 0;
        while (p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] <= nums2[p2]){
                merged[i] = nums1[p1++];
            } else {
                merged[i] = nums2[p2++];
            }
            i++;
        }
        while (p1 < nums1.length){
            merged[i++] = nums1[p1++];
        } 
        while (p2 < nums2.length){
            merged[i++] = nums2[p2++];
        }
        for(int val: merged){
            System.out.print(val + " ");
        }

        //Step 2: Look for the median in the array
        /*
        Mistake: Tried to overcomplicate calculation of mid points for even length arrays
        */
        int n = merged.length;
        //If array is odd then return middle value
        if(n % 2 != 0){
            return merged[n/2];
        }
        //If array is even return the average of the 2 middle values
        int l = (n / 2) - 1;
        int r = n / 2;
        return (double) (merged[l] + merged[r]) / 2;
    }
}