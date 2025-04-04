package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      Car car1 =  new Car(13, "BMW");
      Car car2 = new Car(14, "Toyota Camry");
      Car car3 = new Car(15, "Lamborgini");
      Car car4 = new Car(16, "Mazda");


      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);

      List<Car> carList = carService.listCars();


      userService.add(new User("User1", "Lastname1", "user1@mail.ru", carList.get(0)
             ));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",
              carList.get(1)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",
              carList.get(2)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",
              carList.get(3)));



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().getModel());

      }
      User user = carService.findUserbyCarSerialAndModel(13, "BMW");
      if (user != null) {
      System.out.println("Car owner " + user.getFirstName() + " " + user.getLastName());
   } else {
      System.out.println(" The car owner was not found ");
   }

      context.close();
   }
}
