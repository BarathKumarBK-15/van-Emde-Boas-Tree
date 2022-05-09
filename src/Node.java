import java.lang.Math.*;

public class Node {
    public int universe_size;
    public  int min;
    public int max;
    public Node summary;
    public Node[] children;
    public boolean is_summary;
    public int range_min;
    public int range_max;

    Node() {
        universe_size = 0;
        min = -1;
        max = -1;
        summary = null;
        children = null;
        is_summary = false;
        range_max = -1;
        range_min = -1;

    }

    Node(int universe_size) {
        this.universe_size = universe_size;
        this.min = -1;
        this.max = -1;
        this.is_summary = false;
        this.range_min = 0;
        this.range_max = this.universe_size - 1;

        if(universe_size == 2) {
            this.summary = null;
            this.children = null;

        } else {
            this.children = new Node[higherSQRT(universe_size)];
            this.summary = new Node(higherSQRT(universe_size), true);

            for(int i = 0; i < higherSQRT(universe_size); i++) {
                int r_min = lowerSQRT(this.universe_size) * i + this.range_min;
                int r_max = lowerSQRT(this.universe_size) * (i + 1) + this.range_min - 1;
                children[i] = new Node(lowerSQRT(universe_size), r_min, r_max);

            }
        }
    }

    Node(int universe_size, int range_min, int range_max) {
        this.universe_size = universe_size;
        this.min = -1;
        this.max = -1;
        this.is_summary = false;
        this.range_min = range_min;
        this.range_max = range_max;

        if(universe_size == 2) {
            this.summary = null;
            this.children = null;

        } else {
            this.children = new Node[higherSQRT(universe_size)];
            this.summary = new Node(higherSQRT(universe_size), true);

            for(int i = 0; i < higherSQRT(universe_size); i++) {
                int r_min = lowerSQRT(this.universe_size) * i + this.range_min;
                int r_max = lowerSQRT(this.universe_size) * (i + 1) + this.range_min - 1;
                children[i] = new Node(lowerSQRT(universe_size), r_min, r_max);

            }
        }

    }

    Node(int universe_size, boolean is_summary) {
        this.universe_size = universe_size;
        this.min = -1;
        this.max = -1;
        this.is_summary = is_summary;
        this.range_min = 0;
        this.range_max = this.universe_size - 1;

        if(universe_size == 2) {
            this.summary = null;
            this.children = null;
        } else {
            this.children = new Node[higherSQRT(universe_size)];
            this.summary = new Node(higherSQRT(universe_size), true);

            for(int i = 0; i < higherSQRT(universe_size); i++) {
                int r_min = lowerSQRT(this.universe_size) * i + this.range_min;
                int r_max = lowerSQRT(this.universe_size) * (i + 1) + this.range_min - 1;
                children[i] = new Node(lowerSQRT(universe_size), r_min, r_max);

            }
        }

    }

    public int higherSQRT(int x) {
        double temp = Math.log(x)/Math.log(2);
        temp = Math.ceil(temp/2);
        return (int)Math.pow(2, temp);

    }

    public int lowerSQRT(int x) {
        double temp = Math.log(x)/Math.log(2);
        temp = Math.floor(temp/2);
        return (int)Math.pow(2, temp);

    }

    public String toString() {
        String s1 = "\n========================================\n\n";
        String s2 = "Universe Size : " + this.universe_size + "\n";
        String s3 = "Minimum Value : " + this.min + "\n";
        String s4 = "Maximum Value : " + this.max + "\n";
        String s5 = "0";

        if(this.children != null) {
            s5 = "Number of children : " + this.children.length + "\n";

        }

        if(this.is_summary) {
            return s1 + "Summary Node\n" + s2 + s3 + s4 + s5;

        } else {
            return s1 + "Cluster Represents: " + this.range_min + " - " + this.range_max + "\n" + s2 + s3 + s4 + s5;

        }

    }

