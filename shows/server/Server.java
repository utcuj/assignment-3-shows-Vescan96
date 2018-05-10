package server;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import org.hibernate.criterion.Restrictions;
import database.Connection;
import model.Admin;
import model.History;
import model.Interests;
import model.Movies;
import model.Sports;
import model.Theatres;
import model.User;

public class Server extends Thread{
	private ServerSocket serverSocket;
	private Connection c;	
	private Socket server;
	
	private List<Object> returnShows = new ArrayList<Object>();
	
	public Server() {}
	
    public Server(int port) throws IOException {
       serverSocket = new ServerSocket(port);
    }

    public void run() {
       while(true) {
          try { 
        	  c = new Connection();
        	  // set server
        	  System.out.println("server: Waiting for client on port " + serverSocket.getLocalPort() + "...");
        	  server = serverSocket.accept();
	
        	  System.out.println("server: Just connected to " + server.getRemoteSocketAddress());
	
        	  // read from client
        	  @SuppressWarnings("unchecked")
        	  List<Object> ois = (List<Object>) new ObjectInputStream(server.getInputStream()).readObject(); 	          
        	  	  
        	  switch((int)ois.get(0)) {
        	  		// for login or register
        	  		case 0 : registerUser(ois.get(1)); break;
        	  		case 1 : loginAdmin(ois.get(1)); break;
        	  		case 2 : loginUser(ois.get(1)); break;
        	  		
        	  		// for users options
        	  		case 3 : searchShow(ois.get(1), ois.get(2)); break;
        	  		case 4 : viewShows(ois.get(1)); break;
        	  		case 5 : selectShow(ois.get(1), ois.get(2), ois.get(3)); break;
        	  		case 6 : viewShowHistory(); break;
        	  		case 7 : giveShowComm(ois.get(1), ois.get(2), ois.get(3)); break;
        	  		case 8 : giveShowRating(ois.get(1), ois.get(2), ois.get(3)); break;
        	  		case 9 : recommandShow(ois.get(1), ois.get(2)); break;
        	  		case 10 : interestsShow(ois.get(1), ois.get(2), ois.get(3)); break;
        	  			
        	  		// for admin options
        	  		case 11 : createShow(ois.get(1), ois.get(2)); break;
        	  		case 12 : adminViewShows(ois.get(1)); break;
        	  		case 13 : updateShow(ois.get(1), ois.get(2), ois.get(3)); break;
        	  		case 14 : deleteShow(ois.get(1), ois.get(2)); break;
        	  		
        	  		// check interests
        	  		case 15 : checkInterests(ois.get(1)); break;
        	  }
        	  	
        	  	    
          } catch (SocketTimeoutException s) {
        	  System.out.println("server: Socket timed out!");
        	  break;
	      } catch (Exception e) {
	          e.printStackTrace();
	          break;
	      } 
       }
    }
	 
