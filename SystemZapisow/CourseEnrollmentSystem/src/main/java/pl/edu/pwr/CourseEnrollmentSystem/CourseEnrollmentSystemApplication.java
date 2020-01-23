package pl.edu.pwr.CourseEnrollmentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pwr.CourseEnrollmentSystem.mockUpy.Kurs;

import pl.edu.pwr.CourseEnrollmentSystem.mockUpy.Modul;
import pl.edu.pwr.CourseEnrollmentSystem.mockUpy.PlanStudiow;

import java.util.ArrayList;

@SpringBootApplication
public class CourseEnrollmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseEnrollmentSystemApplication.class, args);

		/*PlanStudiow planStudiow = new PlanStudiow("Zima 2019/2020", 2500, "Informatyka", "Inżynieria oprogramowania",1,
				new Modul(80,"Projektowanie systemów informatychnych", false, false,
						(new Kurs("Wykład", 30, "Projektowanie systemów informatychnych" ))));*/



	}

}
