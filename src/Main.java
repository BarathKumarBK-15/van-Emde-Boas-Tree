public class Main {
    public static void main(String[] args) {
        Node vEB = new Node(16);
        System.out.println("Initially Empty vEB has been created!");

        vEB.insert(2);
        vEB.insert(3);
        vEB.insert(4);
        vEB.insert(5);
        vEB.insert(7);
        vEB.insert(14);
        vEB.insert(15);
        System.out.println("A few values have been inserted!");

        System.out.println(vEB.children[0]);

        vEB.print();

    }

}
