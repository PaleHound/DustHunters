package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * This GUI-class is intended to show the current point score of the individual
 * family members, as well as the family as a 'team'. Points are used to gain
 * rewards.
 * 
 * @author Kasper
 *
 */

public class ParentRewardWindow extends JPanel implements ActionListener {

	private JButton btnHome;
	private JButton btnProfile;
	private JButton btnNewReward;
	private JLabel lblRewards;
	private ImageIcon imageHome;
	private ImageIcon imageProfile;
	private ClientController controller;

	public ParentRewardWindow(ClientController clientController) throws IOException {
		this.setClientController(clientController);
		start();
	}

	public void start() throws IOException {

		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
	}

	/**
	 * This method sets up the main, top, middle and bottom panels of the window,
	 * including all the graphical elements.
	 * 
	 * @throws IOException
	 */

	public void InitializeGUI() throws IOException {

		// Main
		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		// Top
		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 90);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		lblRewards = new JLabel("   Po�ng");
		lblRewards.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblRewards.setBounds(125, 30, 285, 20);
		pnlTop.add(lblRewards);

		imageHome = new ImageIcon("images/House.jpg");
		btnHome = new JButton();
		btnHome.setBounds(10, 16, 75, 70);
		btnHome.setIcon(imageHome);
		pnlTop.add(btnHome);

		imageProfile = (new ImageIcon(
				controller.getPictures().getImage(controller.getParentProfile().getImageString())));
		btnProfile = new JButton();
		btnProfile.setBounds(275, 16, 75, 70);
		btnProfile.setIcon(imageProfile);
		pnlTop.add(btnProfile);

		// Middle
		JPanel pnlInfo = new JPanel();
		pnlInfo.setBounds(12, 130, 358, 300);
		pnlInfo.setLayout(new GridBagLayout());
		pnlInfo.setBackground(Color.YELLOW);
		GridBagConstraints c = new GridBagConstraints();

		JLabel lblChild1 = new JLabel("HENRIK");
		JLabel lblChild2 = new JLabel("SARA");
		JLabel lblChild3 = new JLabel("ANGELINA");
		JLabel lblChild4 = new JLabel("MAIDA");
		JLabel lblChild5 = new JLabel("KASPER");

		JProgressBar pbChild1 = new JProgressBar(0);
		pbChild1.setValue(0);
		pbChild1.setStringPainted(true);

		JProgressBar pbChild2 = new JProgressBar(0);
		pbChild2.setValue(0);
		pbChild2.setStringPainted(true);

		JProgressBar pbChild3 = new JProgressBar(0);
		pbChild3.setValue(0);
		pbChild3.setStringPainted(true);

		JProgressBar pbChild4 = new JProgressBar(0);
		pbChild4.setValue(0);
		pbChild4.setStringPainted(true);

		JProgressBar pbChild5 = new JProgressBar(0);
		pbChild5.setValue(0);
		pbChild5.setStringPainted(true);

		lblChild1.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblChild2.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblChild3.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblChild4.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblChild5.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		pnlInfo.add(lblChild1, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		pnlInfo.add(pbChild1, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 1;
		pnlInfo.add(lblChild2, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 1;
		pnlInfo.add(pbChild2, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 2;
		pnlInfo.add(lblChild3, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 2;
		pnlInfo.add(pbChild3, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 3;
		pnlInfo.add(lblChild4, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 3;
		pnlInfo.add(pbChild4, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 4;
		pnlInfo.add(lblChild5, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 4;
		pnlInfo.add(pbChild5, c);

		// Bottom
		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 450, 358, 65);
		pnlBottom.setLayout(new GridBagLayout());
		pnlBottom.setBackground(Color.YELLOW);
		GridBagConstraints c2 = new GridBagConstraints();

		JLabel lblTeam = new JLabel("FAMILJEN");
		lblTeam.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));

		JProgressBar pbTeam = new JProgressBar(0);
		pbTeam.setValue(0);
		pbTeam.setStringPainted(true);

		btnNewReward = new JButton("Ny Bel�ning");
		btnNewReward.setBounds(12, 30, 50, 30);

		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.anchor = GridBagConstraints.NORTHEAST;
		c2.weightx = 1;
		c2.weighty = 1;
		c2.gridx = 0;
		c2.gridy = 1;
		pnlBottom.add(lblTeam, c2);

		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.anchor = GridBagConstraints.NORTHEAST;
		c2.weightx = 1;
		c2.weighty = 1;
		c2.gridx = 0;
		c2.gridy = 1;
		pnlBottom.add(pbTeam, c2);

		c2.weightx = 1;
		c2.weighty = 1;
		c2.gridx = 0;
		c2.gridy = 2;

		pnlBottom.add(btnNewReward, c2);

		// // ActionListeners
		btnHome.addActionListener(this);
		btnProfile.addActionListener(this);
		btnNewReward.addActionListener(this);

		this.add(pnlTop);
		this.add(pnlInfo);
		this.add(pnlBottom);

	}

	/**
	 * Handles the interaction the user does with the buttons, and redirects to
	 * either ParentHomeWindow, ParentProfileWindow, or ParentCreateRewardWindow.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnHome) {
			controller.setViewParentHomeWindow();
		}
		if (e.getSource() == btnProfile) {
			controller.setViewParentProfileWindow();
		}
		if (e.getSource() == btnNewReward) {
			controller.setViewParentCreateRewardWindow();
		}

	}

	public ClientController getClientController() {
		return controller;
	}

	public void setClientController(ClientController clientController) {
		this.controller = clientController;
	}

}
