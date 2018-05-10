package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JOptionPane;

import client.Client;
import model.User;
import view.UserFrame;

public class UserManagement extends Observable implements Observer{

	private List<Object> list = new ArrayList<Object>();
	private final int movie = 0;
	private final int theatre = 1;
	private final int sports = 2;
		
	private boolean rec = false;
	
	public UserManagement() {}
	
	public UserManagement(User user, UserFrame frame) {
		this.addObserver(this);
		
		frame.setVisible(true);
		
		frame.searchMovie(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = frame.getMovieNameText();
				
				list.clear();
				list.add(3);
				list.add(name);
				list.add(movie);
				
				frame.setTable(new Client().searchShow(list), movie);				
			}
		});
		
		frame.viewMovies(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				list.clear();
				list.add(4);
				list.add(movie);
				
				frame.setTable(new Client().viewShows(list), movie);
			}
		});
		
		frame.selectMovie(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = frame.getMovieNameText();
				
				list.clear();
				list.add(5);
				list.add(name);
				list.add(user);
				list.add(movie);
				
				new Client().selectShow(list);
			}
		});
		
		frame.viewMovieHistory(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				list.clear();
				list.add(6);
				list.add(movie);
				
				frame.setTable(new Client().viewShowsHistory(list), movie);
			}
		});
		
		frame.giveMovieComment(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getMovieNameText();
				String comm = frame.getMovieCommentText();
				
				list.clear();
				list.add(7);
				list.add(name);
				list.add(comm);
				list.add(movie);
				
				new Client().giveShowComm(list);
			}
		});

		frame.giveMovieRating(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getMovieNameText();
				String rating = frame.getAddMovieRatingText();
				
				list.clear();
				list.add(8);
				list.add(name);
				list.add(rating);
				list.add(movie);
				
				new Client().giveShowRating(list);
			}
		});

		frame.recommendMovie(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = JOptionPane.showInputDialog(null, "add user name");
				
				list.clear();
				list.add(9);
				list.add(name);	
				list.add(user);
				
				if(new Client().interestsAndRecommandations(list)) {
					rec = true;
					setChanged();
					notifyObservers();
				}
			}
		});
		
		frame.addMovieInterests(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getMovieNameText();
				
				list.clear();
				list.add(10);
				list.add(name);
				list.add(user);
				list.add(movie);
				
				new Client().selectShow(list);
			}
		});		
		
		frame.searchTheatre(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getTheatreNameText();
				
				list.clear();
				list.add(3);
				list.add(name);
				list.add(theatre);
				
				frame.setTable(new Client().searchShow(list), theatre);
			}
		});
		
		frame.viewTheatres(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				list.clear();
				list.add(4);
				list.add(theatre);
				
				frame.setTable(new Client().viewShows(list), theatre);
			}
		});
		
		frame.selectTheatre(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = frame.getTheatreNameText();
				
				list.clear();
				list.add(5);
				list.add(name);
				list.add(user);
				list.add(theatre);
				
				new Client().selectShow(list);
			}
		});
		
		frame.viewTheatreHistory(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				list.clear();
				list.add(6);
		
				frame.setTable(new Client().viewShowsHistory(list), theatre);
			}
		});
		
		frame.giveTheatreComment(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getTheatreNameText();
				String comm = frame.getTheatreCommentText();
				
				list.clear();
				list.add(7);
				list.add(name);
				list.add(comm);
				list.add(theatre);
				
				new Client().giveShowComm(list);
			}
		});

		frame.giveTheatreRating(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getTheatreNameText();
				String rating = frame.getAddTheatreRatingText();
				
				list.clear();
				list.add(8);
				list.add(name);
				list.add(rating);
				list.add(theatre);
				
				new Client().giveShowRating(list);
			}
		});
		
		frame.recommendTheatre(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = JOptionPane.showInputDialog(null, "add user name");
				
				list.clear();
				list.add(9);
				list.add(name);	
				list.add(user);
				
				if(new Client().interestsAndRecommandations(list)) {
					rec = true;
					setChanged();
					notifyObservers();
				}
			}
		});
		
		frame.addTheatreInterests(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getTheatreNameText();
				
				list.clear();
				list.add(10);
				list.add(name);
				list.add(user);
				list.add(theatre);
				
				new Client().selectShow(list);
			}
		});	
		
		frame.searchMatch(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getMatchNameText();
				String team1 = frame.getTeam1Text();
				String team2 = frame.getTeam2Text();
				
				String match = name + "," + team1 + "," + team2;
				
				list.clear();
				list.add(3);
				list.add(match);
				list.add(sports);
				
				frame.setTable(new Client().searchShow(list), sports);
			}
		});
		
		frame.viewMatches(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				list.clear();
				list.add(4);
				list.add(sports);
				
				frame.setTable(new Client().viewShows(list), sports);
			}
		});
		
		frame.selectMatch(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = frame.getMatchNameText();
				String team1 = frame.getTeam1Text();
				String team2 = frame.getTeam2Text();
				
				String match = name + "," + team1 + "," + team2;
				
				list.clear();
				list.add(5);
				list.add(match);
				list.add(user);
				list.add(sports);
				
				new Client().selectShow(list);
			}
		});
		
		frame.viewMatchesHistory(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				list.clear();
				list.add(6);
		
				frame.setTable(new Client().viewShowsHistory(list), sports);
			}
		});
		
		frame.giveMatchComment(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getMatchNameText();
				String team1 = frame.getTeam1Text();
				String team2 = frame.getTeam2Text();
				String comm = frame.getAddMatchCommentText();
				
				String sport = name + "," + team1 + "," + team2;
				
				list.clear();
				list.add(7);
				list.add(sport);
				list.add(comm);
				list.add(sports);
				
				new Client().giveShowComm(list);
			}
		});
		
		frame.recommendMatch(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = JOptionPane.showInputDialog(null, "add user name");
				
				list.clear();
				list.add(9);
				list.add(name);	
				list.add(user);
				
				if(new Client().interestsAndRecommandations(list)) {
					rec = true;
					setChanged();
					notifyObservers();
				}
			}
		});
		
		frame.addMatchInterests(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getMatchNameText();
				
				list.clear();
				list.add(10);
				list.add(name);
				list.add(user);
				list.add(sports);
				
				new Client().selectShow(list);
			}
		});	
	}

	@Override
	public void update(Observable o, Object arg) {
		if(!rec)
			JOptionPane.showMessageDialog(null, "you can see your favourite show!", "informational window", JOptionPane.INFORMATION_MESSAGE);
		
		if(rec)
			JOptionPane.showMessageDialog(null, "1 of your friends recommanded you to see a movie", "informational window", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
