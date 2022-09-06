public class JavaLearn {
    public static void main(String[]args) {

    }

    public void variables() {
        String text = "This is a String";
        int num = 1;
        //Float and doubles are almost identical but store different lengths.//
        float decimal = 1.0F;
        double decimal2 = 1.0;
        boolean bool = true;
        // Array format: Type[length] var_name = {items}//
        int[] array = {1, 2, 3, 4};
        int[][] double_array = {{1, 2 ,3 ,4}, {5, 6, 7}};
    }

    // Example code for blocks, loops and branches.//
    public void blocksloopsbranches() {
        int test_var = 1;
        int f_var;

        //if and else//
        if (test_var != 2) {
            System.out.println("Triggered if statement");
        }
        else {
            test_var += 1;
        }

        //While loop//
        //Format: while (expression) {}
        while (test_var == 1) {
            test_var += 1;
        }

        //Do while loop!//
        //Format: do (expression) {} while ();//
        do {
            test_var += 1;}
            while (test_var != 3);

        //for loop//
        //Format: (minimum; maximum; change ++ or --) {}//
        for (f_var = 0; f_var < 5; f_var++) {
            System.out.println(f_var);
        }
        //Switch loop//
        //Used to switch between value's, replaces if statement heaps.//
        switch (test_var) {
            case 1 -> System.out.println("Case 1");
            case 3 -> System.out.println("Other case");
        }
    }
}

