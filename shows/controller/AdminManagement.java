package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import bridge.Comedy;
import bridge.Drama;
import bridge.Show;
import client.Client;
import model.Movies;
import model.Sports;
import model.Theatres;
import model.User;
import view.AdminFrame;

public class AdminManagement extends Observable{

	private List<Object> list = new ArrayList<Object>();
	
	private final int movie = 0;
	private final int theatre = 1;
	private final int sport = 2;
	private final int user = 3;
	
	public AdminManagement() {}
	
	public AdminManagement(AdminFrame frame) {
		this.addObserver(new UserManagement());
		
		frame.setVisible(true);
		
		// movies 
		frame.createMovie(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getMovieNameText();
				String descr = frame.getMovieDescrText();
				String actors = frame.getMovieActText();
				Date relDate = frame.getMovieRelDateText();
				String rating = frame.getMovieRatingText();
				String comm = frame.getMovieCommText();
				
				list.clear();
				list.add(11);
				list.add(new Movies(name, descr, actors, relDate, rating, comm));
				list.add(movie);
							
				new Client().adminOperations(list);
				
				Show show = new Movies(new Comedy());
				show.print();
				
				list.clear();
				list.add(15);
				list.add(name);
				
				if(new Client().interestsAndRecommandations(list)) {
					setChanged();
					notifyObservers();
				}
			}
		});
		
		frame.viewMovies(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {			
				list.clear();
				list.add(12);
				list.add(movie);
				
				frame.setTable(new Client().viewShows(list), movie);
			}
		});
		
		frame.updateMovie(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getMovieNameText();
				
				// new informations
				String newName = frame.getNewMovieNameText();
				String newDescr = frame.getNewMovieDescrText();
				String newActors = frame.getNewMovieActText();
				Date newRelDate = frame.getNewMovieRelDateText();
				String newRating = frame.getNewMovieRatingText();
				String newComm = frame.getNewMovieCommText();
				
				list.clear();
				list.add(13);
				list.add(name);
				list.add(new Movies(newName, newDescr, newActors, newRelDate, newRating, newComm));
				list.add(movie);
				
				new Client().adminOperations(list);
				
			}
		});
		
		frame.deleteMovie(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getMovieNameText();
				
				list.clear();
				list.add(14);
				list.add(name);
				list.add(movie);
				
				new Client().adminOperations(list);
			}
		});
	
		// theatres
		frame.createTheatre(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getTheatreNameText();
				String descr = frame.getTheatreDescrText();
				String actors = frame.getTheatreActText();
				Date relDate = frame.getTheatreRelDateText();
				String rating = frame.getTheatreRatingText();
				String comm = frame.getTheatreCommText();
				
				list.clear();
				list.add(11);
				list.add(new Theatres(name, descr, actors, relDate, rating, comm));
				list.add(theatre);
				
				new Client().adminOperations(list);
				
				Show show = new Theatres(new Drama());
				show.print();
				
				list.clear();
				list.add(15);
				list.add(name);
				
				if(new Client().interestsAndRecommandations(list)) {
					setChanged();
					notifyObservers();
				}
			}
		});
		
		frame.viewTheatres(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {			
				list.clear();
				list.add(12);
				list.add(theatre);
				
				frame.setTable(new Client().viewShows(list), theatre);
			}
		});
		
		frame.updateTheatre(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getTheatreNameText();
				
				// new informations
				String newName = frame.getNewTheatreNameText();
				String newDescr = frame.getNewTheatreDescrText();
				String newActors = frame.getNewTheatreActText();
				Date newRelDate = frame.getNewTheatreRelDateText();
				String newRating = frame.getNewTheatreRatingText();
				String newComm = frame.getNewTheatreCommText();
				
				list.clear();
				list.add(13);
				list.add(name);
				list.add(new Theatres(newName, newDescr, newActors, newRelDate, newRating, newComm));
				list.add(theatre);
				
				new Client().adminOperations(list);
				
			}
		});
		
		frame.deleteTheatre(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getTheatreNameText();
				
				list.clear();
				list.add(14);
				list.add(name);
				list.add(theatre);
				
				new Client().adminOperations(list);
			}
		});
	
		// sports
		frame.createEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getEventNameText();
				String descr = frame.getEventDescrText();
				String team1 = frame.getTeam1Text();
				String team2 = frame.getTeam2Text();
				Date relDate = frame.getEventRelDateText();
				String rating = frame.getEventRatingText();
				String comm = frame.getEventCommText();
				
				list.clear();
				list.add(11);
				list.add(new Sports(name, descr, team1, team2, relDate, rating, comm));
				list.add(sport);
				
				new Client().adminOperations(list);
				
				list.clear();
				list.add(15);
				list.add(name);
				
				if(new Client().interestsAndRecommandations(list)) {
					setChanged();
					notifyObservers();
				}
			}
		});
		
		frame.viewEvents(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {			
				list.clear();
				list.add(12);
				list.add(sport);
				
				frame.setTable(new Client().viewShows(list), sport);
			}
		});
		
		frame.updateEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getEventNameText();
				String team1 = frame.getTeam1Text();
				String team2 = frame.getTeam2Text();
				
				String data = name + "," + team1 + "," + team2;
				
				// new informations
				String newName = frame.getNewEventNameText();
				String newDescr = frame.getNewEventDescrText();
				String newTeam1 = frame.getNewTeam1Text();
				String newTeam2 = frame.getNewTeam2Text();
				Date newRelDate = frame.getNewEventRelDateText();
				String newRating = frame.getNewEventRatingText();
				String newComm = frame.getNewEventCommText();
				
				list.clear();
				list.add(13);
				list.add(data);
				list.add(new Sports(newName, newDescr, newTeam1, newTeam2, newRelDate, newRating, newComm));
				list.add(sport);
				
				new Client().adminOperations(list);
				
			}
		});
		
		frame.deleteEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getEventNameText();
							
				list.clear();
				list.add(14);
				list.add(name);
				list.add(sport);
				
				new Client().adminOperations(list);
			}
		});
	
		// user
		frame.createUser(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getUserNameText();
				String pass = frame.getUserPassText();
				Date pAcc = frame.getUserAccountText();
							
				list.clear();
				list.add(11);
				list.add(new User(name, pass, pAcc));
				list.add(user);
				
				new Client().adminOperations(list);
			}
		});
		
		frame.viewUsers(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {			
				list.clear();
				list.add(12);
				list.add(user);
				
				frame.setTable(new Client().viewShows(list), user);
			}
		});
		
		frame.updateUser(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getUserNameText();
				
				// new informations
				String newName = frame.getNewUserNameText();
				String newPass = frame.getNewUserPassText();
				Date newPAcc = frame.getNewUserAccountText();
				
				list.clear();
				list.add(13);
				list.add(name);
				list.add(new User(newName, newPass, newPAcc));
				list.add(user);
				
				new Client().adminOperations(list);
				
			}
		});
		
		frame.deleteUser(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = frame.getUserNameText();
				
				list.clear();
				list.add(14);
				list.add(name);
				list.add(user);
				
				new Client().adminOperations(list);
			}
		});
	
	}
}
