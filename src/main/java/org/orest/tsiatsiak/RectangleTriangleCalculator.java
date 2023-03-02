package org.orest.tsiatsiak;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class RectangleTriangleCalculator extends JFrame {

    private final TextFieldWithPretunedSize catetA = new TextFieldWithPretunedSize();

    private final TextFieldWithPretunedSize catetB = new TextFieldWithPretunedSize();

    private final TextFieldWithPretunedSize hypotenuse = new TextFieldWithPretunedSize();

    private final TextFieldWithPretunedSize triangleArea = new TextFieldWithPretunedSize();

    public RectangleTriangleCalculator() {
        setUpWindow();
        GridBagConstraints c = new GridBagConstraints();
        addInputs(c);
        addCalculateButton(c);
        addOutputs(c);
        revalidate();
    }

    private void setUpWindow() {
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Right triangle calculator");
        setLayout(new GridBagLayout());
    }

    private void addInputs(GridBagConstraints c) {
        JPanel inputsContainer = new JPanel();
        inputsContainer.setLayout(new BoxLayout(inputsContainer, BoxLayout.Y_AXIS));

        JLabel inputsTitle = new JLabel("Inputs");
        inputsTitle.setForeground(Color.RED);

        inputsContainer.add(inputsTitle);
        inputsContainer.add(new JLabel("Catet A"));
        inputsContainer.add(catetA);
        inputsContainer.add(new JLabel("Catet B"));
        inputsContainer.add(catetB);

        c.gridx = 0;
        c.gridy = 0;
        add(inputsContainer, c);
    }

    private void addOutputs(GridBagConstraints c) {
        JPanel outputsContainer = new JPanel();
        outputsContainer.setLayout(new BoxLayout(outputsContainer, BoxLayout.Y_AXIS));

        JLabel outputsTitle = new JLabel("Outputs");
        outputsTitle.setForeground(Color.RED);

        outputsContainer.add(outputsTitle);
        outputsContainer.add(new JLabel("Hypotenuse"));
        outputsContainer.add(hypotenuse);
        outputsContainer.add(new JLabel("Triangle area"));
        outputsContainer.add(triangleArea);

        c.gridx = 2;
        c.gridy = 0;
        add(outputsContainer, c);
    }

    private void addCalculateButton(GridBagConstraints c) {
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setPreferredSize(new Dimension(100, 40));
        calculateButton.addMouseListener(getClickListener());

        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0, 10, 0, 10);
        add(calculateButton, c);
    }

    private MouseListener getClickListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double catetAValue = Double.parseDouble(catetA.getText());
                double catetBValue = Double.parseDouble(catetB.getText());
                double hypotenuseValue = sqrt(pow(catetAValue, 2) + pow(catetBValue, 2));
                hypotenuse.setText(Double.toString(hypotenuseValue));
                double triangleAreaValue = (catetAValue * catetBValue) / 2;
                triangleArea.setText(Double.toString(triangleAreaValue));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }


    private static class TextFieldWithPretunedSize extends JTextField {

        public TextFieldWithPretunedSize() {
            setPreferredSize(new Dimension(150, 20));
        }

    }

}
