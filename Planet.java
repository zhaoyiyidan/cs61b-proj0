public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G=6.67e-11;
   
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;

    }
    public Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;


    }
    public double calcDistance(Planet p){
        double result=Math.pow(xxPos-p.xxPos, 2)+Math.pow(yyPos-p.yyPos, 2);
        return Math.sqrt(result);
    }
    public double calcForceExertedBy(Planet p){
        double distance=calcDistance(p);
        return (G*mass*p.mass)/(distance*distance);
    }
    public double calcForceExertedByX(Planet p){
        double dx=-xxPos+p.xxPos;
        return (calcForceExertedBy(p)*dx)/calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        double dy=-yyPos+p.yyPos;
        return (calcForceExertedBy(p)*dy)/calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[] arrayPlanets){
        double result = 0.0;
        for (int i=0;i<arrayPlanets.length;i++){
            if (!equals(arrayPlanets[i]))
            result+=calcForceExertedByX(arrayPlanets[i]);
        }
        return  result;
    }
    public double calcNetForceExertedByY(Planet[] arrayPlanets){
        double result = 0.0;
        for (int i=0;i<arrayPlanets.length;i++){
            if (!equals(arrayPlanets[i]))
            result+=calcForceExertedByY(arrayPlanets[i]);
        }
        return  result;
    }
    public void update(double dt,double fx,double fy){
        double acceleration_x=fx/mass;
        double acceleration_y=fy/mass;
        xxVel+=acceleration_x*dt;
        yyVel+=acceleration_y*dt;
        xxPos+=xxVel*dt;
        yyPos+=yyVel*dt;
    }
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
        StdDraw.show();
        
    }




}
	
