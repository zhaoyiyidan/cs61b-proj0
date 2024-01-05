public class k {
    public static void main(String[] args) {
        // Given string
       In in=new In("filefi.txt");
       int a=in.readInt();
       Planet[] array =new Planet[a];
       double b =in.readDouble();
        for (int i=0;i<a;i++){
            array[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        System.out.println(array[0].imgFileName);
        }
    }

