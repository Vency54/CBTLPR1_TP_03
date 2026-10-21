/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * • A propriedade “kp” é estática e deve nos informar quantas pessoas distintas
 * foram “setadas”, deve funcionar como um contador;
 *
 * Para digitar os dados relativos a uma pessoa crie o FormPessoa conforme
 * layout: O campo “Numero” não deve estar acessível à digitação;
 *
 * Os campos “Nome”, “Sexo” e “Idade” são de preenchimento obrigatório.
 *
 * O campo “Sexo” só deve aceitar “M” ou “F”.
 *
 * Quando se pressionar o botão “OK” os dados digitados deverão ser transferidos
 * ao objeto “UmaPessoa”, uma instância da classe Pessoa.
 *
 * Quando se pressionar o botão “Mostrar” descarregar os dados do objeto
 * “UmaPessoa” inclusive o contador “kp”.
 *
 * Dupla: João Victor Lima Venceslau - Rayssa Silva de Oliveira
 */
public class FormPessoa extends JFrame {

    private final JTextField campoNumero;
    private final JTextField campoNome;
    private final JTextField campoSexo;
    private final JTextField campoIdade;

    private final JButton botaoOK;
    private final JButton botaoMostrar;
    private final JButton botaoLimpar;
    private final JButton botaoSair;

    private final Pessoa NovaPessoa;

    public FormPessoa() {
        super("Formulário");

        NovaPessoa = new Pessoa();

        campoNumero = new JTextField();
        campoNome = new JTextField();
        campoSexo = new JTextField();
        campoIdade = new JTextField();

        botaoOK = new JButton("OK");
        botaoLimpar = new JButton("Limpar");
        botaoMostrar = new JButton("Mostrar");
        botaoSair = new JButton("Sair");

        criarInterface();

        botaoOK.addActionListener(evento -> cadastrarPessoa());
        botaoMostrar.addActionListener(evento -> mostrarPessoa());
        botaoLimpar.addActionListener(evento -> limparCampos());
        botaoSair.addActionListener(evento -> System.exit(0));

    }

    private void criarInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 175);

        setLocationRelativeTo(null);

        setResizable(false);

        campoNumero.setEditable(false);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCampos.setBackground(java.awt.Color.LIGHT_GRAY);

        painelCampos.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 3, 0, 3));

        JLabel labelNumero = new JLabel("Numero:");
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelSexo = new JLabel("Sexo:");
        JLabel labelIdade = new JLabel("Idade:");

        java.awt.Font fonte = new java.awt.Font(
                "Arial",
                java.awt.Font.BOLD,
                15
        );

        labelNumero.setFont(fonte);
        labelNome.setFont(fonte);
        labelSexo.setFont(fonte);
        labelIdade.setFont(fonte);

        painelCampos.add(labelNumero);
        painelCampos.add(campoNumero);

        painelCampos.add(labelNome);
        painelCampos.add(campoNome);

        painelCampos.add(labelSexo);
        painelCampos.add(campoSexo);

        painelCampos.add(labelIdade);
        painelCampos.add(campoIdade);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 4, 2, 0));
        painelCampos.setBackground(java.awt.Color.LIGHT_GRAY);

        painelBotoes.add(botaoOK);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoMostrar);
        painelBotoes.add(botaoSair);

        java.awt.Font fonteBotoes = new java.awt.Font(
                "Arial",
                java.awt.Font.PLAIN,
                10
        );

        botaoOK.setFont(fonteBotoes);
        botaoLimpar.setFont(fonteBotoes);
        botaoMostrar.setFont(fonteBotoes);
        botaoSair.setFont(fonteBotoes);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBackground(java.awt.Color.LIGHT_GRAY);

        painelPrincipal.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        painelPrincipal.add(painelCampos, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);
    }

    private void cadastrarPessoa() {
        String nome = campoNome.getText().trim();
        String sexoTexto = campoSexo.getText().trim();
        String idadeTexto = campoIdade.getText().trim();

        if (nome.isEmpty() || sexoTexto.isEmpty() || idadeTexto.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Preencha todos os campos!",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (sexoTexto.length() != 1 || (!sexoTexto.equalsIgnoreCase("M") && !sexoTexto.equalsIgnoreCase("F"))) {
            JOptionPane.showMessageDialog(
                    this,
                    "O sexo deve ser M ou F!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            int idade = Integer.parseInt(idadeTexto);

            if (idade < 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "A idade não pode ser negativa!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }
            NovaPessoa.setNome(nome);
            NovaPessoa.setSexo(sexoTexto.toUpperCase().charAt(0));
            NovaPessoa.setIdade(idade);

            NovaPessoa.setKp();

            campoNumero.setText(String.valueOf(NovaPessoa.getKp()));

            JOptionPane.showMessageDialog(
                    this,
                    "Pessoa cadastrada com sucesso!"
            );
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(
                    this,
                    "A idade deve ser um número inteiro!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }

    private void limparCampos() {
        campoNumero.setText("");
        campoNome.setText("");
        campoSexo.setText("");
        campoIdade.setText("");

        campoNome.requestFocus();
    }

    private void mostrarPessoa() {
        JOptionPane.showMessageDialog(
                this,
                "Número: " + NovaPessoa.getKp()
                + "\nNome: " + NovaPessoa.getNome()
                + "\nSexo: " + NovaPessoa.getSexo()
                + "\nIdade: " + NovaPessoa.getIdade(),
                "Dados da Pessoa",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new FormPessoa().setVisible(true);
        });
    }
}
