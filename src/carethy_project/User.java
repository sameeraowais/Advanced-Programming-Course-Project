package carethy_project;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="carethy")
  public class User implements java.io.Serializable{
   @Id
@Column(name="username")
private String username;
@Column(name="email")
private String email;
@Column(name="password")
private String password;

 @Column(name="weight")
private double weight;
@Column(name="height")
private double height;
@Column(name="weightunit")
private String weightunit;
@Column(name="heightunit")
private String heightunit;
@Column(name="calories")
private double calories;
@Column(name="dayscompleted")
private int dayscompleted;
@Column(name="numberofexer")
private int numberofexer;
@Column(name="typeofexer")
private String typeofexer;
@Column(name="challenge")
private String challenge;
@Column(name="weeks")
private String weeks;
@Column(name="days")
private String days;

public User() {
}

 public User(String username, String email, String password, double weight, double height, String weightunit, String heightunit, double calories, int dayscompleted, int numberofexer, String typeofexer, String challenge, String weeks, String days) {
this.username = username;
this.email = email;
this.password = password;
this.weight = weight;
this.height = height;
this.weightunit = weightunit;
this.heightunit = heightunit;
this.calories = calories;
this.dayscompleted = dayscompleted;
this.numberofexer = numberofexer;
this.typeofexer = typeofexer;
this.challenge = challenge;
this.weeks = weeks;
this.days = days;
}

 public String getDays() {
return days;
}

 public void setDays(String days) {
this.days = days;
}


 public void setUsername(String username) {
this.username = username;
}

 public void setEmail(String email) {
this.email = email;
}

 public void setPassword(String password) {
this.password = password;
}

 public void setWeight(double weight) {
this.weight = weight;
}

 public void setHeight(double height) {
this.height = height;
}

 public void setWeightunit(String weightunit) {
this.weightunit = weightunit;
}

 public void setHeightunit(String heightunit) {
this.heightunit = heightunit;
}

 public void setCalories(double calories) {
this.calories = calories;
}

 public void setDayscompleted(int dayscompleted) {
this.dayscompleted = dayscompleted;
}

 public void setNumberofexer(int numberofexer) {
this.numberofexer = numberofexer;
}

 public void setTypeofexer(String typeofexer) {
this.typeofexer = typeofexer;
}

 public void setChallenge(String challenge) {
this.challenge = challenge;
}

 public void setWeeks(String weeks) {
this.weeks = weeks;
}

 public String getUsername() {
return username;
}

 public String getEmail() {
return email;
}

 public String getPassword() {
return password;
}

 public double getWeight() {
return weight;
}

 public double getHeight() {
return height;
}

 public String getWeightunit() {
return weightunit;
}

 public String getHeightunit() {
return heightunit;
}

 public double getCalories() {
return calories;
}

 public int getDayscompleted() {
return dayscompleted;
}

 public int getNumberofexer() {
return numberofexer;
}

 public String getTypeofexer() {
return typeofexer;
}

 public String getChallenge() {
return challenge;
}

 public String getWeeks() {
return weeks;
}

    Object getweight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object getheight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}