package Problem1;

import javax.sound.sampled.Line;

public class UtilityLine implements Mappable{
    private String name;
    private UtilityType type;

    public static void mapIt(Mappable mappable){
        System.out.println(mappable.toJSON());
    }

    public Geometry getShape(){
        return Geometry.LINE;
    }
    public String getMarker(){
        return String.format("""
                "marker": "%s %s,""", Color.GREEN, LineMarkers.DOTTED);
    }
    public String getLabel(){
        return String.format("""
                "label": "%s (%s),""",name, type);

    }
    public String toJSON(){
        return String.format(JSON_PROPERTY, """
                type": """+getShape()+", "+getLabel()+getMarker())+String.format("""
                "name": "%s", "usage": "%s""",this.name, this.type);
    }
}
