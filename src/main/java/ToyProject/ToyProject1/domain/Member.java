package ToyProject.ToyProject1.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//시퀀스처럼 사용하기위해 선언
    private Long id;
    @Column(unique = true, nullable = false)
    private String userid;
    @Column(nullable = false)
    private String pwd ;
    private String name;
    private String email;
    private String tel;
    private String addr;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")//값을 저장할때 현재 시간을 저장함
    private LocalDateTime joindate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public LocalDateTime getJoindate() {
        return joindate;
    }

    public void setJoindate(LocalDateTime joindate) {
        this.joindate = joindate;
    }
}
