
class AddMinimumLeetcode {



    public static void main(String[] args){
        AddMinimumLeetcode obj=new AddMinimumLeetcode();
        System.out.println(obj.addMinimum("aa"));
    }
    public int addMinimum(String word) {
        /*

        abccb

        a=1
        b=2
        c=2


        */
        char[] arr= word.toCharArray();
        if(word.charAt(0) == 'c'){
            return util(arr,0,new StringBuilder("ab"))+2;
        }else if( word.charAt(0) == 'b'){
            return util(arr,0,new StringBuilder("a"))+1;
        }else if(word.charAt(0) == 'a'){
            return util(arr,0,new StringBuilder(""));
        }
        return -1;

    }
    int maxValue=10000000;
    int util(char[] arr,int ind,StringBuilder sb){
        System.out.println("ind:"+ind+" "+sb);
        if(ind >= arr.length){

            if(isValid(sb.toString())){
                return 0;
            }else if(isValid(sb.toString()+"b")){
                return 0;
            }else if(isValid(sb.toString()+"c")){
                return 0;
            }else if(isValid(sb.toString()+"a")){
                return 0;
            }else{
                return maxValue;
            }
        }
        sb.append(arr[ind]);
        int len=sb.length();

        int a1= util(arr,ind+1,sb);
        sb.append('a');
        int a2= util(arr,ind+1,sb)+1;
        sb.deleteCharAt(len);
        sb.append('b');
        int a3= util(arr,ind+1,sb)+1;
        sb.deleteCharAt(len);
        sb.append('c');
        int a4= util(arr,ind+1,sb)+1;
        sb.deleteCharAt(len);

        int ans= Math.min(a1,Math.min(a2,Math.min(a3,a4)));
        return ans;
    }

    boolean isValid(String str){
        System.out.println(str);
        int ind=0;
        int n=str.length();
        if( n<3){
            return false;
        }
        while( ind+2 < n){

            if(str.charAt(ind) == 'a' && str.charAt(ind+1) == 'b'  && str.charAt(ind+2) == 'c'    ){
                ind+=3;
            }else{
                return false;
            }
        }
        return true;

    }
}
