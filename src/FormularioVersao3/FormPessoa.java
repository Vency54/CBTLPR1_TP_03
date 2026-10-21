package FormularioVersao3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/*
* Refaça o exercício anterior, porém agora usando um componente do tipo “JRadioButton”.
*
* Dupla: João Victor Lima Venceslau - Rayssa Silva de Oliveira
 */
public class FormPessoa extends JFrame {

    private final JTextField campoNumero = new JTextField();
    private final JTextField campoNome = new JTextField();
    private final JRadioButton sexoMasculino = new JRadioButton("M");
    private final JRadioButton sexoFeminino = new JRadioButton("F");
    private final JTextField campoIdade = new JTextField();
    private final Pessoa umaPessoa = new Pessoa();

    public FormPessoa() {
        super("Exercício 3 - Pessoa");
        criarInterface();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 210);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void criarInterface() {
        campoNumero.setEditable(false);
        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(8, 8, 0, 8));
        painelCampos.add(new JLabel("Número:"));
        painelCampos.add(campoNumero);
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(campoNome);
        painelCampos.add(new JLabel("Sexo:"));
        painelCampos.add(criarPainelSexo());
        painelCampos.add(new JLabel("Idade:"));
        painelCampos.add(campoIdade);

        JButton botaoOk = new JButton("OK");
        JButton botaoLimpar = new JButton("Limpar");
        JButton botaoMostrar = new JButton("Mostrar");
        JButton botaoSair = new JButton("Sair");
        botaoOk.addActionListener(evento -> cadastrarPessoa());
        botaoLimpar.addActionListener(evento -> limparCampos());
        botaoMostrar.addActionListener(evento -> mostrarPessoa());
        botaoSair.addActionListener(evento -> dispose());

        JPanel painelBotoes = new JPanel(new GridLayout(1, 4));
        painelBotoes.add(botaoOk);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoMostrar);
        painelBotoes.add(botaoSair);

        JPanel painelPrincipal = new JPanel(new BorderLayout(5, 5));
        painelPrincipal.add(painelCampos, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
        add(painelPrincipal);
    }

    private JPanel criarPainelSexo() {
        JPanel painelSexo = new JPanel(new GridLayout(1, 2));
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(sexoMasculino);
        grupoSexo.add(sexoFeminino);
        painelSexo.add(sexoMasculino);
        painelSexo.add(sexoFeminino);
        return painelSexo;
    }

    private void cadastrarPessoa() {
        String nome = campoNome.getText().trim();
        String sexoSelecionado = sexoMasculino.isSelected() ? "M" : sexoFeminino.isSelected() ? "F" : "";
        String idadeTexto = campoIdade.getText().trim();
        if (nome.isEmpty() || sexoSelecionado.isEmpty() || idadeTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha Nome, Sexo e Idade.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int idade = Integer.parseInt(idadeTexto);
            if (idade < 0) {
                throw new IllegalArgumentException("A idade não pode ser negativa.");
            }
            umaPessoa.setNome(nome);
            umaPessoa.setSexo(sexoSelecionado.charAt(0));
            umaPessoa.setIdade(idade);
            umaPessoa.setKp();
            campoNumero.setText(String.valueOf(Pessoa.getKp()));
            JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso.");
        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "A idade deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            campoNome.requestFocusInWindow();
        }
    }

    private void limparCampos() {
        campoNumero.setText("");
        campoNome.setText("");
        sexoMasculino.setSelected(false);
        sexoFeminino.setSelected(false);
        campoIdade.setText("");
        campoNome.requestFocusInWindow();
    }

    private void mostrarPessoa() {
        JOptionPane.showMessageDialog(this, "Número: " + Pessoa.getKp() + "\nNome: " + umaPessoa.getNome() + "\nSexo: " + umaPessoa.getSexo() + "\nIdade: " + umaPessoa.getIdade(), "Dados da Pessoa", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPessoa().setVisible(true));
    }
}
