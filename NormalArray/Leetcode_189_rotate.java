package NormalArray;

public class Leetcode_189_rotate {

//    //方法一、借助辅助数组
//    public static void rotate(int [] nums , int k){
//        int len = nums.length;
//        int [] help = new int[len];
//        for(int i = 0 ; i < len ; i++){
//            help[(i+k)%len]=nums[i];
//        }
//        nums = Arrays.copyOf(help,len);//这句代码失效了。改成for循环挨个赋值后成功ac
//    }
    public static void rotate(int[]nums,int k){
        int len = nums.length;
        if(len<=1){
            return ;
        }
        int count = 0;
        int fdx = 0;
        int pre = nums[0];
        int next = k%len;
        while(count<len){
            //交换pre和nums[(idx+k)%len]
            int tmp = nums[next];
            nums[next]=pre;
            pre=tmp;
            next = (next+k)%len;
            if(fdx==next&&fdx<k-1){
                nums[next]=pre;
                fdx++;
                next=fdx;
                pre = nums[fdx];

            }
            count++;
        }
    }


    public static void main(String[] args) {
        int k = 2;
        int [] nums = new int[]{1,2};
        rotate(nums,k);
        for(int ele : nums){
            System.out.print(ele + " ");
        }
    }

}
