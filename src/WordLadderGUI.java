import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordLadderGUI extends JFrame {
    private JTextField startField;
    private JTextField endField;
    private JPanel resultPanel;

    public WordLadderGUI() {
        super("Word Ladder Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        JLabel titleLabel = new JLabel("Word Ladder Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        mainPanel.add(new JLabel("Start Word:"), gbc);
        gbc.gridy++;
        mainPanel.add(new JLabel("End Word:"), gbc);
        gbc.gridy++;
        mainPanel.add(new JLabel("Algorithm:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        startField = new JTextField(10);
        mainPanel.add(startField, gbc);
        gbc.gridy++;
        endField = new JTextField(10);
        mainPanel.add(endField, gbc);

        gbc.gridy++;
        JPanel algorithmPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup group = new ButtonGroup();
        JRadioButton ucsButton = new JRadioButton("UCS");
        JRadioButton greedyBFSButton = new JRadioButton("Greedy BFS");
        JRadioButton aStarButton = new JRadioButton("A*");
        group.add(ucsButton);
        group.add(greedyBFSButton);
        group.add(aStarButton);
        algorithmPanel.add(ucsButton);
        algorithmPanel.add(greedyBFSButton);
        algorithmPanel.add(aStarButton);
        mainPanel.add(algorithmPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton findButton = new JButton("Find Word Ladder");
        mainPanel.add(findButton, gbc);

        gbc.gridy++;
        JLabel foundLabel = new JLabel();
        mainPanel.add(foundLabel, gbc);

        gbc.gridy++;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(resultPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scrollPane, gbc);
        
        gbc.gridy++;
        JLabel timeLabel = new JLabel();
        mainPanel.add(timeLabel, gbc);

        gbc.gridy++;
        JLabel visitedLabel = new JLabel();
        mainPanel.add(visitedLabel, gbc);

        gbc.gridy++;
        gbc.gridheight = 100;
        JLabel emptyLabel = new JLabel();
        mainPanel.add(emptyLabel, gbc);

        gbc.gridy++;
        JLabel emptyLabel2 = new JLabel();
        mainPanel.add(emptyLabel2, gbc);

        gbc.gridy++;
        JLabel emptyLabel3 = new JLabel();
        mainPanel.add(emptyLabel3, gbc);

        Set<String>[] dict = MyWordladder.loadDictionary();
        AlgorithmHandler algo = new AlgorithmHandler(dict);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startWord = startField.getText();
                String endWord = endField.getText();

                if (startWord.equals("")) {
                    JOptionPane.showMessageDialog(WordLadderGUI.this,
                    "startWord cannot be empty!.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (endWord.equals("")) {
                    JOptionPane.showMessageDialog(WordLadderGUI.this,
                    "endWord cannot be empty!.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (startWord.length() != endWord.length()) {
                    JOptionPane.showMessageDialog(WordLadderGUI.this,
                    "startWord and endWord must have the same length!.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!dict[startWord.length()-1].contains(startWord)) {
                    JOptionPane.showMessageDialog(WordLadderGUI.this,
                    "The word \"" + startWord + "\" is not in dictionary!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!dict[startWord.length()-1].contains(endWord)) {
                    JOptionPane.showMessageDialog(WordLadderGUI.this,
                    "The word \"" + endWord + "\" is not in dictionary!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                List<String> ladder = new ArrayList<>();
                if (ucsButton.isSelected()) {
                    algo.run(startWord, endWord, 1);
                    ladder = algo.getSolutionPath();
                } else if (greedyBFSButton.isSelected()) {
                    algo.run(startWord, endWord, 2);
                    ladder = algo.getSolutionPath();
                } else if (aStarButton.isSelected()) {
                    algo.run(startWord, endWord, 3);
                    ladder = algo.getSolutionPath();
                } else {
                    JOptionPane.showMessageDialog(WordLadderGUI.this,
                    "Please select an algorithm.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                foundLabel.setHorizontalAlignment(SwingConstants.CENTER);
                if (algo.isFoundSolution()) {
                    foundLabel.setText("Found a solution!");
                } else {
                    foundLabel.setText("Failed to find a solution.");
                }

                resultPanel.removeAll();
                for (int i = 0; i < ladder.size(); i++) {
                    JLabel label = new JLabel((i + 1) + ". " + ladder.get(i));
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);
                    resultPanel.add(label);
                }
            
                resultPanel.revalidate();
                resultPanel.repaint();
 
                timeLabel.setText("Execution time: " + algo.getExecutionTime() + " ms");
                visitedLabel.setText("Number of nodes visited: " + algo.getNumberOfNodesVisited());
                emptyLabel.setText(" ");
                emptyLabel2.setText(" ");
                emptyLabel3.setText(" ");
            }
        });

        getContentPane().add(mainPanel);
        pack();
        setLocationRelativeTo(null); // Center the window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordLadderGUI().setVisible(true);
            }
        });
    }
}
