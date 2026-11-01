package Problem1;

public class Building implements Mappable{
    private String name;
    private UsageType type;

    public static void mapIt(Mappable mappable){
        System.out.println(mappable.toJSON());
    }

    public Geometry getShape(){
        return Geometry.POINT;
    }
    public String getMarker(){
        return String.format("""
                "marker": "%s %s""", Color.RED, PointMarkers.STAR);
    }
    public String getLabel(){
        return String.format("""
                "label": "%s (%s)""",name, type);

    }
    public String toJSON(){
        return String.format(JSON_PROPERTY, """
                type": """+getShape()+", "+getLabel()+getMarker())+String.format("""
                "name": "%s", "usage": "%s""",this.name, this.type);
    }
}
