package windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

import profiles.Account;
import profiles.ParentProfile;
import tasks.Task;

/**
 * Done!
 * 
 * A panel that is reached when a user clicks the button "Sysslor" on
 * ParentHomeWindow. Here the user (parent) can look through the list of tasks
 * and also add a new task.
 * 
 * @author Angelina Fransson, Henrik Sigeman, Maida Sijaric
 *
 */
@SuppressWarnings({ "unchecked", "serial" })
public class ParentTaskWindow extends JPanel implements ActionListener {
	private Account account;
	private ParentProfile parentProfile;
	private JLabel lblChildTask;

	private ClientController controller;

	
	private JButton btnHome;
	private JButton btnAddTask;
	private JButton btnEditTask;
	private JButton btnProfile;
	private ImageIcon dustBallImage;

	@SuppressWarnings("rawtypes")
	private DefaultListModel model = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	private JList taskList = new JList(model);

	public Account getAccount() {
		return account;
	}

	public ParentProfile getParentProfile() {
		return parentProfile;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setParentProfile(ParentProfile parentProfile) {
		this.parentProfile = parentProfile;
	}

	public void setBtnHome(JButton btnHome) {
		this.btnHome = btnHome;
	}

	public void setBtnAddTask(JButton btnAddTask) {
		this.btnAddTask = btnAddTask;
	}

	public void setBtnEditTask(JButton btnEditTask) {
		this.btnEditTask = btnEditTask;
	}

	public ParentTaskWindow(ClientController clientController) {

		this.controller = clientController;
		start();

	}

	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);

	}

	/*
	 * Set sizes and add components
	 */
	@SuppressWarnings({ "unchecked", "unchecked", "unchecked" })
	private void InitializeGUI() {

		// PnlMain
		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		// Top panel
		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		// Label in the middle of pnlTop
		lblChildTask = new JLabel("Barnens sysslor");
		lblChildTask.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblChildTask.setBounds(105, 30, 285, 20);
		pnlTop.add(lblChildTask);

		btnHome = new JButton();
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 75, 70);
		btnHome.addActionListener(this);
		pnlTop.add(btnHome);

		btnProfile = new JButton();
		btnProfile.addActionListener(this);
		dustBallImage = (new ImageIcon(
				controller.getPictures().getImage(controller.getParentProfile().getImageString())));
		btnProfile.setBounds(275, 16, 75, 70);
		btnProfile.setIcon(dustBallImage);

		pnlTop.add(btnProfile);

		taskList.setCellRenderer(new TaskRenderer());
		JScrollPane taskScroll = new JScrollPane(taskList);
		taskScroll.setBounds(12, 130, 358, 140);
		GridBagConstraints c = new GridBagConstraints();


		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;

		updateTasks();

		// Bottom panel
		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);

		btnAddTask = new JButton(" L�gg till en syssla ");
		btnAddTask.addActionListener(this);
		btnAddTask.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnAddTask.setBackground(Color.GREEN);
		btnAddTask.setForeground(Color.BLACK);
		btnAddTask.setBounds(10, 16, 300, 50);
		pnlBottom.add(btnAddTask);

		btnEditTask = new JButton(" Redigera/Ta bort syssla ");
		btnEditTask.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnEditTask.setBackground(Color.RED);
		btnEditTask.setForeground(Color.BLACK);
		btnEditTask.setBounds(10, 100, 300, 50);
		pnlBottom.add(btnEditTask);

		this.add(pnlTop);
		this.add(taskScroll);
		// this.add(pnlMiddle);
		this.add(pnlBottom);

	}

	@Override

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHome) {
			controller.setViewParentHomeWindow();
		}
		if (e.getSource() == btnAddTask) {
			controller.setViewParentEditTaskWindow();
		}
		if (e.getSource() == btnProfile) {
			controller.setViewParentProfileWindow();
		}

	}

	public void updateTasks() {
		model.clear();

		for (int i = 0; i < controller.getAccount().getTaskList().size(); i++) {
			Task task = controller.getAccount().getTaskList().get(i);
			model.addElement(task);
		}
	}

	private class TaskRenderer implements ListCellRenderer {
		private ActionListener listener;
		private JButton completedButton;

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

				}
			};
			// TODO Auto-generated method stub
			completedButton = new JButton("Godk�nn");
			completedButton.addActionListener(listener);
			JPanel panel = new JPanel(new GridLayout(2, 4));
			Task task = (Task) value;
			panel.add(new JLabel(task.getLocationName()));
			panel.add(new JLabel(task.getChoreName()));
			panel.add(new JLabel("" + task.getTaskValue()));

			if (task.getCompleted()) {
				panel.add(new JLabel("F�rdig"));
				completedButton.setEnabled(true);
			} else {
				panel.add(new JLabel("Ej f�rdig"));
				completedButton.setEnabled(false);
			}
			panel.add(completedButton);

			return panel;
		}

	}

	/**
	 * 
	 * @author Henrik Sigeman
	 * 
	 */

	private class TaskPanel extends JPanel {
		private String locationName = "";
		private String choreName = "";
		private int choreValue = 0;
		private JLabel location;
		private JLabel chore;
		private JLabel value;
		private JLabel done;

		public TaskPanel(String locationName, String choreName, int choreValue) {
			this.locationName = locationName;
			this.choreName = choreName;
			this.choreValue = choreValue;
			location = new JLabel(locationName);
			chore = new JLabel(choreName);
			value = new JLabel("" + choreValue);
			done = new JLabel("Inte f�rdig");
			setLayout(new GridBagLayout());
			setBackground(Color.YELLOW);

			GridBagConstraints c = new GridBagConstraints();

			Border border = BorderFactory.createEtchedBorder();
			location.setFont(new Font("SansSerif", Font.BOLD, 12));
			location.setBorder(border);
			chore.setFont(new Font("SansSerif", Font.BOLD, 12));
			chore.setBorder(border);
			value.setFont(new Font("SansSerif", Font.BOLD, 12));
			value.setBorder(border);
			done.setFont(new Font("SansSerif", Font.BOLD, 12));
			done.setBorder(border);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.anchor = GridBagConstraints.NORTHWEST;
			c.weightx = 1;
			c.weighty = 1;

			add(location, c);
			add(chore, c);
			add(value, c);
			add(done, c);
		}

	}
}
