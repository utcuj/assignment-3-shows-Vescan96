package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.History;
import model.Movies;
import model.Sports;
import model.Theatres;
import model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdminFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField nameText;
	private JTextField descrText;
	private JTextField actText;
	private JTextField relDateText;
	private JTextField ratingText;
	private JTextField commText;
	private JTextField newNameText;
	private JTextField newDescrText;
	private JTextField newActText;
	private JTextField newRelDateText;
	private JTextField newRatingText;
	private JTextField newCommText;
	private JTable movieTable;
	private JTextField newTCommText;
	private JTextField newTRatingText;
	private JTextField newTRelDateText;
	private JTextField newTActText;
	private JTextField newTDescrText;
	private JTextField newTNameText;
	private JTextField tCommText;
	private JTextField tRatingText;
	private JTextField tRelDateText;
	private JTextField tActText;
	private JTextField tDescrText;
	private JTextField tNameText;
	private JTextField newResultText;
	private JTextField newEventDateText;
	private JTextField newTeam2Text;
	private JTextField newTeam1Text;
	private JTextField newSDescrText;
	private JTextField newSNameText;
	private JTextField sCommText;
	private JTextField sResultText;
	private JTextField sEventDateText;
	private JTextField team2Text;
	private JTextField team1Text;
	private JTextField sDescrText;
	private JTextField sNameText;
	private JTable theatreTable;
	private JTable table_2;
	private JTextField newSCommText;
	private JTextField uNameText;
	private JTextField uPassText;
	private JTextField accText;
	private JTextField newUNameText;
	private JTextField newUPassText;
	private JTextField newAccText;
	private JTable userTable;
	private JButton createMovie;
	private JButton viewMovies;
	private JButton updateMovie;
	private JButton deleteMovie;
	private JButton createTheatre;
	private JButton viewTheatre;
	private JButton updateTheatre;
	private JButton deleteTheatre;
	private JButton createEvent;
	private JButton viewEvent;
	private JButton updateEvent;
	private JButton deleteEvent;
	private JButton createUser;
	private JButton viewUser;
	private JButton updateUser;
	private JButton deleteUser;

	private DefaultTableModel movieModel;

	private DefaultTableModel userModel;

	private DefaultTableModel theatreModel;

	private DefaultTableModel sportModel;
	
	public AdminFrame() {
		setResizable(false);
		setTitle("Admin Frame");
		setSize(650, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 782, 603);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("movie", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblSearchShow = new JLabel("name");
		lblSearchShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchShow.setBounds(25, 20, 150, 20);
		panel.add(lblSearchShow);
		
		nameText = new JTextField();
		nameText.setBounds(200, 20, 150, 25);
		panel.add(nameText);
		nameText.setColumns(10);
		
		descrText = new JTextField();
		descrText.setColumns(10);
		descrText.setBounds(200, 50, 150, 25);
		panel.add(descrText);
		
		actText = new JTextField();
		actText.setColumns(10);
		actText.setBounds(200, 80, 150, 25);
		panel.add(actText);
		
		relDateText = new JTextField();
		relDateText.setColumns(10);
		relDateText.setBounds(200, 110, 150, 25);
		panel.add(relDateText);
		
		ratingText = new JTextField();
		ratingText.setColumns(10);
		ratingText.setBounds(200, 140, 150, 25);
		panel.add(ratingText);
			
		commText = new JTextField();
		commText.setColumns(10);
		commText.setBounds(200, 170, 150, 25);
		panel.add(commText);
		
		createMovie = new JButton("create movie");
		createMovie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		createMovie.setBounds(400, 50, 180, 40);
		panel.add(createMovie);
		
		viewMovies = new JButton("view movies");
		viewMovies.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewMovies.setBounds(400, 130, 180, 40);
		panel.add(viewMovies);
		
		updateMovie = new JButton("update movie");
		updateMovie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updateMovie.setBounds(400, 210, 180, 40);
		panel.add(updateMovie);
		
		deleteMovie = new JButton("delete movie");
		deleteMovie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteMovie.setBounds(400, 290, 180, 40);
		panel.add(deleteMovie);
		
		JLabel lblDescription = new JLabel("description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescription.setBounds(25, 50, 150, 20);
		panel.add(lblDescription);
		
		JLabel lblActors = new JLabel("actors");
		lblActors.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActors.setBounds(25, 80, 150, 20);
		panel.add(lblActors);
		
		JLabel lblReleaseDate = new JLabel("release date");
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReleaseDate.setBounds(25, 110, 150, 20);
		panel.add(lblReleaseDate);
		
		JLabel lblRating = new JLabel("rating");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRating.setBounds(25, 140, 150, 25);
		panel.add(lblRating);
		
		JLabel lblNewName = new JLabel("new name");
		lblNewName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewName.setBounds(25, 230, 150, 20);
		panel.add(lblNewName);
		
		JLabel lblNewDescription = new JLabel("new description");
		lblNewDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewDescription.setBounds(25, 260, 150, 20);
		panel.add(lblNewDescription);
		
		JLabel lblNewActors = new JLabel("new actors");
		lblNewActors.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewActors.setBounds(25, 290, 150, 20);
		panel.add(lblNewActors);
		
		JLabel lblNewReleaseDate = new JLabel("new release date");
		lblNewReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewReleaseDate.setBounds(25, 320, 160, 20);
		panel.add(lblNewReleaseDate);
		
		JLabel lblNewRating = new JLabel("new rating");
		lblNewRating.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewRating.setBounds(25, 350, 150, 25);
		panel.add(lblNewRating);
		
		JLabel lblComments = new JLabel("comments");
		lblComments.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblComments.setBounds(25, 170, 150, 20);
		panel.add(lblComments);
		
		JLabel lblNewComments = new JLabel("new comments");
		lblNewComments.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewComments.setBounds(25, 380, 150, 25);
		panel.add(lblNewComments);
		
		newNameText = new JTextField();
		newNameText.setColumns(10);
		newNameText.setBounds(200, 230, 150, 25);
		panel.add(newNameText);
		
		newDescrText = new JTextField();
		newDescrText.setColumns(10);
		newDescrText.setBounds(200, 260, 150, 25);
		panel.add(newDescrText);
		
		newActText = new JTextField();
		newActText.setColumns(10);
		newActText.setBounds(200, 290, 150, 25);
		panel.add(newActText);
		
		newRelDateText = new JTextField();
		newRelDateText.setColumns(10);
		newRelDateText.setBounds(200, 320, 150, 25);
		panel.add(newRelDateText);
		
		newRatingText = new JTextField();
		newRatingText.setColumns(10);
		newRatingText.setBounds(200, 350, 150, 25);
		panel.add(newRatingText);
		
		newCommText = new JTextField();
		newCommText.setColumns(10);
		newCommText.setBounds(200, 380, 150, 25);
		panel.add(newCommText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 420, 620, 190);
		panel.add(scrollPane);
		
		movieTable = new JTable();
		movieTable.setRowSelectionAllowed(false);
		movieTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		movieTable.setModel(movieModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Description", "Actors", "ReleaseDate", "Rating", "Comments"
			}
		));
		movieTable.setEnabled(false);
		scrollPane.setViewportView(movieTable);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("theatre", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(25, 20, 150, 20);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("description");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(25, 50, 150, 20);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("actors");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(25, 80, 150, 20);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("release date");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(25, 110, 150, 20);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("rating");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(25, 140, 150, 25);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("comments");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(25, 170, 150, 20);
		panel_1.add(label_5);
		
		JLabel label_9 = new JLabel("new name");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_9.setBounds(25, 230, 150, 20);
		panel_1.add(label_9);
		
		JLabel label_11 = new JLabel("new description");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_11.setBounds(25, 260, 150, 20);
		panel_1.add(label_11);
		
		JLabel label_13 = new JLabel("new actors");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_13.setBounds(25, 290, 150, 20);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("new release date");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_14.setBounds(25, 320, 160, 20);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("new rating");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_15.setBounds(25, 350, 150, 25);
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("new comments");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_16.setBounds(25, 380, 150, 25);
		panel_1.add(label_16);
		
		newTCommText = new JTextField();
		newTCommText.setColumns(10);
		newTCommText.setBounds(200, 380, 150, 25);
		panel_1.add(newTCommText);
		
		newTRatingText = new JTextField();
		newTRatingText.setColumns(10);
		newTRatingText.setBounds(200, 350, 150, 25);
		panel_1.add(newTRatingText);
		
		newTRelDateText = new JTextField();
		newTRelDateText.setColumns(10);
		newTRelDateText.setBounds(200, 320, 150, 25);
		panel_1.add(newTRelDateText);
		
		newTActText = new JTextField();
		newTActText.setColumns(10);
		newTActText.setBounds(200, 290, 150, 25);
		panel_1.add(newTActText);
		
		newTDescrText = new JTextField();
		newTDescrText.setColumns(10);
		newTDescrText.setBounds(200, 260, 150, 25);
		panel_1.add(newTDescrText);
		
		newTNameText = new JTextField();
		newTNameText.setColumns(10);
		newTNameText.setBounds(200, 230, 150, 25);
		panel_1.add(newTNameText);
		
		tCommText = new JTextField();
		tCommText.setColumns(10);
		tCommText.setBounds(200, 170, 150, 25);
		panel_1.add(tCommText);
		
		tRatingText = new JTextField();
		tRatingText.setColumns(10);
		tRatingText.setBounds(200, 140, 150, 25);
		panel_1.add(tRatingText);
		
		tRelDateText = new JTextField();
		tRelDateText.setColumns(10);
		tRelDateText.setBounds(200, 110, 150, 25);
		panel_1.add(tRelDateText);
		
		tActText = new JTextField();
		tActText.setColumns(10);
		tActText.setBounds(200, 80, 150, 25);
		panel_1.add(tActText);
		
		tDescrText = new JTextField();
		tDescrText.setColumns(10);
		tDescrText.setBounds(200, 50, 150, 25);
		panel_1.add(tDescrText);
		
		tNameText = new JTextField();
		tNameText.setColumns(10);
		tNameText.setBounds(200, 20, 150, 25);
		panel_1.add(tNameText);
		
		createTheatre = new JButton("create theatre");
		createTheatre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		createTheatre.setBounds(400, 50, 180, 40);
		panel_1.add(createTheatre);
		
		viewTheatre = new JButton("view theatre");
		viewTheatre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewTheatre.setBounds(400, 130, 180, 40);
		panel_1.add(viewTheatre);
		
		updateTheatre = new JButton("update theatre");
		updateTheatre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updateTheatre.setBounds(400, 210, 180, 40);
		panel_1.add(updateTheatre);
		
		deleteTheatre = new JButton("delete theatre");
		deleteTheatre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteTheatre.setBounds(400, 290, 180, 40);
		panel_1.add(deleteTheatre);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 420, 620, 190);
		panel_1.add(scrollPane_1);
		
		theatreTable = new JTable();
		theatreTable.setRowSelectionAllowed(false);
		theatreTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		theatreTable.setModel(theatreModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Description", "Actors", "ReleaseDate", "Rating", "Comments"
			}
		));
		scrollPane_1.setViewportView(theatreTable);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("sport", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_7 = new JLabel("name");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_7.setBounds(25, 20, 150, 20);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("description");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_8.setBounds(25, 50, 150, 20);
		panel_2.add(label_8);
		
		JLabel lblTeam = new JLabel("team 1");
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTeam.setBounds(25, 80, 150, 20);
		panel_2.add(lblTeam);
		
		JLabel lblEventDate = new JLabel("team 2");
		lblEventDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEventDate.setBounds(25, 110, 150, 20);
		panel_2.add(lblEventDate);
		
		JLabel lblEventDate_1 = new JLabel("event date");
		lblEventDate_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEventDate_1.setBounds(25, 140, 150, 20);
		panel_2.add(lblEventDate_1);
		
		JLabel lblResult = new JLabel("result");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResult.setBounds(25, 170, 150, 20);
		panel_2.add(lblResult);
		
		JLabel lblComments_1 = new JLabel("comments");
		lblComments_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblComments_1.setBounds(25, 200, 150, 25);
		panel_2.add(lblComments_1);
		
		JLabel label_21 = new JLabel("new name");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_21.setBounds(25, 230, 150, 20);
		panel_2.add(label_21);
		
		JLabel label_22 = new JLabel("new description");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_22.setBounds(25, 260, 150, 20);
		panel_2.add(label_22);
		
		JLabel lblNewTeam = new JLabel("new team 1");
		lblNewTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewTeam.setBounds(25, 290, 150, 20);
		panel_2.add(lblNewTeam);
		
		JLabel lblNewEventDate = new JLabel("new team 2");
		lblNewEventDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewEventDate.setBounds(25, 320, 160, 20);
		panel_2.add(lblNewEventDate);
		
		JLabel lblNewRating_1 = new JLabel("new event date");
		lblNewRating_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewRating_1.setBounds(25, 350, 150, 25);
		panel_2.add(lblNewRating_1);
		
		JLabel lblNewResult = new JLabel("new result");
		lblNewResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewResult.setBounds(25, 380, 150, 25);
		panel_2.add(lblNewResult);
		
		newResultText = new JTextField();
		newResultText.setColumns(10);
		newResultText.setBounds(200, 380, 150, 25);
		panel_2.add(newResultText);
		
		newEventDateText = new JTextField();
		newEventDateText.setColumns(10);
		newEventDateText.setBounds(200, 350, 150, 25);
		panel_2.add(newEventDateText);
		
		newTeam2Text = new JTextField();
		newTeam2Text.setColumns(10);
		newTeam2Text.setBounds(200, 320, 150, 25);
		panel_2.add(newTeam2Text);
		
		newTeam1Text = new JTextField();
		newTeam1Text.setColumns(10);
		newTeam1Text.setBounds(200, 290, 150, 25);
		panel_2.add(newTeam1Text);
		
		newSDescrText = new JTextField();
		newSDescrText.setColumns(10);
		newSDescrText.setBounds(200, 260, 150, 25);
		panel_2.add(newSDescrText);
		
		newSNameText = new JTextField();
		newSNameText.setColumns(10);
		newSNameText.setBounds(200, 230, 150, 25);
		panel_2.add(newSNameText);
		
		sCommText = new JTextField();
		sCommText.setColumns(10);
		sCommText.setBounds(200, 200, 150, 25);
		panel_2.add(sCommText);
		
		sResultText = new JTextField();
		sResultText.setColumns(10);
		sResultText.setBounds(200, 170, 150, 25);
		panel_2.add(sResultText);
		
		sEventDateText = new JTextField();
		sEventDateText.setColumns(10);
		sEventDateText.setBounds(200, 140, 150, 25);
		panel_2.add(sEventDateText);
		
		team2Text = new JTextField();
		team2Text.setColumns(10);
		team2Text.setBounds(200, 110, 150, 25);
		panel_2.add(team2Text);
		
		team1Text = new JTextField();
		team1Text.setColumns(10);
		team1Text.setBounds(200, 80, 150, 25);
		panel_2.add(team1Text);
		
		sDescrText = new JTextField();
		sDescrText.setColumns(10);
		sDescrText.setBounds(200, 50, 150, 25);
		panel_2.add(sDescrText);
		
		sNameText = new JTextField();
		sNameText.setColumns(10);
		sNameText.setBounds(200, 20, 150, 25);
		panel_2.add(sNameText);
		
		createEvent = new JButton("create event");
		createEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		createEvent.setBounds(400, 50, 180, 40);
		panel_2.add(createEvent);
		
		viewEvent = new JButton("view event");
		viewEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewEvent.setBounds(400, 130, 180, 40);
		panel_2.add(viewEvent);
		
		updateEvent = new JButton("update event");
		updateEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updateEvent.setBounds(400, 210, 180, 40);
		panel_2.add(updateEvent);
		
		deleteEvent = new JButton("delete event");
		deleteEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteEvent.setBounds(400, 290, 180, 40);
		panel_2.add(deleteEvent);
		
		JScrollPane sportTable = new JScrollPane();
		sportTable.setBounds(10, 450, 620, 160);
		panel_2.add(sportTable);
		
		table_2 = new JTable();
		table_2.setRowSelectionAllowed(false);
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_2.setModel(sportModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Description", "ActorsOrTeams", "Event date", "Result", "Comments"
			}
		));
		sportTable.setViewportView(table_2);
		
		JLabel lblNewComments_1 = new JLabel("new comments");
		lblNewComments_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewComments_1.setBounds(25, 410, 150, 25);
		panel_2.add(lblNewComments_1);
		
		newSCommText = new JTextField();
		newSCommText.setColumns(10);
		newSCommText.setBounds(200, 410, 150, 25);
		panel_2.add(newSCommText);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("user", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(22, 24, 200, 30);
		panel_3.add(lblNewLabel);
		
		JLabel password = new JLabel("password");
		password.setFont(new Font("Tahoma", Font.PLAIN, 25));
		password.setBounds(22, 79, 200, 30);
		panel_3.add(password);
		
		JLabel lblPremiumAccount = new JLabel("premium account");
		lblPremiumAccount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPremiumAccount.setBounds(22, 141, 250, 30);
		panel_3.add(lblPremiumAccount);
		
		JLabel lblNewAccountName = new JLabel("new premium acc");
		lblNewAccountName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewAccountName.setBounds(22, 341, 250, 30);
		panel_3.add(lblNewAccountName);
		
		JLabel lblNewAge = new JLabel("new password");
		lblNewAge.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewAge.setBounds(22, 279, 200, 30);
		panel_3.add(lblNewAge);
		
		JLabel lblNewName_1 = new JLabel("new name");
		lblNewName_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewName_1.setBounds(22, 224, 200, 30);
		panel_3.add(lblNewName_1);
		
		uNameText = new JTextField();
		uNameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		uNameText.setBounds(234, 24, 150, 30);
		panel_3.add(uNameText);
		uNameText.setColumns(10);
		
		uPassText = new JTextField();
		uPassText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		uPassText.setColumns(10);
		uPassText.setBounds(234, 79, 150, 30);
		panel_3.add(uPassText);
		
		accText = new JTextField();
		accText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		accText.setColumns(10);
		accText.setBounds(234, 141, 150, 30);
		panel_3.add(accText);
		
		newUNameText = new JTextField();
		newUNameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newUNameText.setColumns(10);
		newUNameText.setBounds(234, 224, 150, 30);
		panel_3.add(newUNameText);
		
		newUPassText = new JTextField();
		newUPassText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newUPassText.setColumns(10);
		newUPassText.setBounds(234, 279, 150, 30);
		panel_3.add(newUPassText);
		
		newAccText = new JTextField();
		newAccText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newAccText.setColumns(10);
		newAccText.setBounds(234, 341, 150, 30);
		panel_3.add(newAccText);
		
		createUser = new JButton("create user");
		createUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		createUser.setBounds(420, 55, 180, 40);
		panel_3.add(createUser);
		
		viewUser = new JButton("view user");
		viewUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewUser.setBounds(420, 135, 180, 40);
		panel_3.add(viewUser);
		
		updateUser = new JButton("update user");
		updateUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updateUser.setBounds(420, 215, 180, 40);
		panel_3.add(updateUser);
		
		deleteUser = new JButton("delete user");
		deleteUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteUser.setBounds(420, 295, 180, 40);
		panel_3.add(deleteUser);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 400, 620, 210);
		panel_3.add(scrollPane_3);
		
		userTable = new JTable();
		userTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userTable.setModel(userModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Password", "Premium account"
			}
		));
		userTable.setRowSelectionAllowed(false);
		scrollPane_3.setViewportView(userTable);
	}
	
	// ****************************** movie *********************************
	public void createMovie(ActionListener listener) {
		createMovie.addActionListener(listener);
	}
	
	public void viewMovies(ActionListener listener) {
		viewMovies.addActionListener(listener);
	}
	
	public void updateMovie(ActionListener listener) {
		updateMovie.addActionListener(listener);
	}
	
	public void deleteMovie(ActionListener listener) {
		deleteMovie.addActionListener(listener);
	}
	
	public String getMovieNameText() {
		return nameText.getText();
	}
	
	public String getMovieDescrText() {
		return descrText.getText();
	}
	
	public String getMovieActText() {
		return actText.getText();
	}
	
	public Date getMovieRelDateText() {
		try {
			return new SimpleDateFormat("yyyy.MM.dd").parse(relDateText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getMovieRatingText() {
		return ratingText.getText();
	}
	
	public String getMovieCommText() {
		return commText.getText();
	}
	
	public String getNewMovieNameText() {
		return newNameText.getText();
	}
	
	public String getNewMovieDescrText() {
		return newDescrText.getText();
	}
	
	public String getNewMovieActText() {
		return newActText.getText();
	}
	
	public Date getNewMovieRelDateText() {
		try {
			return new SimpleDateFormat("yyyy.MM.dd").parse(newRelDateText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getNewMovieRatingText() {
		return newRatingText.getText();
	}
	
	public String getNewMovieCommText() {
		return newCommText.getText();
	}
	
	// ****************************** theatre ********************************* 
	public void createTheatre(ActionListener listener) {
		createTheatre.addActionListener(listener);
	}
	
	public void viewTheatres(ActionListener listener) {
		viewTheatre.addActionListener(listener);
	}
	
	public void updateTheatre(ActionListener listener) {
		updateTheatre.addActionListener(listener);
	}
	
	public void deleteTheatre(ActionListener listener) {
		deleteTheatre.addActionListener(listener);
	}
	
	public String getTheatreNameText() {
		return tNameText.getText();
	}
	
	public String getTheatreDescrText() {
		return tDescrText.getText();
	}
	
	public String getTheatreActText() {
		return tActText.getText();
	}
	
	public Date getTheatreRelDateText() {
		try {
			return new SimpleDateFormat("yyyy.MM.dd").parse(tRelDateText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getTheatreRatingText() {
		return tRatingText.getText();
	}
	
	public String getTheatreCommText() {
		return tCommText.getText();
	}
	
	public String getNewTheatreNameText() {
		return newTNameText.getText();
	}
	
	public String getNewTheatreDescrText() {
		return newTDescrText.getText();
	}
	
	public String getNewTheatreActText() {
		return newTActText.getText();
	}
	
	public Date getNewTheatreRelDateText() {
		try {
			return new SimpleDateFormat("yyyy.MM.dd").parse(newTRelDateText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getNewTheatreRatingText() {
		return newTRatingText.getText();
	}
	
	public String getNewTheatreCommText() {
		return newTCommText.getText();
	}
	
	// ****************************** sports ********************************* 
	public void createEvent(ActionListener listener) {
		createEvent.addActionListener(listener);
	}
	
	public void viewEvents(ActionListener listener) {
		viewEvent.addActionListener(listener);
	}
	
	public void updateEvent(ActionListener listener) {
		updateEvent.addActionListener(listener);
	}
	
	public void deleteEvent(ActionListener listener) {
		deleteEvent.addActionListener(listener);
	}
	
	public String getEventNameText() {
		return sNameText.getText();
	}
	
	public String getEventDescrText() {
		return sDescrText.getText();
	}
	
	public String getTeam1Text() {
		return team1Text.getText();
	}
	
	public String getTeam2Text() {
		return team2Text.getText();
	}
	
	public Date getEventRelDateText() {
		try {
			return new SimpleDateFormat("yyyy.MM.dd").parse(sEventDateText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getEventRatingText() {
		return sResultText.getText();
	}
	
	public String getEventCommText() {
		return sCommText.getText();
	}
	
	public String getNewEventNameText() {
		return newSNameText.getText();
	}
	
	public String getNewEventDescrText() {
		return newSDescrText.getText();
	}
	
	public String getNewTeam1Text() {
		return newTeam1Text.getText();
	}
	
	public String getNewTeam2Text() {
		return newTeam2Text.getText();
	}
	
	public Date getNewEventRelDateText() {
		try {
			return new SimpleDateFormat("yyyy.MM.dd").parse(newEventDateText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getNewEventRatingText() {
		return newResultText.getText();
	}
	
	public String getNewEventCommText() {
		return newSCommText.getText();
	}
	
	// ****************************** user *********************************
	public void createUser(ActionListener listener) {
		createUser.addActionListener(listener);
	}
	
	public void viewUsers(ActionListener listener) {
		viewUser.addActionListener(listener);
	}
	
	public void updateUser(ActionListener listener) {
		updateUser.addActionListener(listener);
	}
	
	public void deleteUser(ActionListener listener) {
		deleteUser.addActionListener(listener);
	}
	
	public String getUserNameText() {
		return uNameText.getText();
	}
	
	public String getUserPassText() {
		return uPassText.getText();
	}
	
	public Date getUserAccountText() {
		try {
			return new SimpleDateFormat("yyyy.MM.dd").parse(accText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getNewUserNameText() {
		return newUNameText.getText();
	}
	
	public String getNewUserPassText() {
		return newUPassText.getText();
	}
	
	public Date getNewUserAccountText() {
		try {
			return new SimpleDateFormat("yyyy.MM.dd").parse(newAccText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ****************************** set table text *********************************
	@SuppressWarnings("unchecked")
	public void setTable(List<Object> objects, int showType) {
		movieModel.setRowCount(0);
		
		// show movies
		if(objects.size() != 0 && showType == 0 && objects.get(0).getClass().isInstance(new Movies())) {
			List<Movies> movies = (List<Movies>) (Object) objects;			
			for(Movies m : movies)
			{
				Object[] o = new Object[7];
				o[0] = m.getId();
				o[1] = m.getName();
				o[2] = m.getDescription();
				o[3] = m.getActors();
				o[4] = m.getReleaseDate();
				o[5] = m.getRating();
				o[6] = m.getComments();
				
				movieModel.addRow(o);
			}
		}
		
		// show movies history
		if(objects.size() != 0 && showType == 0 && objects.get(0).getClass().isInstance(new History())) {
			List<History> histories = (List<History>) (Object) objects;			
			for(History h : histories)
			{
				Object[] o = new Object[6];
				o[0] = h.getUserId();
				o[1] = h.getName();
				o[2] = h.getDescription();
				o[3] = h.getActorsOrTeams();
				o[4] = h.getReleaseOrEventDate();
				o[5] = h.getRatingOrResult();
			
				movieModel.addRow(o);
			}
		}
		
		theatreModel.setRowCount(0);
		
		// show theatres
		if(objects.size() != 0 && showType == 1 && objects.get(0).getClass().isInstance(new Theatres())) {
			List<Theatres> theatres = (List<Theatres>) (Object) objects;			
			for(Theatres t : theatres)
			{
				Object[] o = new Object[7];
				o[0] = t.getId();
				o[1] = t.getName();
				o[2] = t.getDescription();
				o[3] = t.getActors();
				o[4] = t.getReleaseDate();
				o[5] = t.getRating();
				o[6] = t.getComments();
				
				theatreModel.addRow(o);
			}
		}
		
		// show theatres history
		if(objects.size() != 0 && showType == 1 && objects.get(0).getClass().isInstance(new History())) {
			List<History> histories = (List<History>) (Object) objects;			
			for(History h : histories)
			{
				Object[] o = new Object[6];
				o[0] = h.getUserId();
				o[1] = h.getName();
				o[2] = h.getDescription();
				o[3] = h.getActorsOrTeams();
				o[4] = h.getReleaseOrEventDate();
				o[5] = h.getRatingOrResult();
			
				theatreModel.addRow(o);
			}
		}
		
		sportModel.setRowCount(0);

		// show sports
		if(objects.size() != 0 && showType == 2 && objects.get(0).getClass().isInstance(new Sports())) {
			List<Sports> sports = (List<Sports>) (Object) objects;			
			for(Sports s : sports)
			{
				Object[] o = new Object[7];
				o[0] = s.getId();
				o[1] = s.getName();
				o[2] = s.getDescription();
				o[3] = s.getTeam1() + "-" + s.getTeam2();
				o[4] = s.getEventDate();
				o[5] = s.getResult();
				o[6] = s.getComments();
				
				sportModel.addRow(o);
			}
		}
		
		// show sports history
		if(objects.size() != 0 && showType == 2 && objects.get(0).getClass().isInstance(new History())) {
			List<History> histories = (List<History>) (Object) objects;			
			for(History h : histories)
			{
				Object[] o = new Object[6];
				o[0] = h.getUserId();
				o[1] = h.getName();
				o[2] = h.getDescription();
				o[3] = h.getActorsOrTeams();
				o[4] = h.getReleaseOrEventDate();
				o[5] = h.getRatingOrResult();
			
				sportModel.addRow(o);
			}
		}
		
		userModel.setRowCount(0);
		
		// show sports
		if(objects.size() != 0 && showType == 3 && objects.get(0).getClass().isInstance(new User())) {
			List<User> users = (List<User>) (Object) objects;			
			for(User u : users)
			{
				Object[] o = new Object[7];
				o[0] = u.getId();
				o[1] = u.getName();
				o[2] = u.getPass();
				o[3] = u.getPremiumAccount();
				
				userModel.addRow(o);
			}
		}
		
		
	}
}
