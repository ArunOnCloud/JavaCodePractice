public class UnicommerceTest {

    /*

    {3, 34, 4, 12, 5, 2},
    sum = 9
o/p : true

fun(arr,sum,ind)  :     sum == 0 return true
                         return false         ind<0
                      fun( arr,sum - arr[ind],ind-1) || fun(arr,sum,ind-1)


                      n *sum
     */

    public static void main(String[] args) {
        UnicommerceTest unicommerceTest = new UnicommerceTest();

        int[] arr = new int[]{3, 34, 4, 12, 5, 2};
        System.out.println(unicommerceTest.isSubsetPresent(arr,9));
        System.out.println(unicommerceTest.isSubsetPresent(arr,38));
        System.out.println(unicommerceTest.isSubsetPresent(arr,39));
        System.out.println(unicommerceTest.isSubsetPresent(arr,40));
        System.out.println(unicommerceTest.isSubsetPresent(arr,100));

        Shape rectangleWithRed = new Rectangle(new Red());

        Shape rectangleWithBlue = new Rectangle(new Blue());
        System.out.println(rectangleWithBlue.drawShape());
        System.out.println(rectangleWithRed.drawShape());
    }

    boolean isSubsetPresent(int[] arr,int sum){
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];

        return util(arr,n-1,sum,dp);
    }

    /*

     */

    boolean util( int[] arr,int ind,int sum,Boolean[][] dp){
        // 3,33
        if( sum == 0){
            return true;
        }
        if( sum < 0){
            return false;
        }
        if( ind <0){
            return false;
        }
        if( dp[ind][sum] != null){
            return dp[ind][sum];
        }
        // sum  40 ind =5, 2
        boolean taken = util(arr,ind-1,sum - arr[ind] ,dp); // ind =4, 38, 3,33, 2,21, 1,17, 0,-17
        boolean skipped = util(arr,ind -1,sum,dp);//
        dp[ind][sum] = taken || skipped;
        return dp[ind][sum];
    }
}

abstract  class Shape{
     abstract  String  drawShape();
     Color color;
     Shape(Color color){
         this.color = color;
    }


}

interface  Color{
    String applyColor();
}
class Rectangle extends Shape {

    @Override
    String drawShape() {
        return " Rectangle with color "+ color.applyColor() ;
    }
    public Rectangle(Color color){
        super(color);
    }
}
class  Red implements Color{
    public String applyColor(){
        return "Red";
    }
}
class Blue implements Color{
    public String applyColor(){
        return "Blue";
    }
}
