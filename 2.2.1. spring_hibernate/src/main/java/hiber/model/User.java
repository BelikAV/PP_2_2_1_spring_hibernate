package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   public User() {}

   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
   }

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id",referencedColumnName = "id")
   private Car car;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", car=" + car +
              '}';
   }
}


//Тз уже более адекватное и все понятно. Напишу для тех, кто запутался, создаете свой класс кар по аналогии с юзером,
//далее переходите в db_properties там вставляете свои данные, после этого смотрите пару роликов про OneToOne,
//далее связываете свои классы через конструктор, поле, сеттер. Я делал через сеттер, после чего у вас уже почти
//все готово, осталось добавить свой кар класс в настройки хибера, находите нужный класс и там будет добавить
//в аннотациионные классы свой, просто рядом через запятую, далее осталось написать метод, пишите его в юзер дао,
//и в дао импл реализуете его при помощи hql запроса - с ним конечно повозился, ну и в сервисы тоже этот метод добавьте.
