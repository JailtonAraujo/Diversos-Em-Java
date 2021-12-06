package ThreadTime;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;

public class TelaTimeThread extends JDialog {

	private JPanel jpanel = new JPanel(new GridBagLayout());
	private JLabel descricaoHora = new JLabel("Time Thread 1");
	private JTextField MostraTempo = new JTextField();
	private JLabel descracaoHora2 = new JLabel("Time Thread 2");
	private JTextField MostrarTempo2 = new JTextField();
	private JButton btnStart = new JButton("START");
	private JButton btnStop = new JButton("STOP");

	//*Primeira Thread*//
	private Runnable ThreadTempo1 = new Runnable() {

		@Override
		public void run() {
			while (true) {

				MostraTempo
						.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// TODO Auto-generated method stub

			}
		}

	};
	
	private Runnable ThreadTempo2 = new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				MostrarTempo2.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			// TODO Auto-generated method stub
			
		}
	};

	private Thread thread1;
	private Thread thread2;

	public TelaTimeThread() {

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
		MostraTempo.setEditable(false);
		grid.gridy++;
		jpanel.add(MostraTempo, grid);

		descracaoHora2.setPreferredSize(new Dimension(200, 25));
		grid.gridy++;
		jpanel.add(descracaoHora2, grid);

		MostrarTempo2.setPreferredSize(new Dimension(200, 25));
		MostrarTempo2.setEditable(false);
		grid.gridy++;
		jpanel.add(MostrarTempo2, grid);

		grid.gridwidth = 1;

		btnStart.setPreferredSize(new Dimension(95, 25));
		grid.gridy++;
		jpanel.add(btnStart, grid);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread1 = new Thread(ThreadTempo1);
				thread1.start();
				
				thread2 = new Thread(ThreadTempo2);
				thread2.start();
			}
		});

		btnStop.setPreferredSize(new Dimension(95, 25));
		grid.gridx++;
		jpanel.add(btnStop, grid);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread1.stop();
				thread2.stop();
			}
		});

		add(jpanel, BorderLayout.WEST);

		setVisible(true);
		// TODO Auto-generated constructor stub
	}
}
