import java.util.LinkedList;

public class MyStack {
    private static class Zelle {
        private Object o;
        private Zelle z;
        private int num;

        public Zelle (Object o, Zelle z,int num){
            this.o=o;
            this.z=z;
            this.num=num;
        }

        public Zelle getZ() {
            return z;
        }

        public Object getO() {
            return o;
        }

        public int getNum() {
            return num;
        }

        public String stringGen(){
            String x="";
            while(z!=null){
                x+=z.stringGen();
            }
            String s=o.toString()+x;
            return s;
        }
    }

    private Zelle anfang;

    public Object push(Object o){
        if(anfang==null){
            anfang=new Zelle(o,null,1);
            return anfang;
        }
        Zelle z0 = new Zelle(o,anfang, anfang.getNum()+1);
        anfang=z0;
        return z0;
    }
    public Object pop(){
        if(anfang!=null) {
            Object z0 = anfang.getO();
            anfang = anfang.getZ();
            return z0;
        }
        return null;
    }
    public Object peek(){
        return anfang;
    }

    public int size(){
        return anfang.getNum();
    }
    public String toString(){
        return anfang.stringGen();
    }
}
