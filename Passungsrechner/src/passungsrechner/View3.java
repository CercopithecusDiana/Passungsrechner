package passungsrechner;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class View3 extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private Model model;

	public JPanel contentPane;
	JComboBox<String> CBDurchm = new JComboBox<String>();
	JComboBox<String> CBBohrung = new JComboBox<String>();
	JComboBox<String> CBWelle = new JComboBox<String>();
	JTextPane txtPane = new JTextPane();

	JLabel lblNennma = new JLabel("Nennmaß:");
	JLabel lblDtxt = new JLabel("Nennmaß");

	JLabel lblBOA = new JLabel("OA");
	JLabel lblBUA = new JLabel("UA");

	JLabel lblWUA = new JLabel("UA");
	JLabel lblWOA = new JLabel("OA");
	private final JLabel lblHchstspiel = new JLabel("Höchstspiel:");
	private final JLabel lblMindestspiel = new JLabel("Mindestspiel:");
	private final JLabel lblPassung = new JLabel("Passung:");

	JLabel lblHs = new JLabel("HS");
	JLabel lblMs = new JLabel("MS");
	JLabel lblPassungsart = new JLabel("Passungsart");

	BufferedImage x = null;
	ImageIcon icon = new ImageIcon();
	JLabel labelpic = new JLabel( icon);
	private final JLabel label = new JLabel("<html><body><a href=\\\"https://de.wikipedia.org/wiki/Passung\\\">https://de.wikipedia.org/wiki/Passung</a></body></html>");
	//JLabel label2 = new JLabel("<html><body><a href=\"http://javawiki.sowas.com\">http://javawiki.sowas.com</a></body></html>");
	
	
	public View3(Controller controller) {
		label.setForeground(Color.ORANGE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(View3.class.getResource("/passungsrechner/600px-HAL9000.svg.png")));
		lblPassungsart.setForeground(Color.ORANGE);
		lblMs.setForeground(Color.ORANGE);
		lblHs.setForeground(Color.ORANGE);
		lblPassung.setForeground(Color.ORANGE);
		lblMindestspiel.setForeground(Color.ORANGE);
		lblHchstspiel.setForeground(Color.ORANGE);
		setForeground(Color.ORANGE);
		setBackground(Color.DARK_GRAY);
		setTitle("Passungsrechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1153, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		CBBohrung.setEditable(true);
		CBBohrung.setForeground(Color.ORANGE);
		CBBohrung.setBackground(Color.DARK_GRAY);
		CBBohrung.setModel(new DefaultComboBoxModel<String>(new String[] {"D10", "E9", "F7", "F8", "G7", "G9", "H6", "H7", "H8", "H9", "H11", "H12", "H13", "JS7", "JS9", "K6", "K7", "M6", "M7", "N7", "N9", "P7", "P9", "R7"}));
		CBBohrung.setSelectedIndex(0);
		CBBohrung.addActionListener(controller);

		CBWelle.setEditable(true);
		CBWelle.setForeground(Color.ORANGE);
		CBWelle.setBackground(Color.DARK_GRAY);
		CBWelle.setModel(new DefaultComboBoxModel<String>(new String[] {"d9", "e8", "f7", "g6", "h5", "h6", "h7", "h8", "h9", "h11", "js5", "js6", "js13", "js14", "k5", "k6", "m5", "m6", "n5", "n6", "p6", "r6", "s6", "s7"}));
		CBWelle.setSelectedIndex(0);		
		CBWelle.addActionListener(controller);

		JLabel lblBohrungen = new JLabel("Bohrungen:");
		lblBohrungen.setForeground(Color.ORANGE);

		JLabel lblWellen = new JLabel("Wellen:");
		lblWellen.setForeground(Color.ORANGE);

		lblBOA.setForeground(Color.ORANGE);
		lblWOA.setForeground(Color.ORANGE);
		lblBUA.setForeground(Color.ORANGE);
		lblWUA.setForeground(Color.ORANGE);
		lblNennma.setForeground(Color.ORANGE);

		JLabel lblAnwendung = new JLabel("Anwendung:");
		lblAnwendung.setForeground(Color.ORANGE);

		CBDurchm.setEditable(true);
		CBDurchm.setModel(new DefaultComboBoxModel<String>(new String[] {"0 bis 3", "3 bis 6", "6 bis 10", "10 bis 18", "18 bis 30", "30 bis 50", "50 bis 65", "65 bis 80", "80 bis 100", "100 bis 120", "120 bis 140", "140 bis 160", "160 bis 180", "180 bis 200", "200 bis 225", "225 bis 250", "250 bis 280", "280 bis 315", "315 bis 355", "355 bis 400"}));
		CBDurchm.setSelectedIndex(0);
		CBDurchm.setBackground(Color.DARK_GRAY);
		CBDurchm.setForeground(Color.ORANGE);
		CBDurchm.addActionListener(controller);

		lblDtxt.setForeground(Color.ORANGE);

		txtPane.setBackground(Color.BLACK);
		txtPane.setForeground(Color.ORANGE);

		//Font font = label.getFont();
		

		//create some css from the label's font
		//StringBuffer style = new StringBuffer("font-family:" + font.getFamily() + ";");
		//style.append("font-weight:" + (font.isBold() ? "bold" : "normal") + ";");
		//style.append("font-size:" + font.getSize() + "pt;");	
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() > 0) {
					try {
						Desktop.getDesktop().browse(new URI("https://de.wikipedia.org/wiki/Passung"));
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblWellen)
											.addComponent(lblBohrungen)
											.addComponent(lblNennma)
											.addComponent(lblHchstspiel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(CBBohrung, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(CBDurchm, 0, 0, Short.MAX_VALUE)
											.addComponent(CBWelle, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblHs, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblMs)
											.addComponent(lblPassungsart))
										.addGap(33))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblMindestspiel)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPassung)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblWOA, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBOA))
									.addGap(76)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblWUA, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBUA, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblDtxt)))
						.addComponent(lblAnwendung)
						.addComponent(txtPane, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelpic, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBohrungen)
								.addComponent(lblBOA)
								.addComponent(lblBUA)
								.addComponent(CBBohrung, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWellen, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(CBWelle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWOA)
								.addComponent(lblWUA))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(78)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblHchstspiel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHs, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(CBDurchm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNennma)
										.addComponent(lblDtxt))))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMindestspiel)
								.addComponent(lblMs))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassung)
								.addComponent(lblPassungsart))
							.addGap(47)
							.addComponent(lblAnwendung)
							.addGap(28)
							.addComponent(txtPane, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(labelpic, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void update(Observable arg, Object arg1) {

		if(arg instanceof Model){
			lblDtxt.setText(model.getD());
		}
	}
}