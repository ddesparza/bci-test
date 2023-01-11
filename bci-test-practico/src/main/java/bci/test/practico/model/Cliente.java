package bci.test.practico.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "tbl_cliente")
public class Cliente implements Serializable{

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@NotBlank
	@NotEmpty
	private String name;

	@NotBlank
	@NotEmpty
	@Email(message = "Por favor ingrese correo valido")
	private String email;

	@NotBlank
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\'\\s\\-]*$")
	private String password;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date   created;

	private String isactive;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Phones> phones = new ArrayList<>();
	
	@Column(name = "LAST_LOGIN")
    private Date lastLogin;
	
	private Date modified;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public List<Phones> getPhones() {
		return phones;
	}

	public void setPhones(List<Phones> phones) {
		this.phones = phones;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", created="
				+ created + ", isactive=" + isactive + ", phones=" + phones + "]";
	}

	
	


	
	
}
