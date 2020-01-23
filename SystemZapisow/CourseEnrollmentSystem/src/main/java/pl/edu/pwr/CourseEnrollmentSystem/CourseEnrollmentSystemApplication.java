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


        Kurs Pd1 = new Kurs("Projekt", 30, "Praca dyplomowa I");
        Kurs Twwo1 = new Kurs("Laboratioria", 30, "Technologie wspierające wytwarzanie oprogramowania");
        Kurs Twwo2 = new Kurs("Wykład", 15, "Technologie wspierające wytwarzanie oprogramowania");
        Kurs Bswm1 = new Kurs("Laboratioria", 30, "Bezpieczeństwo systemów webowych i mobilnych");
        Kurs Bswm2 = new Kurs("Seminaria", 30, "Bezpieczeństwo systemów webowych i mobilnych");
        Kurs Bswm3 = new Kurs("Wykład", 30, "Bezpieczeństwo systemów webowych i mobilnych");
        Kurs Pdzd1 = new Kurs("Projekt", 30, "Przetwarzanie dużych zbiorów danych");
        Kurs Pdzd2 = new Kurs("Wykład", 30, "Przetwarzanie dużych zbiorów danych");
        Kurs Ipod1 = new Kurs("Projekt", 30, "Inżynieria pozyskiwania i ochrony wiedzy z danych i baz danych");
        Kurs Ipod2 = new Kurs("Wykład", 15, "Inżynieria pozyskiwania i ochrony wiedzy z danych i baz danych");
        Kurs Psi1 = new Kurs("Wykład", 15, "Projektowanie systemów informatychnych");
        Kurs Psi2 = new Kurs("Projekt", 30, "Projektowanie systemów informatychnych");
        Kurs Pbowi1 = new Kurs("Projekt", 30, "Podstawy biznesu i ochrona własności intelektualnej");

        ArrayList<Kurs> kursPd = new ArrayList<Kurs>();
        kursPd.add(Pd1);

        ArrayList<Kurs> kursTwwo = new ArrayList<Kurs>();
        kursTwwo.add(Twwo1);
        kursTwwo.add(Twwo2);

        ArrayList<Kurs> kursBswm = new ArrayList<Kurs>();
        kursBswm.add(Bswm1);
        kursBswm.add(Bswm2);
        kursBswm.add(Bswm3);

        ArrayList<Kurs> kursPdzd = new ArrayList<Kurs>();
        kursPdzd.add(Pdzd1);
        kursPdzd.add(Pdzd2);

        ArrayList<Kurs> kursIpod = new ArrayList<Kurs>();
        kursIpod.add(Ipod1);
        kursIpod.add(Ipod2);

        ArrayList<Kurs> kursPsi = new ArrayList<Kurs>();
        kursPsi.add(Psi1);
        kursPsi.add(Psi2);

        ArrayList<Kurs> kursPbowi = new ArrayList<Kurs>();
        kursPbowi.add(Pbowi1);


        Modul mPd = new Modul(30, "Praca dyplomowa I", false, false, kursPd);
        Modul mTwwo = new Modul(45, "Technologie wspierające wytwarzanie oprogramowania", false, false, kursTwwo);
        Modul mBswm = new Modul(90, "Bezpieczeństwo systemów webowych i mobilnych", false, false, kursBswm);
        Modul mPdzd = new Modul(60, "Przetwarzanie dużych zbiorów danych", false, false, kursPdzd);
        Modul mIpod = new Modul(45, "Inżynieria pozyskiwania i ochrony wiedzy z danych i baz danych", false, false, kursIpod);
        Modul mPsi = new Modul(45, "Projektowanie systemów informatychnych", false, false, kursPsi);
        Modul mPbowi = new Modul(30, "Podstawy biznesu i ochrona własności intelektualnej", false, false, kursPbowi);

        ArrayList<Modul> moduls = new ArrayList<Modul>();
        moduls.add(mPd);
        moduls.add(mTwwo);
        moduls.add(mBswm);
        moduls.add(mPdzd);
        moduls.add(mIpod);
        moduls.add(mPsi);
        moduls.add(mPbowi);

        PlanStudiow planStudiow = new PlanStudiow("Zima 2019/2020", 2500, "Informatyka", "Inżynieria oprogramowania", 1, moduls);


    }

}
