
import org.mariuszgromada.math.mxparser.Expression;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.EventListener;


public class Calculator extends JFrame {
    private JButton evalButton;
    private JTextArea historyTextArea;
    private JTextField formulaInput;
    private JScrollPane scrollContainerPane;
    private JMenuBar menuBar;
    private String lastResult = "";
    private String lastExpression = "";
    private boolean isMasterMode = false;

    private Calculator() {
        this.setTitle("Calculator");
        this.setBounds(300, 200, 300, 200);
        initComponents();
        pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);

        scrollContainerPane = new JScrollPane(historyTextArea);
        formulaInput = new JTextField();

        // Tworzenie listy funkcji
        DefaultListModel<Function> listModel = new DefaultListModel<>();

        listModel.addElement(new Function("sinus", "sin()"));
        listModel.addElement(new Function("cosinus", "cos()"));
        listModel.addElement(new Function("tangens", "tg()"));
        listModel.addElement(new Function("cotangens", "ctg()"));
        listModel.addElement(new Function("arcus sinus", "arcsin()"));

        listModel.addElement(new Function("PI", "pi"));
        listModel.addElement(new Function("e", "e"));
        listModel.addElement(new Function("Levy's constant", "[L.]"));

        listModel.addElement(new Function("+", "+"));
        listModel.addElement(new Function("-", "-"));
        listModel.addElement(new Function("*", "*"));

        listModel.addElement(new Function("Last result", "Last result"));

        JList<Function> functionsList = new JList<>(listModel);


        //reakcja na 2-krotne kliknięcie
        functionsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) {

                    JList list = (JList) event.getSource();
                    Function function = (Function) list.getSelectedValue();

                    if (function.getName().equals("Last result")) {
                        formulaInput.setText(lastResult);
                    } else {
                        formulaInput.setText(formulaInput.getText() + function.getKeyWord());
                    }

                    formulaInput.requestFocus();
                    String[] unaryFunctions = {"sinus", "cosinus", "tangens", "cotangens", "arcus sinus"};

                    if (Arrays.asList(unaryFunctions).contains(function.getName())) {

                        int parenthesesFocus = formulaInput.getText().length() - 1;
                        formulaInput.select(parenthesesFocus, parenthesesFocus);
                    }
                }
            }
        });


        Action evaluateAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Expression expression = new Expression(formulaInput.getText());
                lastExpression = formulaInput.getText();
                if (expression.checkSyntax()) {
                    double result = expression.calculate();
                    lastResult = Double.toString(result);
                    String result1 = MessageFormat.format("\n {0} =  {1}\n", formulaInput.getText(), result);
                    historyTextArea.append(result1);
                    formulaInput.setText("");

                } else {
                    String errorMessage = expression.getErrorMessage();

                    JOptionPane.showMessageDialog(null, "The expression is incorrect \n" + errorMessage,
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };


        //EVALUATE
        evalButton = new JButton("Evaluate!");
        evalButton.addActionListener(evaluateAction);
//        evalButton.addActionListener(this::evaluateAction);


        //LAYOUT
        GroupLayout groupLayout = new GroupLayout(getContentPane());

        this.getContentPane().setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(
                                groupLayout.createParallelGroup().addComponent(scrollContainerPane, 0, 400, Short.MAX_VALUE)
                                        .addComponent(formulaInput)
                        )
                        .addGroup(
                                groupLayout.createParallelGroup().addComponent(functionsList, 100, 100, 100)
                                        .addComponent(evalButton, 0, 100, 100)
                        ));

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(
                                groupLayout.createParallelGroup().addComponent(scrollContainerPane, 0, 300, Short.MAX_VALUE)
                                        .addComponent(functionsList, 0, 300, Short.MAX_VALUE)
                        )
                        .addGroup(
                                groupLayout.createParallelGroup().addComponent(formulaInput, 0, 25, 25)
                                        .addComponent(evalButton)
                        ));


        //MENU
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu menuOptions = new JMenu("Options");
        JMenuItem reset = new JMenuItem("Reset");
        JMenu mode = new JMenu("Mode");
        JCheckBoxMenuItem checkBoxMasterMode = new JCheckBoxMenuItem("Master mode");
        JMenuItem exit = new JMenuItem("Exit");

        menuBar.add(menuOptions);
        menuOptions.add(reset);
        menuOptions.add(mode);
        menuOptions.addSeparator();
        menuOptions.add(exit);

        mode.add(checkBoxMasterMode);

        reset.addActionListener(e -> {
            historyTextArea.setText("");
            formulaInput.setText("");
        });
        checkBoxMasterMode.addActionListener(e -> isMasterMode = checkBoxMasterMode.isSelected());
        exit.addActionListener(e -> System.exit(0));

        formulaInput.addActionListener(evaluateAction);

        formulaInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(isNumber(e.getKeyChar()) || isMasterMode)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    formulaInput.setText(lastExpression);
                }
            }
        });
    }

    private boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}