    public void print() {
        System.out.println("\n========================================\n");

        if(this.is_summary) {
            System.out.println("Summary Node");
        } else {
            System.out.println("Cluster Represents: " + this.range_min + " - " + this.range_max);
        }

        System.out.println("Universe Size : " + this.universe_size);
        System.out.println("Minimum Value : " + this.min);
        System.out.println("Maximum Value : " + this.max);

        if(this.children != null) {
            System.out.println("Number of children : " + this.children.length);

        }

        if(this.summary != null) {
            summary.print();

        }

        if(this.children != null) {
            for(Node child : this.children) {
                child.print();

            }

        }

    }

    public void insert(int value) {
        if(value < 0 || value >= this.universe_size) {
            System.out.println("<-- Invalid entry. Value cannot be inserted -->");
            return;

        }

        if(this.min == -1) {
            this.min = value;
            this.max = value;
            return;

        }

        if(this.min == value) {
            return;

        }

        if(value < this.min) {
            int temp = this.min;
            this.min = value;
            if(this.universe_size != 2) {
                this.insert(temp);

            }

            return;

        }

        if(value > this.max) {
            this.max = value;
            if(this.universe_size != 2) {
                   this.insert(value);

            }

            return;

        }

        if(this.universe_size != 2) {
            int new_node = value / lowerSQRT(this.universe_size);
            int new_value = value % lowerSQRT(this.universe_size);
            this.summary.insert(new_node);
            this.children[new_node].insert(new_value);

        }

    }

    private int clusterNum(int value){
        return value/lowerSQRT(universe_size);

    }

    private int position(int value){
        return value%lowerSQRT(universe_size);

    }

    public int getMin(){
        return this.min;

    }

    public int getMax(){
        return this.max;

    }

    public boolean search(int value) {
        if(value < min || value > max) {
            return false;

        }

        if(universe_size == 2) {
            return value == min || value == max;

        }

        if(min == value || max == value) {
            return true;

        }

        return this.children[clusterNum(value)].search(position(value));
    }

    public int predecessor(int value) {
        if(value < 0 || value > range_max) {
            throw new ArrayIndexOutOfBoundsException("The range of values should be between "
                    + this.range_min + " - " + this.range_max);

        }

        if(universe_size == 2) {
            if(value == 1 && max == 1 && min == 0){
                return 0;

            }

            return -1;
        }

        if(value <= min) {
            return -1;

        }

        if(value > max){
            return max;

        }

        int start_num = clusterNum(value);
        int pred = children[start_num --].predecessor(position(value));

        while(pred == -1 && start_num > -1) {
            pred = children[start_num].getMax();
            start_num --;

        }

        if(pred == -1) {
            pred = this.min;

        }

        return pred + (start_num+ 1 ) * lowerSQRT(universe_size);
    }

    public int successor(int value) {
        if(value < 0 || value > range_max) {
            throw new ArrayIndexOutOfBoundsException("The range of values should be between "
                    + this.range_min + " - " + this.range_max);

        }

        if(universe_size == 2) {
            if(value == 0 && max == 1) {
                return 1;

            }

            return -1;

        }

        if(value >= max) {
            return -1;

        }

        if(value < min) {
            return min;

        }

        int start_num = clusterNum(value);
        int successor = children[start_num ++].successor(position(value));

        while(successor == -1 && start_num < children.length) {
            successor = children[start_num ++].getMin();

        }

        if(successor == -1) {
            successor = this.max;

        }

        return successor + (start_num - 1) * lowerSQRT(universe_size);
    }

    public boolean isEmpty() {
        if(min != -1) {
            return false;

        }

        for(Node child: children) {
            if(child.min != -1) {
                return false;
            }

        }

        return true;
    }

    public boolean delete(int value){
        if(value > max || value < min){
            return false;

        }
        if(universe_size == 2){
            if(value == min && value == max) {
                min=-1;
                max=-1;
                return true;

            }

            if(value == min) {
                min = max;
                return false;

            }

            if(value == max) {
                max = min;
                return false;

            }
        }

        if(value == min && value == max) {
            min=-1;
            max=-1;
            return true;

        } else if(value == min) {
            min = successor(value);
            value = min;

        } else if(value == max) {
            max = predecessor(value);

        }
        boolean empty = children[clusterNum(value)].delete(position(value));

        if(empty) {
            summary.delete(clusterNum(value));

        }

        return isEmpty();
    }
}
