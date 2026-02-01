
public class AreaCalculator {
    public static double calculateArea(double square){
        double result = square*square;
        double roundedResult = Math.round(result*100.0)/100.0;
        return roundedResult; 
    }

    public static double calculateArea(double height, double length){
        double result = height*length;
        result = Math.round(result*100.0)/100.0;
        return result;
    }
    public static double calculateArea(double radius, boolean isValid){
        if(radius == 0){
            return 0.0;
        }
        if(!isValid){
            return Double.NaN;
        }
        double area = Math.PI*radius*radius;

        area = Math.round(area*100.0)/100.0;

        return area;

    }
}