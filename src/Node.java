import java.lang.Math.*;

public class Node {
    public int universe_size;
    public  int min;
    public int max;
    public Node summary;
    public Node[] children;
    public boolean is_summary;

    Node() {
        universe_size = 0;
        min = -1;
        max = -1;
        summary = null;
        children = null;
        is_summary = false;
    }

    Node(int universe_size) {
        this.universe_size = universe_size;
        this.min = -1;
        this.max = -1;
        this.is_summary = false;

        if(universe_size == 2) {
            this.summary = null;
            this.children = null;

        } else {
            this.children = new Node[higherSQRT(universe_size)];
            this.summary = new Node(lowerSQRT(universe_size), true);

            for(int i = 0; i < higherSQRT(universe_size); i++) {
                children[i] = new Node(lowerSQRT(universe_size));

            }

        }

    }

    Node(int universe_size, boolean is_summary) {
        this.universe_size = universe_size;
        this.min = -1;
        this.max = -1;
        this.is_summary = is_summary;

        if(universe_size == 2) {
            this.summary = null;
            this.children = null;

        } else {
            this.children = new Node[higherSQRT(universe_size)];
            this.summary = new Node(lowerSQRT(universe_size), true);

            for(int i = 0; i < higherSQRT(universe_size); i++) {
                children[i] = new Node(lowerSQRT(universe_size));

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

        }

        return s1 + s2 + s3 + s4 + s5;

    }

    public void print() {
        System.out.println("\n========================================\n");

        if(this.is_summary) {
            System.out.println("Summary Node");
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
            for(int i = 0; i < this.children.length; i++) {
                children[i].print();

            }

        }

    }

}
