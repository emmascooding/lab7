package Problem4;

import java.awt.*;

public class Node extends ListItem {
    public Node(Object value){
        super(value);
    }
    ListItem next(){
        return this.rightLink;
    }
    ListItem setNext(ListItem listitem){
        this.rightLink = listitem;
        return this.rightLink;
    }
    ListItem previous(){
        return this.leftLink;
    }
    ListItem setPrevious(ListItem listitem){
        this.leftLink = listitem;
        return this.leftLink;
    }
    int compareTo(ListItem listitem){
        if (listitem != null){
            return ((String) this.value).compareTo((String) listitem.getValue());
        }
        else{
            return -1;
        }
    }
}
