package Problem1;

public interface Mappable {
    String JSON_PROPERTY = """
            "properties":{%s}""";

    static void mapIt(Mappable mappable){
        System.out.println(mappable.toJSON());
    }
    String getLabel();
    String getMarker();
    Geometry getShape();

    default String toJSON(){
        return String.format(JSON_PROPERTY, getShape()+getLabel()+getMarker());
    }
}