    // ------------------------------------- login or register ----------------------------------------
    public void registerUser(Object object) {
    	c.getSession().save(object);
    	c.getSession().getTransaction().commit();
    	c.getSession().close();
    	
    	try {
    	// tell to client that server done
  	  	DataOutputStream out = new DataOutputStream(server.getOutputStream());
  	  	out.writeUTF("server: done");
  
  	  	server.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void loginAdmin(Object object) {
    	boolean exist = true;
    	
    	Admin a = (Admin) object;
    	    		
    	Admin admin = (Admin)c.getSession().load(Admin.class, 1);
		
		if(!admin.getPassword().equals(a.getPassword()))
			exist = false;
			
    	try {
        	// tell to client that server done
    		ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
      	  	out.writeObject(exist);
      	  	
      	  	server.close();
    	} catch(Exception e) {
        		e.printStackTrace();
    	}
    }
    
    public void loginUser(Object object) {
    	boolean exist = true;
    	
    	User u = (User) object;
		
		List<User> users = c.getSession().createQuery("from User", User.class).list();
		
		if(users.stream().filter(x -> x.getName().equals(u.getName()) && x.getPass().equals(u.getPass()))
				.collect(Collectors.toList())
				.size() == 0)					
			exist = false;
		
		try {
        	// tell to client that server done
    		ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
      	  	out.writeObject(exist);
      	  	
      	  	server.close();
    	} catch(Exception e) {
        		e.printStackTrace();
    	}
    }
    
    // ------------------------------------- users operations -----------------------------------------
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void searchShow(Object name, Object showType) {    	
    	returnShows.clear();
    	
    	int st = (int) showType;
    	
    	if(st == 0)
    		returnShows = (List<Object>) c.getSession()
    							   		   .createCriteria(Movies.class).add(Restrictions.eq("name", name))
    							   		   .list();
    	if(st == 1)
    		returnShows = (List<Object>) c.getSession()
	   		   							   .createCriteria(Theatres.class).add(Restrictions.eq("name", name))
	   		   							   .list();
    	if(st == 2) {
    		String data = (String) name;
    		
    		String[] info = data.split(",");
    		
    		// info[0] = sport name ; info[1] = team1 ; info [2] = team2
    		returnShows = (List<Object>) c.getSession()
    									  .createNativeQuery("select * from Sports where name = '" + info[0] 
    											  			 + "' and team1 = '" + info[1] + "' and team2 = '"
    											  			 + info[2] + "'")
					   					  .list();
    	}
    	
    	try {
        	// tell to client that server done
    		ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
      	  	out.writeObject(returnShows);
      	  	
      	  	server.close();
    	} catch(Exception e) {
        		e.printStackTrace();
    	}
    }
    
	@SuppressWarnings("unchecked")
	public void viewShows(Object showType) {
		returnShows.clear();
		
		int st = (int) showType;
		
		if(st == 0)	returnShows = (List<Object>) c.getSession().createQuery("from Movies").list();
		
		if(st == 1) returnShows = (List<Object>) c.getSession().createQuery("from Theatres").list();
		
		if(st == 2) returnShows = (List<Object>) c.getSession().createQuery("from Sports").list();
		
		try {
        	// tell to client that server done
    		ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
      	  	out.writeObject(returnShows);
      	  	
      	  	server.close();
    	} catch(Exception e) {
        		e.printStackTrace();
    	}
	}
	
	@SuppressWarnings({ "deprecation" })
	public void selectShow(Object name, Object user, Object showType) {
		int st = (int) showType;
		
		User u = (User) user;
		
		u = (User) c.getSession()
					.createCriteria(User.class)
					.add(Restrictions.like("name", u.getName()))
					.uniqueResult();
		
		if(st == 0) {
			Movies movie = (Movies) c.getSession()
					  				 .createCriteria(Movies.class)
					  				 .add(Restrictions.like("name", name))
					  				 .uniqueResult();

			c.getSession().save(new History(u.getId(), movie.getName(), movie.getDescription(), movie.getActors(), movie.getReleaseDate(), movie.getRating()));
			c.getSession().getTransaction().commit();
			c.getSession().close();
		}
		
		if(st == 1) {
			Theatres theatre = (Theatres) c.getSession()
	  				 .createCriteria(Theatres.class)
	  				 .add(Restrictions.like("name", name))
	  				 .uniqueResult();

			c.getSession().save(new History(u.getId(), theatre.getName(), theatre.getDescription(), theatre.getActors(), theatre.getReleaseDate(), theatre.getRating()));
			c.getSession().getTransaction().commit();
			c.getSession().close();
		}
		
		if(st == 2) {
			String data = (String) name;
    		
    		String[] info = data.split(",");
    		
    		// info[0] = sport name ; info[1] = team1 ; info [2] = team2
			Sports sport = (Sports) c.getSession()
	  				 				 .createCriteria(Sports.class)
	  				 				 .add(Restrictions.eq("name", info[0]))
	  				 				 .add(Restrictions.eq("team1", info[1]))
	  				 				 .add(Restrictions.eq("team2", info[2]))
	  				 				 .uniqueResult();

			String teams = sport.getTeam1() + "-" + sport.getTeam2();
			
			c.getSession().save(new History(u.getId(), sport.getName(), sport.getDescription(), teams, sport.getEventDate(), sport.getResult()));
			c.getSession().getTransaction().commit();
			c.getSession().close();
		}
		
		try {
	    	// tell to client that server done
	  	  	DataOutputStream out = new DataOutputStream(server.getOutputStream());
	  	  	out.writeUTF("server: done");
	  
	  	  	server.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
	}
	
    @SuppressWarnings("unchecked")
	public void viewShowHistory() {
    	returnShows.clear();
    	
    	returnShows = (List<Object>) c.getSession().createQuery("from History").list();
    	
		try {
        	// tell to client that server done
    		ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
      	  	out.writeObject(returnShows);
      	  	
      	  	server.close();
    	} catch(Exception e) {
        		e.printStackTrace();
    	}
    }

    public void giveShowComm(Object name, Object comm, Object showType) {
    	int st = (int) showType;
    	
    	if(st == 0) {
	    	c.getSession().createQuery("update Movies set comments = '" + comm + "' where name = '" + name + "'").executeUpdate();
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	if(st == 1) {
    		c.getSession().createQuery("update Theatres set comments = '" + comm + "' where name = '" + name + "'").executeUpdate();
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	if(st == 2) {
    		String data = (String) name;
    		
    		// info[0] = sport name ; info[1] = team1 ; info [2] = team2
    		String[] info = data.split(",");
    		
    		c.getSession().createQuery("update Sports set comments = '" + comm + "' where name = '" 
    								   + info[0] + "' and team1 = '" + info[1] + "' and team2 = '"
    								   + info[2] + "'")
    					  .executeUpdate();
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	try {
	    	// tell to client that server done
	  	  	DataOutputStream out = new DataOutputStream(server.getOutputStream());
	  	  	out.writeUTF("server: done");
	  
	  	  	server.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
   
    @SuppressWarnings("deprecation")
	public void giveShowRating(Object name, Object rating, Object showType) {
    	int st = (int) showType;
    	
    	int userRating = Integer.parseInt((String) rating);
    	
    	if(st == 0) {
	    	Movies movie = (Movies) c.getSession()
	 				 .createCriteria(Movies.class)
	 				 .add(Restrictions.like("name", name))
	 				 .uniqueResult();
	  
	    	int movieRating = Integer.parseInt(movie.getRating());
	    	
	    	int newRating = (movieRating + userRating) % 2 == 0 ?  (movieRating + userRating) / 2  : (movieRating + userRating + 1) / 2;
	    	
	    	c.getSession().createQuery("update Movies set rating = '" + newRating + "' where name = '" + name + "'").executeUpdate();
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	if(st == 1) {
    		Theatres theatre = (Theatres) c.getSession()
	 				 .createCriteria(Theatres.class)
	 				 .add(Restrictions.like("name", name))
	 				 .uniqueResult();
	  
    		int theatreRating = Integer.parseInt(theatre.getRating());
    		
	    	int newRating = (theatreRating + userRating) % 2 == 0 ?  (theatreRating + userRating) / 2  : (theatreRating + userRating + 1) / 2;
	    	
	    	c.getSession().createQuery("update Theatres set rating = '" + newRating + "' where name = '" + name + "'").executeUpdate();
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	try {
	    	// tell to client that server done
	  	  	DataOutputStream out = new DataOutputStream(server.getOutputStream());
	  	  	out.writeUTF("server: done");
	  
	  	  	server.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @SuppressWarnings("deprecation")
	public void interestsShow(Object name, Object user, Object showType) {
		int st = (int) showType;
		
		User u = (User) user;
		
		u = (User) c.getSession()
					.createCriteria(User.class)
					.add(Restrictions.like("name", u.getName()))
					.uniqueResult();
		
		String showName = (String) name;
		
		if(st == 0) {
			if(u.getPremiumAccount() == null)
				JOptionPane.showMessageDialog(null, "Error", "you don't have premium account", JOptionPane.ERROR_MESSAGE);
			else {
				c.getSession().save(new Interests(u.getId(), showName));
				c.getSession().getTransaction().commit();
				c.getSession().close();
			}
		}
		
		if(st == 1) {
			if(u.getPremiumAccount() == null)
				JOptionPane.showMessageDialog(null, "Error", "you don't have premium account", JOptionPane.ERROR_MESSAGE);
			else {
				c.getSession().save(new Interests(u.getId(), showName));
				c.getSession().getTransaction().commit();
				c.getSession().close();
			}
		}
		
		if(st == 2) {
			if(u.getPremiumAccount() == null)
				JOptionPane.showMessageDialog(null, "Error", "you don't have premium account", JOptionPane.ERROR_MESSAGE);
			else {
				c.getSession().save(new Interests(u.getId(), showName));
				c.getSession().getTransaction().commit();
				c.getSession().close();
			}
		}
		
		try {
	    	// tell to client that server done
	  	  	DataOutputStream out = new DataOutputStream(server.getOutputStream());
	  	  	out.writeUTF("server: done");
	  
	  	  	server.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
	}
    
	@SuppressWarnings("deprecation")
	public void recommandShow(Object name, Object user) {
		boolean exist = false;
    	
		User u = (User) user;
		
		u = (User) c.getSession()
					.createCriteria(User.class)
					.add(Restrictions.like("name", u.getName()))
					.uniqueResult();
		
    	User recUser = (User) c.getSession()
    						   .createCriteria(User.class)
    						   .add(Restrictions.eq("name", name))
    						   .uniqueResult();
    	
    	
    	if(recUser != null && recUser.getPremiumAccount() != null && u.getPremiumAccount() != null)
    		exist = true;
    	else
			JOptionPane.showMessageDialog(null, "Error", "you or your friend don't have premium account", JOptionPane.ERROR_MESSAGE);
    	
    	try {
        	// tell to client that server done
    		ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
      	  	out.writeObject(exist);
      	  	
      	  	server.close();
    	} catch(Exception e) {
        		e.printStackTrace();
    	}   
	}
	
    
	// ------------------------------------- admin operations -----------------------------------------
    public void createShow(Object object, Object showType) {
    	int st = (int) showType;
    	
    	if(st == 0) { // create movie
	    	c.getSession().save(object);
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	if(st == 1) { // create theatre
	    	c.getSession().save(object);
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	if(st == 2) { // create sport
	    	c.getSession().save(object);
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	if(st == 3) { // create user
	    	c.getSession().save(object);
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	try {
    	// tell to client that server done
  	  	DataOutputStream out = new DataOutputStream(server.getOutputStream());
  	  	out.writeUTF("server: done");
  
  	  	server.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @SuppressWarnings("unchecked")
	public void adminViewShows(Object showType) {
    	returnShows.clear();
		
		int st = (int) showType;
		
		if(st == 0)	returnShows = (List<Object>) c.getSession().createQuery("from Movies").list();
		
		if(st == 1) returnShows = (List<Object>) c.getSession().createQuery("from Theatres").list();
		
		if(st == 2) returnShows = (List<Object>) c.getSession().createQuery("from Sports").list();
		
		if(st == 3) returnShows = (List<Object>) c.getSession().createQuery("from User").list();
		
		try {
        	// tell to client that server done
    		ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
      	  	out.writeObject(returnShows);
      	  	
      	  	server.close();
    	} catch(Exception e) {
        		e.printStackTrace();
    	}
    }

    public void updateShow(Object name, Object updatedShow, Object showType) {
    	int st = (int) showType;
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    	
    	if(st == 0) {
    		Movies updatedMovie = (Movies) updatedShow;
    		
	    	c.getSession().createQuery("update Movies set name = '" + updatedMovie.getName() 
	    							   + "', description = '" + updatedMovie.getDescription()
	    							   + "', actors = '" + updatedMovie.getActors() 
	    							   + "', releaseDate = '" + sdf.format(updatedMovie.getReleaseDate())
	    							   + "', rating = '" + updatedMovie.getRating() 
	    							   + "', comments = '" + updatedMovie.getComments()
	    							   + "' where name = '" + name + "'")
	    				  .executeUpdate();
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	if(st == 1) {
    		Theatres updatedTheatre = (Theatres) updatedShow;
    		
	    	c.getSession().createQuery("update Theatres set name = '" + updatedTheatre.getName() 
	    							   + "', description = '" + updatedTheatre.getDescription()
	    							   + "', actors = '" + updatedTheatre.getActors() 
	    							   + "', releaseDate = '" + sdf.format(updatedTheatre.getReleaseDate())
	    							   + "', rating = '" + updatedTheatre.getRating() 
	    							   + "', comments = '" + updatedTheatre.getComments()
	    							   + "' where name = '" + name + "'")
	    				  .executeUpdate();
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	if(st == 2) {
    		Sports updatedSport = (Sports) updatedShow;
    		
    		String data = (String) name;
    		
    		// info[0] = sport name ; info[1] = team1 ; info [2] = team2
    		String[] info = data.split(",");
    		
    		c.getSession().createQuery("update Sports set name = '" + updatedSport.getName()
    								   + "', description = '" + updatedSport.getDescription()
    								   + "', team1 = '" + updatedSport.getTeam1()
    								   + "', team2 = '" + updatedSport.getTeam2()
    								   + "', eventDate = '" + sdf.format(updatedSport.getEventDate())
    								   + "', result = '" + updatedSport.getResult()
    								   + "', comments = '" + updatedSport.getComments()
    								   + "' where name = '" + info[0] + "' and team1 = '" 
    								   + info[1] + "' and team2 = '" + info[2] + "'")
    					  .executeUpdate();
	    	c.getSession().getTransaction().commit();
	    	c.getSession().close();
    	}
    	
    	if(st == 3) {
    		User updatedUser = (User) updatedShow;
    		
    		c.getSession().createQuery("update User set name = '" + updatedUser.getName()
									   + "', pass = '" + updatedUser.getPass()
									   + "', premiumAccount = '" + sdf.format(updatedUser.getPremiumAccount())
									   + "' where name = '" + name + "'")
						  .executeUpdate();
			c.getSession().getTransaction().commit();
			c.getSession().close();
    	}
    	
    	try {
	    	// tell to client that server done
	  	  	DataOutputStream out = new DataOutputStream(server.getOutputStream());
	  	  	out.writeUTF("server: done");
	  
	  	  	server.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void deleteShow(Object name, Object showType) {
    	int st = (int) showType;
    	
    	if(st == 0) {
    		c.getSession().createQuery("delete Movies where name = '" + name + "'").executeUpdate();
    		c.getSession().getTransaction().commit();
    		c.getSession().close();
    	}
    	
    	if(st == 1) {
    		c.getSession().createQuery("delete from Theatres where name = '" + name + "'").executeUpdate();
    		c.getSession().getTransaction().commit();
    		c.getSession().close();
    	}
    	
    	if(st == 2) {
    		String data = (String) name;
    		
    		// info[0] = sport name ; info[1] = team1 ; info [2] = team2
    		String[] info = data.split(",");
    		
    		c.getSession().createQuery("delete from Sports where name = '" + info[0]
    								   + "' and team1 = '" + info[1]
    								   + "' and team2 = '" + info[2] + "'")
    					  .executeUpdate();
    		c.getSession().getTransaction().commit();
    		c.getSession().close();
    	}
    	
    	if(st == 3) {
    		c.getSession().createQuery("delete from User where name = '" + name + "'").executeUpdate();
    		c.getSession().getTransaction().commit();
    		c.getSession().close();
    	}
    	
    	try {
	    	// tell to client that server done
	  	  	DataOutputStream out = new DataOutputStream(server.getOutputStream());
	  	  	out.writeUTF("server: done");
	  
	  	  	server.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
	public void checkInterests(Object name) {
    	boolean exist = true;
    	
    	String showName = (String) name;
    	
    	List<Interests> interests = (List<Interests>) c.getSession().createQuery("from Interests", Interests.class).list();
    	
    	if(interests.stream().filter(x -> x.getName().equals(showName)).collect(Collectors.toList()).size() == 0)
    		exist = false;
    	
    	try {
        	// tell to client that server done
    		ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
      	  	out.writeObject(exist);
      	  	
      	  	server.close();
    	} catch(Exception e) {
        		e.printStackTrace();
    	}    	
    }
    

    // ------------------------------------- main -----------------------------------------------------
    public static void main(String [] args) {

    	try {
    		Thread t = new Server(8080);
    		t.start();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }                   
}
