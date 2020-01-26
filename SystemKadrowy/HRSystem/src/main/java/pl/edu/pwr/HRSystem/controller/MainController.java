package pl.edu.pwr.HRSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.HRSystem.mockUpy.Pracownik;

import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

    @GetMapping("/getStaff")
    public List<Pracownik> getAllStaff(){
        Pracownik pracownik = new Pracownik("Paulina", "Wątroba",
                "paulina.watroba@pwr.edu.pl", "Inż","Pracownik  zewnątrzny",
                "Pracownik  zewnątrzny", 240, true, true);

        Pracownik pracownik1 = new Pracownik("Mykhailo", "Stavniichuk",
                "mykhailo.stavniichuk@pwr.edu.pl", "Inż","Pracownik  zewnątrzny",
                "Pracownik  zewnątrzny", 240, true, true);

        Pracownik pracownik2 = new Pracownik("Mateusz", "Klimiuk",
                "mateusz.klimiuk@pwr.edu.pl", "Inż","Pracownik  zewnątrzny",
                "Pracownik  zewnątrzny", 240, true, true);
        return Arrays.asList(pracownik, pracownik1, pracownik2);
    }
}
