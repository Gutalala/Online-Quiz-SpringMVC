package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "onlinequiz", catalog = "")
public class UsersHB {

    @OneToMany(mappedBy = "usersHB")
    private List<QuizHB> quizHB;

    public List<QuizHB> getQuizHB() {
        return quizHB;
    }

    public void setQuizHB(List<QuizHB> quizHB) {
        this.quizHB = quizHB;
    }

    @Id
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "full_name")
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "IsActive", columnDefinition = "BIT", length = 1)
    private Byte isActive;

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersHB usersHB = (UsersHB) o;

        if (id != usersHB.id) return false;
        if (username != null ? !username.equals(usersHB.username) : usersHB.username != null) return false;
        if (password != null ? !password.equals(usersHB.password) : usersHB.password != null) return false;
        if (fullName != null ? !fullName.equals(usersHB.fullName) : usersHB.fullName != null) return false;
        if (role != null ? !role.equals(usersHB.role) : usersHB.role != null) return false;
        if (isActive != null ? !isActive.equals(usersHB.isActive) : usersHB.isActive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }
}
