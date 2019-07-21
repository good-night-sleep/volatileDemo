import java.util.concurrent.TimeUnit;

class MyData {

    volatile int num=0;
    public void numTo60(){
        num=60;
    }
}

class VolatileDemo{
    public static void main(String[] args){
        MyData myDate=new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\tcome in");
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            myDate.numTo60();
            System.out.println(Thread.currentThread().getName()+"\t update" + myDate.num);

        },"aaa").start();

        while (myDate.num==0){

        }

        System.out.print(Thread.currentThread().getName()+"aaaaaa"+myDate.num);
    }

}