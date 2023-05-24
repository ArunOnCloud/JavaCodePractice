public class UseOfFinally {


    public static void main(String[] args)throws Exception{

        try {
            div(21,0);
        }catch (Exception e){
            System.out.println("Division");
        }

    }

    static  int div(int a,int b){
        try {
            return a/b;
        }finally {
            System.out.println("finally");
        }
    }
}
