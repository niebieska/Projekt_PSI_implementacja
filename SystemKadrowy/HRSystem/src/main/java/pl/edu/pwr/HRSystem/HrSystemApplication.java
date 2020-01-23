package pl.edu.pwr.HRSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pwr.HRSystem.mockUpy.Pracownik;


@SpringBootApplication
public class HrSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrSystemApplication.class, args);
		Pracownik pracownik = new Pracownik("Paulina", "Wątroba",
				"paulina.watroba@pwr.edu.pl","Paulina.Wantroba", "Inż","Pracownik  zewnątrzny",
				"Pracownik  zewnątrzny", 240, true, true);

		Pracownik pracownik1 = new Pracownik("Mykhailo", "Stavniichuk",
				"mykhailo.stavniichuk@pwr.edu.pl","Mykhailo.Stavniichuk", "Inż","Pracownik  zewnątrzny",
				"Pracownik  zewnątrzny", 240, true, true);

		Pracownik pracownik2 = new Pracownik("Mateusz", "Klimiuk",
				"mateusz.klimiuk@pwr.edu.pl","Mateusz.Klimiuk", "Inż","Pracownik  zewnątrzny",
				"Pracownik  zewnątrzny", 240, true, true);
	}

}
