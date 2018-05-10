package view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.History;
import model.Movies;
import model.Sports;
import model.Theatres;

import javax.swing.JButton;

public class UserFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JTextField nameText;
	private JTextField descrText;
	private JTextField actText;
	private JTextField relDateText;
	private JTextField ratingText;
	private JTable movieTable;
	private JTextField commText;
	private JTextField addRatingText;
	private JTextField tNameText;
	private JTextField tDescrText;
	private JTextField tActText;
	private JTextField tRelDateText;
	private JTextField tRatingText;
	private JTextField tCommText;
	private JTextField tAddRatingText;
	private JTable theatreTable;
	private JTextField eventDateText;
	private JTextField team2Text;
	private JTextField team1Text;
	private JTextField sDescrText;
	private JTextField sNameText;
	private JTable sportTable;
	private JTextField sCommText;
	private JButton searchMovie;
	private JButton selectMovie;
	private JButton viewMovies;
	private JButton viewHistory;
	private JButton giveRating;
	private JButton giveComment;
	private JButton recommend;
	private JButton interests;
	private JButton searchTheatre;
	private JButton selectTheatre;
	private JButton viewTheatres;
	private JButton tViewHistory;
	private JButton tGiveRating;
	private JButton tComment;
	private JButton tRecommend;
	private JButton tInterests;
	private JButton searchMatch;
	private JButton selectMatch;
	private JButton sViewHistory;
	private JButton viewMatches;
	private JButton sComment;
	private JButton sInterests;
	private JButton sRecommend;

	private DefaultTableModel movieModel;

	private DefaultTableModel theatreModel;

	private DefaultTableModel sportModel;
	
	public UserFrame() {
		setTitle("User Frame");
		this.setSize(800, 650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 782, 603);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("movie", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblSearchShow = new JLabel("name");
		lblSearchShow.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSearchShow.setBounds(25, 20, 150, 30);
		panel.add(lblSearchShow);
		
		JLabel lblDescription = new JLabel("description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDescription.setBounds(25, 60, 150, 30);
		panel.add(lblDescription);
		
		JLabel lblActors = new JLabel("actors");
		lblActors.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblActors.setBounds(25, 100, 150, 30);
		panel.add(lblActors);
		
		JLabel lblReleaseDate = new JLabel("release date");
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblReleaseDate.setBounds(25, 140, 150, 30);
		panel.add(lblReleaseDate);
		
		JLabel lblRating = new JLabel("rating");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRating.setBounds(25, 180, 150, 30);
		panel.add(lblRating);
		
		nameText = new JTextField();
		nameText.setBounds(200, 20, 150, 30);
		panel.add(nameText);
		nameText.setColumns(10);
		
		descrText = new JTextField();
		descrText.setColumns(10);
		descrText.setBounds(200, 60, 150, 30);
		panel.add(descrText);
		
		actText = new JTextField();
		actText.setColumns(10);
		actText.setBounds(200, 100, 150, 30);
		panel.add(actText);
		
		relDateText = new JTextField();
		relDateText.setColumns(10);
		relDateText.setBounds(200, 140, 150, 30);
		panel.add(relDateText);
		
		ratingText = new JTextField();
		ratingText.setColumns(10);
		ratingText.setBounds(200, 180, 150, 30);
		panel.add(ratingText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 310, 750, 250);
		panel.add(scrollPane);
		
		movieTable = new JTable();
		movieTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		movieModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"UserId", "Name", "Description", "Actors", "ReleaseDate", "Rating", "Comments"
			}
		);
		movieTable.setModel(movieModel);
		movieTable.setEnabled(false);
		scrollPane.setViewportView(movieTable);
		
		JLabel lblComments = new JLabel("add comments");
		lblComments.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComments.setBounds(25, 220, 163, 30);
		panel.add(lblComments);
		
		commText = new JTextField();
		commText.setColumns(10);
		commText.setBounds(200, 220, 150, 30);
		panel.add(commText);
		
		searchMovie = new JButton("search show");
		searchMovie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchMovie.setBounds(400, 20, 150, 40);
		panel.add(searchMovie);
		
		selectMovie = new JButton("select show");
		selectMovie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		selectMovie.setBounds(600, 20, 150, 40);
		panel.add(selectMovie);
		
		viewMovies = new JButton("view movies");
		viewMovies.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewMovies.setBounds(400, 100, 150, 40);
		panel.add(viewMovies);
		
		viewHistory = new JButton("view history");
		viewHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewHistory.setBounds(600, 100, 150, 40);
		panel.add(viewHistory);
		
		giveRating = new JButton("give rating");
		giveRating.setFont(new Font("Tahoma", Font.PLAIN, 20));
		giveRating.setBounds(400, 177, 150, 40);
		panel.add(giveRating);
		
		giveComment = new JButton("comment");
		giveComment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		giveComment.setBounds(600, 180, 150, 40);
		panel.add(giveComment);
		
		recommend = new JButton("recommend");
		recommend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		recommend.setBounds(400, 260, 150, 40);
		panel.add(recommend);
		
		interests = new JButton("interesets");
		interests.setFont(new Font("Tahoma", Font.PLAIN, 20));
		interests.setBounds(600, 260, 150, 40);
		panel.add(interests);
		
		JLabel lblAddRating = new JLabel("add rating");
		lblAddRating.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAddRating.setBounds(25, 260, 150, 30);
		panel.add(lblAddRating);
		
		addRatingText = new JTextField();
		addRatingText.setColumns(10);
		addRatingText.setBounds(200, 260, 150, 30);
		panel.add(addRatingText);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("theatre", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(25, 20, 150, 30);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("description");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(25, 60, 150, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("actors");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_2.setBounds(25, 100, 150, 30);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("release date");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_3.setBounds(25, 140, 150, 30);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("rating");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_4.setBounds(25, 180, 150, 30);
		panel_1.add(label_4);
		
		tNameText = new JTextField();
		tNameText.setColumns(10);
		tNameText.setBounds(200, 20, 150, 30);
		panel_1.add(tNameText);
		
		tDescrText = new JTextField();
		tDescrText.setColumns(10);
		tDescrText.setBounds(200, 60, 150, 30);
		panel_1.add(tDescrText);
		
		tActText = new JTextField();
		tActText.setColumns(10);
		tActText.setBounds(200, 100, 150, 30);
		panel_1.add(tActText);
		
		tRelDateText = new JTextField();
		tRelDateText.setColumns(10);
		tRelDateText.setBounds(200, 140, 150, 30);
		panel_1.add(tRelDateText);
		
		tRatingText = new JTextField();
		tRatingText.setColumns(10);
		tRatingText.setBounds(200, 180, 150, 30);
		panel_1.add(tRatingText);
		
		JLabel label_5 = new JLabel("add comments");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_5.setBounds(25, 220, 163, 30);
		panel_1.add(label_5);
		
		tCommText = new JTextField();
		tCommText.setColumns(10);
		tCommText.setBounds(200, 220, 150, 30);
		panel_1.add(tCommText);
		
		searchTheatre = new JButton("search show");
		searchTheatre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchTheatre.setBounds(400, 20, 150, 40);
		panel_1.add(searchTheatre);
		
		selectTheatre = new JButton("select show");
		selectTheatre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		selectTheatre.setBounds(600, 20, 150, 40);
		panel_1.add(selectTheatre);
		
		viewTheatres = new JButton("view details");
		viewTheatres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewTheatres.setBounds(400, 100, 150, 40);
		panel_1.add(viewTheatres);
		
		tViewHistory = new JButton("view history");
		tViewHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tViewHistory.setBounds(600, 100, 150, 40);
		panel_1.add(tViewHistory);
		
		tGiveRating = new JButton("give rating");
		tGiveRating.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tGiveRating.setBounds(400, 180, 150, 40);
		panel_1.add(tGiveRating);
		
		tComment = new JButton("comment");
		tComment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tComment.setBounds(600, 180, 150, 40);
		panel_1.add(tComment);
		
		tRecommend = new JButton("recommend");
		tRecommend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tRecommend.setBounds(400, 260, 150, 40);
		panel_1.add(tRecommend);
		
		tInterests = new JButton("interesets");
		tInterests.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tInterests.setBounds(600, 260, 150, 40);
		panel_1.add(tInterests);
		
		JLabel label_6 = new JLabel("add rating");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_6.setBounds(25, 260, 150, 30);
		panel_1.add(label_6);
		
		tAddRatingText = new JTextField();
		tAddRatingText.setColumns(10);
		tAddRatingText.setBounds(200, 260, 150, 30);
		panel_1.add(tAddRatingText);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 310, 750, 250);
		panel_1.add(scrollPane_1);
		
		theatreTable = new JTable();
		theatreTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		theatreModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"UserId", "Name", "Description", "Actors", "ReleaseDate", "Rating", "Comments"
			}
		);
		theatreTable.setModel(theatreModel);
		theatreTable.setEnabled(false);
		scrollPane_1.setViewportView(theatreTable);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("sport", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_7 = new JLabel("name");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_7.setBounds(25, 20, 150, 30);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("description");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_8.setBounds(25, 60, 150, 30);
		panel_2.add(label_8);
		
		JLabel lblTeams = new JLabel("team 1");
		lblTeams.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTeams.setBounds(25, 100, 150, 30);
		panel_2.add(lblTeams);
		
		JLabel lblEventDate = new JLabel("event date");
		lblEventDate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEventDate.setBounds(25, 180, 150, 30);
		panel_2.add(lblEventDate);
		
		JLabel label_12 = new JLabel("add comments");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_12.setBounds(25, 220, 163, 30);
		panel_2.add(label_12);
		
		eventDateText = new JTextField();
		eventDateText.setColumns(10);
		eventDateText.setBounds(200, 180, 150, 30);
		panel_2.add(eventDateText);
		
		team2Text = new JTextField();
		team2Text.setColumns(10);
		team2Text.setBounds(200, 140, 150, 30);
		panel_2.add(team2Text);
		
		team1Text = new JTextField();
		team1Text.setColumns(10);
		team1Text.setBounds(200, 100, 150, 30);
		panel_2.add(team1Text);
		
		sDescrText = new JTextField();
		sDescrText.setColumns(10);
		sDescrText.setBounds(200, 60, 150, 30);
		panel_2.add(sDescrText);
		
		sNameText = new JTextField();
		sNameText.setColumns(10);
		sNameText.setBounds(200, 20, 150, 30);
		panel_2.add(sNameText);
		
		searchMatch = new JButton("search sport");
		searchMatch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchMatch.setBounds(400, 20, 150, 40);
		panel_2.add(searchMatch);
		
		selectMatch = new JButton("select match");
		selectMatch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		selectMatch.setBounds(600, 20, 150, 40);
		panel_2.add(selectMatch);
		
		sViewHistory = new JButton("view history");
		sViewHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sViewHistory.setBounds(600, 100, 150, 40);
		panel_2.add(sViewHistory);
		
		viewMatches = new JButton("view details");
		viewMatches.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewMatches.setBounds(400, 100, 150, 40);
		panel_2.add(viewMatches);
		
		sComment = new JButton("comment");
		sComment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sComment.setBounds(600, 180, 150, 40);
		panel_2.add(sComment);
		
		sInterests = new JButton("interesets");
		sInterests.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sInterests.setBounds(600, 260, 150, 40);
		panel_2.add(sInterests);
		
		sRecommend = new JButton("recommend");
		sRecommend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sRecommend.setBounds(400, 260, 150, 40);
		panel_2.add(sRecommend);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(15, 310, 750, 250);
		panel_2.add(scrollPane_2);
		
		sportTable = new JTable();
		sportTable.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		sportModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"UserId", "Name", "Description", "ActorsOrTeams", "Event date", "Result", "Comments"
			}
		);
		sportTable.setModel(sportModel);
		sportTable.setEnabled(false);
		scrollPane_2.setViewportView(sportTable);
		
		JLabel lblTeam = new JLabel("team 2");
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTeam.setBounds(25, 140, 150, 30);
		panel_2.add(lblTeam);
		
		sCommText = new JTextField();
		sCommText.setColumns(10);
		sCommText.setBounds(200, 220, 150, 30);
		panel_2.add(sCommText);
	}
	
	// ************************* movie ************************
	public void searchMovie(ActionListener listener) {
		searchMovie.addActionListener(listener);
	}
	
	public void viewMovies(ActionListener listener) {
		viewMovies.addActionListener(listener);
	}
	
	public void selectMovie(ActionListener listener) {
		selectMovie.addActionListener(listener);
	}
	
	public void viewMovieHistory(ActionListener listener) {
		viewHistory.addActionListener(listener);
	}
	
	public void giveMovieRating(ActionListener listener) {
		giveRating.addActionListener(listener);
	}
	
	public void giveMovieComment(ActionListener listener) {
		giveComment.addActionListener(listener);
	}
	
	public void recommendMovie(ActionListener listener) {
		recommend.addActionListener(listener);
	}
	
	public void addMovieInterests(ActionListener listener) {
		interests.addActionListener(listener);
	}
	
	public String getMovieNameText() {
		return nameText.getText();
	}
	
	public String getMovieDescriptionText() {
		return descrText.getText();
	}

	public String getMovieActorsText() {
		return actText.getText();
	}

	public Date getMovieRelDateText() {
		try {
			return new SimpleDateFormat("dd.MM.yyyy").parse(relDateText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getMovieRatingText() {
		return ratingText.getText();
	}
	
	public String getMovieCommentText() {
		return commText.getText();
	}
	
	public String getAddMovieRatingText() {
		return addRatingText.getText();
	}
	
	// ************************* theatre ************************
	public void searchTheatre(ActionListener listener) {
		searchTheatre.addActionListener(listener);
	}
	
	public void viewTheatres(ActionListener listener) {
		viewTheatres.addActionListener(listener);
	}
	
	public void selectTheatre(ActionListener listener) {
		selectTheatre.addActionListener(listener);
	}
	
	public void viewTheatreHistory(ActionListener listener) {
		tViewHistory.addActionListener(listener);
	}
	
	public void giveTheatreRating(ActionListener listener) {
		tGiveRating.addActionListener(listener);
	}
	
	public void giveTheatreComment(ActionListener listener) {
		tComment.addActionListener(listener);
	}
	
	public void recommendTheatre(ActionListener listener) {
		tRecommend.addActionListener(listener);
	}
	
	public void addTheatreInterests(ActionListener listener) {
		tInterests.addActionListener(listener);
	}
	
	public String getTheatreNameText() {
		return tNameText.getText();
	}
	
	public String getTheatreDescriptionText() {
		return tDescrText.getText();
	}

	public String getTheatreActorsText() {
		return tActText.getText();
	}

	public Date getTheatreRelDateText() {
		try {
			return new SimpleDateFormat("dd.MM.yyyy").parse(tRelDateText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getTheatreRatingText() {
		return tRatingText.getText();
	}
	
	public String getTheatreCommentText() {
		return tCommText.getText();
	}
	
	public String getAddTheatreRatingText() {
		return tAddRatingText.getText();
	}
	
	// ************************* sports ************************
	public void searchMatch(ActionListener listener) {
		searchMatch.addActionListener(listener);
	}
	
	public void viewMatches(ActionListener listener) {
		viewMatches.addActionListener(listener);
	}
	
	public void selectMatch(ActionListener listener) {
		selectMatch.addActionListener(listener);
	}
	
	public void viewMatchesHistory(ActionListener listener) {
		sViewHistory.addActionListener(listener);
	}
	
	public void giveMatchComment(ActionListener listener) {
		sComment.addActionListener(listener);
	}
	
	public void recommendMatch(ActionListener listener) {
		sRecommend.addActionListener(listener);
	}
	
	public void addMatchInterests(ActionListener listener) {
		sInterests.addActionListener(listener);
	}
	
	public String getMatchNameText() {
		return sNameText.getText();
	}
	
	public String getMatchDescriptionText() {
		return sDescrText.getText();
	}

	public String getTeam1Text() {
		return team1Text.getText();
	}

	public String getTeam2Text() {
		return team2Text.getText();
	}
	
	public Date getMatchRelDateText() {
		try {
			return new SimpleDateFormat("dd.MM.yyyy").parse(eventDateText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getAddMatchCommentText() {
		return sCommText.getText();
	}
	
	/* 0 - movie; 
	 * 1 - theatre; 
	 * 2 - sports
	 */
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
		
	}
}
