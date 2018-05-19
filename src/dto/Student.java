package dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sid;
	
	@Column(nullable=false,unique=true)
	private String sno;
	
	@Column(nullable=false)
	private String sname;
	
	@Column(nullable=false)
	private String sex;
	
	@Column(nullable=false)
	private String tel;
	
	private String upimg;
	
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	@ManyToOne(targetEntity=Clazz.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="id",nullable=false)
	private Clazz clazz;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getUpimg() {
		return upimg;
	}

	public void setUpimg(String upimg) {
		this.upimg = upimg;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sno=" + sno + ", sname=" + sname
				+ ", sex=" + sex + ", tel=" + tel + ", upimg=" + upimg
				+ ", birth=" + birth + "]";
	}
	
	
}
