import java.io.File;
import java.util.*;
import algo.util.Validator;

class MyWordladder {
    public static void main(String[] args) {
        MyWordladder mainProgram = new MyWordladder();
        mainProgram.start();
    }

    private void start() {
        Set<String>[] dictionary = loadDictionary();
        printSplashScreen();

        // =====================================================
        // Input data
        // =====================================================

        Scanner scanner = new Scanner(System.in);
        String startWord = Validator.validateInputString("\nMasukkan kata awal: ", dictionary, scanner);
        String endWord = Validator.validateInputString("\nMasukkan kata akhir: ", startWord.length(), dictionary, scanner);

        String algorithmPrompt = ("\nMasukkan pilihan algoritma (1-3):" +
        "\n-----------------------------------" + 
        "\n| 1. UCS (Uniform Cost Search)    |" +
        "\n| 2. Greedy Best First Search     |" +
        "\n| 3. A* (A Star)                  |" +
        "\n|_________________________________|" +
        "\n\nPilihan input: ");
        int chosenAlgorithm = Validator.validateInputInteger(algorithmPrompt, 1, 3, scanner);


        // =====================================================
        // Process data
        // =====================================================

        AlgorithmHandler algorithm = new AlgorithmHandler(dictionary);
        algorithm.run(startWord, endWord, chosenAlgorithm);

        if (algorithm.isFoundSolution()) {
            System.out.println("Solusi berhasil ditemukan!");
        } else {
            System.out.println("Solusi gagal ditemukan.");
        }
        System.out.println("\nJalur yang ditemukan: ");
        System.out.println(algorithm.getSolutionPath());
        System.out.println("\nJumlah langkah            : " + algorithm.getNumberOfSteps());
        System.out.println("Jumlah simpul dikunjungi  : " + algorithm.getNumberOfNodesVisited());
        System.out.println("Waktu eksekusi            : " + algorithm.getExecutionTime() + " ms\n");
        
        scanner.close();
    }

    public static Set<String>[] loadDictionary() {
        Set<String>[] dictionary = new HashSet[20];
        for (int i = 0; i < 20; i++) {
            dictionary[i] = new HashSet<String>();
        }
        
        File file = new File("src/dict/wordlist.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                dictionary[word.length()-1].add(word);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return dictionary;
    }

    private void printSplashScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println(" /$$      /$$                           /$$       /$$                       /$$       /$$                     ");                    
        System.out.println("| $$  /$ | $$                          | $$      | $$                      | $$      | $$                    ");
        System.out.println("| $$ /$$$| $$  /$$$$$$   /$$$$$$   /$$$$$$$      | $$        /$$$$$$   /$$$$$$$  /$$$$$$$  /$$$$$$   /$$$$$$ ");
        System.out.println("| $$/$$ $$ $$ /$$__  $$ /$$__  $$ /$$__  $$      | $$       |____  $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$");
        System.out.println("| $$$$_  $$$$| $$  \\ $$| $$  \\__/| $$  | $$      | $$        /$$$$$$$| $$  | $$| $$  | $$| $$$$$$$$| $$  \\__/");
        System.out.println("| $$$/ \\  $$$| $$  | $$| $$      | $$  | $$      | $$       /$$__  $$| $$  | $$| $$  | $$| $$_____/| $$      ");
        System.out.println("| $$/   \\  $$|  $$$$$$/| $$      |  $$$$$$$      | $$$$$$$$|  $$$$$$$|  $$$$$$$|  $$$$$$$|  $$$$$$$| $$      ");
        System.out.println("|__/     \\__/ \\______/ |__/       \\_______/      |________/ \\_______/ \\_______/ \\_______/ \\_______/|__/      ");
    }
}
