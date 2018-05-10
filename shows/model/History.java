package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "HISTORY")
public class History  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "actorsOrTeams")
	private String actorsOrTeams;
	
	@Column(name = "releaseOrEventDate")
	private Date releaseOrEventDate;
	
	@Column(name = "ratingOrResult")
	private String ratingOrResult;
	
	public History() {}
	
	public History(int userId, String name, String description, String actorsOrTeams, Date releaseOrEventDate, String ratingOrResult) {
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.actorsOrTeams = actorsOrTeams;
		this.releaseOrEventDate = releaseOrEventDate;
		this.ratingOrResult = ratingOrResult;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getActorsOrTeams() {
		return actorsOrTeams;
	}

	public void setActorsOrTeams(String actorsOrTeams) {
		this.actorsOrTeams = actorsOrTeams;
	}

	public Date getReleaseOrEventDate() {
		return releaseOrEventDate;
	}

	public void setReleaseOrEventDate(Date releaseOrEventDate) {
		this.releaseOrEventDate = releaseOrEventDate;
	}

	public String getRatingOrResult() {
		return ratingOrResult;
	}

	public void setRatingOrResult(String ratingOrResult) {
		this.ratingOrResult = ratingOrResult;
	}

}
