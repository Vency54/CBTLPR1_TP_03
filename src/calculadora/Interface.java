/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

/**
 * Construir o Form abaixo e possibilitar o cálculo das operações de divisão,
 * multiplicação, subtração e adição.
 *
 * Dupla: João Victor Lima Venceslau - Rayssa Silva de Oliveira
 */
public class Interface extends JFrame {

    private final JTextField Calculo;
    private double primeiroNumero;
    private String operador;
    private boolean novoNumero;

    public Interface() {
        super("Calculadora");
        Calculo = new JTextField("0");

        primeiroNumero = 0;
        operador = "";
        novoNumero = true;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(190, 225);
        setMinimumSize(new Dimension(190, 225));
        setResizable(false);
        setLocationRelativeTo(null);
        criarInterface();
    }

    private void criarInterface() {
        Calculo.setEditable(false);
        Calculo.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel painelPrincipal = new JPanel(new BorderLayout(2, 2));

        painelPrincipal.add(Calculo, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(5, 4, 2, 2));

        adicionarBotao(painelBotoes, "7");
        adicionarBotao(painelBotoes, "8");
        adicionarBotao(painelBotoes, "9");
        adicionarBotao(painelBotoes, "/");

        adicionarBotao(painelBotoes, "4");
        adicionarBotao(painelBotoes, "5");
        adicionarBotao(painelBotoes, "6");
        adicionarBotao(painelBotoes, "*");

        adicionarBotao(painelBotoes, "1");
        adicionarBotao(painelBotoes, "2");
        adicionarBotao(painelBotoes, "3");
        adicionarBotao(painelBotoes, "-");

        adicionarBotao(painelBotoes, "0");
        adicionarBotao(painelBotoes, ".");
        adicionarBotao(painelBotoes, "=");
        adicionarBotao(painelBotoes, "+");

        JButton botaoLimpar = new JButton("C");

        botaoLimpar.addActionListener(evento -> limparCampos());

        painelBotoes.add(botaoLimpar);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);
        add(painelPrincipal);
    }

    private void adicionarBotao(JPanel painel, String texto) {

        JButton botao = new JButton(texto);

        botao.addActionListener(evento -> {
            if (texto.matches("[0-9]")) {
                adicionarNumero(texto);
            } else if (texto.equals(".")) {
                adicionarDecimal();
            } else if (texto.equals("=")) {
                realizarConta();

            } else {
                selecionarOperador(texto);
            }

        });
        painel.add(botao);

    }

    private void adicionarNumero(String numero) {

        if (novoNumero || Calculo.getText().equals("0")) {

            Calculo.setText(numero);
            novoNumero = false;

        } else {

            Calculo.setText(Calculo.getText() + numero);

        }
    }

    private void adicionarDecimal() {

        if (novoNumero) {
            Calculo.setText("0.");
            novoNumero = false;

        } else if (!Calculo.getText().contains(".")) {
            Calculo.setText(Calculo.getText() + ".");
        }
    }

    private void selecionarOperador(String novoOperador) {

        try {

            primeiroNumero = Double.parseDouble(Calculo.getText());

            operador = novoOperador;

            novoNumero = true;

        } catch (NumberFormatException exception) {

            JOptionPane.showMessageDialog(
                    this,
                    "Número inválido!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        }
    }

    private void realizarConta() {

        try {

            double segundoNumero = Double.parseDouble(Calculo.getText());

            double resultado = 0;

            switch (operador) {

                case "+":
                    resultado = primeiroNumero + segundoNumero;
                    break;

                case "-":
                    resultado = primeiroNumero - segundoNumero;
                    break;

                case "*":
                    resultado = primeiroNumero * segundoNumero;
                    break;

                case "/":

                    if (segundoNumero == 0) {
                        throw new ArithmeticException(
                                "Não é possível dividir por zero."
                        );
                    }

                    resultado = primeiroNumero / segundoNumero;
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            this,
                            "Selecione uma operação!",
                            "Atenção",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
            }

            Calculo.setText(
                    String.valueOf(resultado)
            );

            primeiroNumero = resultado;
            operador = "";
            novoNumero = true;

        } catch (NumberFormatException exception) {

            JOptionPane.showMessageDialog(
                    this,
                    "Digite um número válido!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (ArithmeticException exception) {

            JOptionPane.showMessageDialog(
                    this,
                    exception.getMessage(),
                    "Erro matemático",
                    JOptionPane.ERROR_MESSAGE
            );

            Calculo.setText("0");

            primeiroNumero = 0;
            operador = "";
            novoNumero = true;

        } finally {

        }
    }

    private void limparCampos() {

        Calculo.setText("0");

        primeiroNumero = 0;
        operador = "";
        novoNumero = true;
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            new Interface().setVisible(true);
        });
    }
}
