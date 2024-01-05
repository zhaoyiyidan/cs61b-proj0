public class NBody   {
    public static double readRadius(String name){
        In in=new In(name);
        int b=in.readInt();
        double a=in.readDouble();
        return a;
    }
    public static Planet[] readPlanets(String name){
        In in=new In(name);
        int a =in.readInt();
        Planet[] result =new Planet[a];
        double b=in.readDouble();
        for (int i=0;i<a;i++){
        result[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
    }
        return result;
    }
    public static void drawbackground(){
        StdDraw.picture(0, 0,"images/starfield.jpg");
        StdDraw.show();
    }
    public static void drawallplanets(Planet[] draw){
        for (int i=0;i<draw.length;i++){
            draw[i].draw();
            
        }
    }
    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        readRadius(filename);
        readPlanets(filename);
        StdDraw.setScale(-readRadius(filename),readRadius(filename));
        Planet[] todraw=readPlanets(filename);
        drawbackground();
        drawallplanets(todraw);
        StdDraw.enableDoubleBuffering();
        for (double time=0.0;time<T;time=time+dt){
            double[] xforce=new double[todraw.length];
            double[] yforce=new double[todraw.length];
            for (int i=0;i<todraw.length;i++){
                xforce[i]=todraw[i].calcNetForceExertedByX(todraw);
                yforce[i]=todraw[i].calcNetForceExertedByY(todraw);

            }
            for (int i=0;i<todraw.length;i++){
                todraw[i].update(dt, xforce[i], yforce[i]);
        
        }
            drawbackground();
            drawallplanets(todraw);
            StdDraw.show();
            StdDraw.pause(10);
            StdOut.printf("%d\n", todraw.length);

            StdOut.printf("%.2e\n", readRadius(filename));
            for (int i = 0; i < todraw.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  todraw[i].xxPos, todraw[i].yyPos, todraw[i].xxVel,
                  todraw[i].yyVel, todraw[i].mass, todraw[i].imgFileName);   
}
    }
        
        
        
    }
}
