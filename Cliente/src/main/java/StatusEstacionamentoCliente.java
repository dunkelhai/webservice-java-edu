import com.estacionamento.integracao.StatusBean;
import com.estacionamento.integracao.StatusEstacionamentoService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class StatusEstacionamentoCliente extends JFrame {

	private JLabel slblFaturamento = new JLabel("Faturamento");
	private JLabel slblDisponibilidade = new JLabel("Disponibilidade");
	private JLabel slblOcupacao = new JLabel("Ocupação");

	private JLabel lblFaturamento = new JLabel("---");
	private JLabel lblDisponibilidade = new JLabel("---");
	private JLabel lblOcupacao = new JLabel("---");

	private StatusEstacionamentoService statusService;

	public static void main(String args[]) throws Exception {
		StatusEstacionamentoCliente cliente = new StatusEstacionamentoCliente();
		cliente.setVisible(true);
	}

	public StatusEstacionamentoCliente() throws MalformedURLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Status do Estacionamento");
		this.setSize(new Dimension(600, 200));

		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JButton btnAtualizar = new JButton("Atualizar Status");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statusService = carregarServico();
					StatusBean bean = statusService.getStatus();
					carregarLabels(bean);
					lblFaturamento.setText(String.valueOf(statusService.getStatus().getFaturamentoDia()));
					lblDisponibilidade.setText(String.valueOf(statusService.getStatus().getVagasLivres()));
					lblOcupacao.setText(String.valueOf(statusService.getStatus().getVagasOcupadas()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnAtualizar, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		slblFaturamento.setBackground(new Color(255, 255, 0));
		slblFaturamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		slblFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(slblFaturamento, BorderLayout.NORTH);
		lblFaturamento.setForeground(Color.BLUE);
		lblFaturamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblFaturamento, BorderLayout.CENTER);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		slblOcupacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		slblOcupacao.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(slblOcupacao, BorderLayout.NORTH);
		lblOcupacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcupacao.setForeground(Color.BLUE);
		lblOcupacao.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(lblOcupacao, BorderLayout.CENTER);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		slblDisponibilidade.setHorizontalAlignment(SwingConstants.CENTER);
		slblDisponibilidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(slblDisponibilidade, BorderLayout.NORTH);
		lblDisponibilidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisponibilidade.setForeground(Color.BLUE);
		lblDisponibilidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(lblDisponibilidade, BorderLayout.CENTER);
	}

	private StatusEstacionamentoService carregarServico() throws MalformedURLException{
		StatusEstacionamentoService service = null;
		URL url = new URL("http://127.1.1.0:8888/status?WSDL");
		QName qname = new QName("http://integracao.estacionamento.com/", "StatusEstacionamentoServiceImplService");

		try {
			Service srv = Service.create(url, qname);
			service = srv.getPort(StatusEstacionamentoService.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return service;
	}
}
