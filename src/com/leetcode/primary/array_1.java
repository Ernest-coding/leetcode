package com.leetcode.primary;

public class array_1 {

    public static void main(String[] args) {
        int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
        int[] nums2 = {1,1,1,2};
        int[] nums3 = {1,1};
        int num = removeDuplicates_3(nums3);
        System.out.println(num);
    }

    /*
    * 第一次测试
    * 执行用时：627 ms, 在所有 Java 提交中击败了5.10% 的用户
    * 内存消耗：39.9 MB, 在所有 Java 提交中击败了26.14% 的用户
    * */
    private static int removeDuplicates_1(int[] nums){
        // 计数，看有多少个不重复元素
        int num = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int j = i+1;
            // 如果当前元素与最后一个元素相等，说明后续都是相等的，直接退出
            if(nums[i] != nums[nums.length-1]){
                // 由于静态数组无法直接删除，题目要求在原地删除，所以
                // 可以采用后续元素向前滚动的方式来模拟删除操作，最终
                // 只需要记录最后一个元素的位置即可
                while (!(nums[i]<nums[j])){
                    for(int k = j; k < nums.length-1; k++){
                        nums[k] = nums[k+1];
                    }
                }
                num++;
            }else{
                break;
            }
        }
        return num+1;
    }

    /*
    * 第二次测试
    * 执行用时：9 ms, 在所有 Java 提交中击败了5.10% 的用户
    * 内存消耗：39.7 MB, 在所有 Java 提交中击败了74.96% 的用户
    * */
    private static int removeDuplicates_2(int[] nums){
        int num = 0;
        for(int i = 0; i < nums.length-1; i++){
            // 如果当前元素与最后一个元素相等，说明后续都是相等的，直接退出
            if(nums[i] == nums[nums.length-1])
                break;
            int j = i + 1;
            while(nums[i] == nums[j]){
                // 避免极限值溢出，即数组中所有元素均相等
                if(j<nums.length-1)
                    j++;
                else
                    break;
            }
            // 此时 j-i-1 即为 i 对应的元素还有多少个重复的元素，直接覆盖就好
            int others = j - i - 1;
            for(int k = i+1; k < nums.length-others; k++){
                nums[k] = nums[k+others];
            }
            if(nums[i] != nums[i+1]){
                // 若此时判断条件为 true 则说明后续元素移动成功
                num++;
            }
        }
        return num+1;
    }

    /*
    * 第三次测试
    * 执行用时：1 ms, 在所有 Java 提交中击败了98.31% 的用户
    * 内存消耗：39.6 MB, 在所有 Java 提交中击败了85.89% 的用户
    * */
    private static int removeDuplicates_3(int[] nums){
        int num = 0;
        for(int i = 0; i < nums.length-1;){
            if(nums[i] == nums[nums.length-1])
                break;
            int j = i + 1;
            while(nums[i] == nums[j]){
                if(j < nums.length-1)
                    j++;
                else
                    break;
            }
            num++;
            nums[num] = nums[j];
            i = j;
        }
        for (int i :
                nums) {
            System.out.print(i+" ");
        }
        System.out.println();
        return num+1;
    }
}

