package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import bridge.Show;
import bridge.ShowInterface;

@Entity
@Table(name = "MOVIES")
public class Movies extends Show implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "actors")
	private String actors;
	
	@Column(name = "releaseDate")
	private Date releaseDate;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "comments")
	private String comments;
	
	public Movies() {}
	
	public Movies(ShowInterface si) {
		super(si);
	}
	
	public Movies(String name, String description, String actors, Date releaseDate, String rating, String comments) {
		this.name = name;
		this.description = description;
		this.actors = actors;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public void print() {
		si.printShow();
	}
	
}
