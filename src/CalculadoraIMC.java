import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC extends JFrame {

    private double altura;
    private double peso;
    private double imc;


    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getIMC() {
        calcularIMC();
        return imc;
    }

    private JTextField pesoTextField;
    private JTextField alturaTextField;
    private JLabel resultadoLabel;

    public CalculadoraIMC() {
        // Configurar o JFrame
        setTitle("Calculadora IMC");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));


        panel.add(new JLabel("Peso (kg):"));
        pesoTextField = new JTextField();
        panel.add(pesoTextField);

        panel.add(new JLabel("Altura (mt):"));
        alturaTextField = new JTextField();
        panel.add(alturaTextField);


        JButton calcularButton = new JButton("Calcular IMC");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
        panel.add(calcularButton);

        panel.add(new JLabel("Resultado:"));
        resultadoLabel = new JLabel();
        panel.add(resultadoLabel);

        add(panel);

        setVisible(true);
    }

    private void calcularIMC() {
        try {
            peso = Double.parseDouble(pesoTextField.getText());
            altura = Double.parseDouble(alturaTextField.getText());

            setPeso(peso);
            setAltura(altura);

            imc = peso / (altura * altura);
            resultadoLabel.setText("Seu IMC é: " + imc);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira números válidos para peso e altura.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}



