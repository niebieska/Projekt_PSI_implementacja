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


		Kurs Pd1 = new Kurs("Projekt", 30, "Praca dyplomowa I");
		Kurs Twwo1 = new Kurs("Laboratioria", 15, "Technologie wspierające wytwarzanie oprogramowania");
		Kurs Twwo2 = new Kurs("Wykład", 15, "Technologie wspierające wytwarzanie oprogramowania");
		Kurs Bswm1 = new Kurs("Laboratioria", 30, "Bezpieczeństwo systemów webowych i mobilnych");
		Kurs Bswm2 = new Kurs("Seminaria", 30, "Bezpieczeństwo systemów webowych i mobilnych");
		Kurs Bswm3 = new Kurs("Wykład", 30, "Bezpieczeństwo systemów webowych i mobilnych");
		Kurs Pdzd1 = new Kurs("Projekt", 30, "Przetwarzanie dużych zbiorów danych");
		Kurs Pdzd2 = new Kurs("Wykład", 15, "Przetwarzanie dużych zbiorów danych");
		Kurs Ipod1 = new Kurs("Projekt", 30, "Inżynieria pozyskiwania i ochrony wiedzy z danych i baz danych");
		Kurs Ipod2 = new Kurs("Wykład", 15, "Inżynieria pozyskiwania i ochrony wiedzy z danych i baz danych");
		Kurs Psi1 = new Kurs("Wykład", 15, "Projektowanie systemów informatychnych");
		Kurs Psi2 = new Kurs("Projekt", 30, "Projektowanie systemów informatychnych");
		Kurs Pbowi = new Kurs("Projekt", 30, "Podstawy biznesu i ochrona własności intelektualnej");

		ArrayList<Kurs> kursPd = new ArrayList<Kurs>();
		kursPd.add(Pd1);

		Modul m = new Modul(80,"Projektowanie systemów informatychnych", false, false, kursPd);

	}

}
