public class TestPlanet {
    
    public static void main(String[] args){
        Planet planet1=new Planet(1.0,2.0,3.0,4.0,5.0,"6.0");
        Planet planet2=new Planet(2.0,3.0,4.0,5.0,6.0,"70");
    System.out.print(planet1.calcForceExertedBy(planet2));
    }
    
}
