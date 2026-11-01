package Problem4;

public class SearchTree {
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }
    public ListItem getRoot() {
        return this.root;
    }
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = null;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if (item.previous() == null) {
            if (parent != null) {
                if (parent.next() == item) {
                    parent.setNext(item.next());
                } else if (parent.previous() == item) {
                    parent.setPrevious(item.next());
                }
            } else {
                this.root = item.next();
            }
        } else if (item.next() == null) {
            if (parent != null) {
                if (parent.next() == item) {
                    parent.setNext(item.previous());
                } else if (parent.previous() == item) {
                    parent.setPrevious(item.previous());
                }
            } else {
                this.root = item.previous();
            }
        } else {
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            item.setValue(current.getValue());
            performRemoval(current, leftmostParent);
        }
    }
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
