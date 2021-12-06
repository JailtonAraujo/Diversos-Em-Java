package Fila_Pilha_De_Execucao_Com_Thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaExemplo extends JDialog{
	
	private JPanel jpanel = new JPanel(new GridBagLayout());
	private JLabel descricaoHora = new JLabel("Time Thread 1");
	private JTextField MostraTempo = new JTextField();
	private JLabel descracaoHora2 = new JLabel("Time Thread 2");
	private JTextField MostrarTempo2 = new JTextField();
	private JButton btnStart = new JButton("Add Lista");
	private JButton btnStop = new JButton("STOP");

	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	public TelaExemplo() {

		setTitle("Tela com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);

		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridwidth = 2;
		grid.insets = new Insets(5, 10, 5, 5);
		grid.anchor = GridBagConstraints.WEST;

		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jpanel.add(descricaoHora, grid);

		MostraTempo.setPreferredSize(new Dimension(200, 25));
		//MostraTempo.setEditable(false);
		grid.gridy++;
		jpanel.add(MostraTempo, grid);

		descracaoHora2.setPreferredSize(new Dimension(200, 25));
		grid.gridy++;
		jpanel.add(descracaoHora2, grid);

		MostrarTempo2.setPreferredSize(new Dimension(200, 25));
		//MostrarTempo2.setEditable(false);
		grid.gridy++;
		jpanel.add(MostrarTempo2, grid);

		grid.gridwidth = 1;

		btnStart.setPreferredSize(new Dimension(95, 25));
		grid.gridy++;
		jpanel.add(btnStart, grid);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}
				
				for(int i = 0; i < 100; i++) {
					ObjectFilaThread filaThread = new ObjectFilaThread();
					filaThread.setNome(MostraTempo.getText());
					filaThread.setEmail(MostrarTempo2.getText()+"-"+i);
					fila.add(filaThread);
				}
				
			
			}
		});

		btnStop.setPreferredSize(new Dimension(95, 25));
		grid.gridx++;
		jpanel.add(btnStop, grid);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fila.stop();
				fila = null;
			}
		});

		fila.start();
		
		add(jpanel, BorderLayout.WEST);

		setVisible(true);
		// TODO Auto-generated constructor stub
	}

}
