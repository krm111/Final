package mvc_everything.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistenece.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "timeline")
public class Timeline {
	
	@Column
	private Date date;
	@OneToOne //Una persona un timeline - Un timeline una persona
	@JoinColumn(name = "person_id")
	private Person person;
	@OneToMany //Una Timeline varias canciones 
	@JoinColumn(name = "song_id")
	private Song song;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
}