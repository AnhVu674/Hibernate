import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "table_Person")
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private long id;
	private String name;
	private Date birthdate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "spouse_id")
	private Person bourse;

	public Person() {
		super();
	}

	public Person(long id, String name, java.util.Date date, Person bourse) {
		this.id = id;
		this.name = name;
		this.birthdate = (Date) date;
		this.bourse = bourse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Person getBourse() {
		return bourse;
	}

	public void setBourse(Person bourse) {
		this.bourse = bourse;
	}

}
