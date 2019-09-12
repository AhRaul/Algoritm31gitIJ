import javax.swing.*;
import java.awt.*;

// GUI приложения
public class View extends JFrame {

    private Controller controller;

    private JTextField jtf;

    View() {
        setSize(300, 300);
        setLocationRelativeTo(null);                    //окно в середину раб стола
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jtf = new JTextField();                                 //текстовое поле
        JPanel upperPanel = new JPanel(new BorderLayout());
        add(upperPanel, BorderLayout.NORTH);
        upperPanel.add(jtf, BorderLayout.CENTER);

        JPanel qwertyPanel = new JPanel(new GridLayout(5,4));     //клавиатура
        add(qwertyPanel, BorderLayout.CENTER);

        //кнопка очистить поле
        JButton jbCe = new JButton("CE");
        //кнопка отменить все операции
        JButton jbC = new JButton("C");
        //кнопка стереть последний введенный символ
        JButton jbBackspace = new JButton("<-");
        //кнопка "/"
        JButton jbSegmentation = new JButton("/");
        JButton jb7 = new JButton("7");
        JButton jb8 = new JButton("8");
        JButton jb9 = new JButton("9");
        //кнопка "*"
        JButton jbMultiplication = new JButton("*");
        JButton jb4 = new JButton("4");
        JButton jb5 = new JButton("5");
        JButton jb6 = new JButton("6");
        //кнопка "-"
        JButton jbSubtraction = new JButton("-");
        JButton jb1 = new JButton("1");
        JButton jb2 = new JButton("2");
        JButton jb3 = new JButton("3");
        //кнопка "+"
        JButton jbAddition = new JButton("+");
        //кнопка выбора знака перед числом
        JButton jbPlusMinus = new JButton("+/-");
        JButton jb0 = new JButton("0");
        //кнопка Разделитель десятичной дроби
        JButton jbPoint = new JButton(".");
        //кнопка "="
        JButton jbResult = new JButton("=");

        qwertyPanel.add(jbCe);
        qwertyPanel.add(jbC);
        qwertyPanel.add(jbBackspace);
        qwertyPanel.add(jbSegmentation);
        qwertyPanel.add(jb7);
        qwertyPanel.add(jb8);
        qwertyPanel.add(jb9);
        qwertyPanel.add(jbMultiplication);
        qwertyPanel.add(jb4);
        qwertyPanel.add(jb5);
        qwertyPanel.add(jb6);
        qwertyPanel.add(jbSubtraction);
        qwertyPanel.add(jb1);
        qwertyPanel.add(jb2);
        qwertyPanel.add(jb3);
        qwertyPanel.add(jbAddition);
        qwertyPanel.add(jbPlusMinus);
        qwertyPanel.add(jb0);
        qwertyPanel.add(jbPoint);
        qwertyPanel.add(jbResult);

        jbCe.addActionListener(e -> {       //нажатие кнопки CE для очистки поля
            setAtTextField("");
        });

        jbC.addActionListener(e -> {       //нажатие кнопки C сброса всех операций
            setAtTextField("");
            controller.update("C");
        });

        jbBackspace.addActionListener(e -> {       //нажатие кнопки Backspace
            backspaceTextField();
        });

        jbSegmentation.addActionListener(e -> {       //нажатие кнопки разделить
            controller.update("/");
        });

        jb7.addActionListener(e -> {       //нажатие кнопки 7
            appEndTextField("7");
        });

        jb8.addActionListener(e -> {       //нажатие кнопки 8
            appEndTextField("8");
        });

        jb9.addActionListener(e -> {       //нажатие кнопки 9
            appEndTextField("9");
        });

        jbMultiplication.addActionListener(e -> {       //нажатие кнопки умножить
            controller.update("*");
        });

        jb4.addActionListener(e -> {       //нажатие кнопки 4
            appEndTextField("4");
        });

        jb5.addActionListener(e -> {       //нажатие кнопки 5
            appEndTextField("5");
        });

        jb6.addActionListener(e -> {       //нажатие кнопки 6
            appEndTextField("6");
        });

        jbSubtraction.addActionListener(e -> {       //нажатие кнопки "-"
            controller.update("-");
        });

        jb1.addActionListener(e -> {       //нажатие кнопки 4
            appEndTextField("1");
        });

        jb2.addActionListener(e -> {       //нажатие кнопки 5
            appEndTextField("2");
        });

        jb3.addActionListener(e -> {       //нажатие кнопки 6
            appEndTextField("3");
        });

        jbAddition.addActionListener(e -> {       //нажатие кнопки "+"
            controller.update("+");
        });

        jbPlusMinus.addActionListener(e -> {       //нажатие кнопки "+/-"
            if(Double.parseDouble(jtf.getText())>0.0) appStartTextField("-");
            else if(Double.parseDouble(jtf.getText())<0.0) backspaceStartTextField();
            else {}
        });

        jb0.addActionListener(e -> {       //нажатие кнопки 0
            appEndTextField("0");
        });

        jbPoint.addActionListener(e -> {       //нажатие кнопки "."
            appEndTextField(".");
        });

        jbResult.addActionListener(e -> {       //нажатие кнопки "="
            controller.update("=");
        });

        setVisible(true);
    }



    //возвращает текст из текстового поля
    public String readTextField() {
        return jtf.getText();
    }

    //заменяет текст в текстовом поле
    public void setAtTextField(String value) {
        jtf.setText(value);
    }

    //дополняет текст в текстовом поле
    public void backspaceTextField() {
        String str = jtf.getText();
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        jtf.setText(str);
    }

    //дополняет текст в текстовом поле
    public void appEndTextField(String value) {
        jtf.setText(jtf.getText() + value);
    }

    //дополняет начало текста в текстовом поле
    public void appStartTextField(String value) {
        jtf.setText(value + jtf.getText());
    }

    //удаляет начало текста в текстовом поле
    public void backspaceStartTextField() {
        String str = jtf.getText();
        if (str != null && str.length() > 0) {
            str = str.substring(1, str.length());
        }
        jtf.setText(str);
    }

    //задает контроллер для View
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
