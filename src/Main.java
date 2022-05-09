import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Node vEB = new Node(16);

        Scanner kb = new Scanner(System.in);

        System.out.println("Initially Empty vEB has been created!");

        boolean choice = true;

        while(choice) {
            System.out.println("\n");
            System.out.println("1. Insertion");
            System.out.println("2. Search");
            System.out.println("3. Deletion");
            System.out.println("4. Finding Predecessor");
            System.out.println("5. Finding Successor");
            System.out.println("6. Finding Maximum");
            System.out.println("7. Finding Minimum");
            System.out.println("8. Print Tree");
            System.out.print("Choose an Operation : ");
            int c = kb.nextInt();
            System.out.println("\n");

            switch(c) {
                case 1: {
                    System.out.print("\nEnter the value to be inserted : ");
                    int value = kb.nextInt();
                    vEB.insert(value);
                    break;
                }

                case 2: {
                    System.out.print("\nEnter the value to be searched : ");
                    int value = kb.nextInt();

                    if(vEB.search(value)) {
                        System.out.println("\nElement Found in the Tree!!\n");
                    } else {
                        System.out.println("\nElement NOT Found in the Tree!!\n");
                    }

                    break;
                }

                case 3: {
                    System.out.print("\nEnter the value to be deleted : ");
                    int value = kb.nextInt();
                    vEB.delete(value);
                    break;
                }

                case 4: {
                    System.out.print("Enter the value to find predecessor : ");
                    int value = kb.nextInt();
                    System.out.print("\nPredecessor Value is : " + vEB.predecessor(value));
                    break;
                }

                case 5: {
                    System.out.print("Enter the value to find successor : ");
                    int value = kb.nextInt();
                    System.out.print("\nSuccessor Value is : " + vEB.successor(value));
                    break;
                }

                case 6: {
                    System.out.print("\nMaximum Value in Tree is : " + vEB.getMax());
                    break;
                }

                case 7: {
                    System.out.print("\nMinimum Value in Tree is : " + vEB.getMin());
                    break;
                }

                case 8: {
                    vEB.print();
                    break;
                }

                default: {
                    System.out.println("\nEnter a valid choice!!");
                }
            }

            System.out.print("\nEnter '1' to continue : ");
            char ch = kb.next().charAt(0);

            if(ch != '1') {
                choice = false;
            }
        }

        vEB.print();

    }

}
