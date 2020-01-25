package pl.edu.pwr.CourseEnrollmentSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.CourseEnrollmentSystem.mockUpy.IdentyfikatorSemestruDto;
import pl.edu.pwr.CourseEnrollmentSystem.mockUpy.KursDto;
import pl.edu.pwr.CourseEnrollmentSystem.mockUpy.ModulDto;
import pl.edu.pwr.CourseEnrollmentSystem.mockUpy.PlanStudiowDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @GetMapping("/getSchedule")
    public List<PlanStudiowDto> getSchedule() {
        KursDto Pd1 = new KursDto(0, "Projekt", 30, 0, "Praca dyplomowa I");
        KursDto Twwo1 = new KursDto(0, "Laboratioria", 30, 0, "Technologie wspierające wytwarzanie oprogramowania");
        KursDto Twwo2 = new KursDto(0, "Wykład", 15, 0, "Technologie wspierające wytwarzanie oprogramowania");
        KursDto Bswm1 = new KursDto(0, "Laboratioria", 30, 0, "Bezpieczeństwo systemów webowych i mobilnych");
        KursDto Bswm2 = new KursDto(0, "Seminaria", 30, 0, "Bezpieczeństwo systemów webowych i mobilnych");
        KursDto Bswm3 = new KursDto(0, "Wykład", 30, 0, "Bezpieczeństwo systemów webowych i mobilnych");
        KursDto Pdzd1 = new KursDto(0, "Projekt", 30, 0, "Przetwarzanie dużych zbiorów danych");
        KursDto Pdzd2 = new KursDto(0, "Wykład", 30, 0, "Przetwarzanie dużych zbiorów danych");
        KursDto Ipod1 = new KursDto(0, "Projekt", 30, 0, "Inżynieria pozyskiwania i ochrony wiedzy z danych i baz " +
                "danych");
        KursDto Ipod2 = new KursDto(0, "Wykład", 15, 0, "Inżynieria pozyskiwania i ochrony wiedzy z danych i baz " +
                "danych");
        KursDto Psi1 = new KursDto(0, "Wykład", 15, 0, "Projektowanie systemów informatychnych");
        KursDto Psi2 = new KursDto(0, "Projekt", 30, 0, "Projektowanie systemów informatychnych");
        KursDto Pbowi1 = new KursDto(0, "Projekt", 30, 0, "Podstawy biznesu i ochrona własności intelektualnej");

        ArrayList<KursDto> kursPd = new ArrayList<KursDto>();
        kursPd.add(Pd1);

        ArrayList<KursDto> kursTwwo = new ArrayList<KursDto>();
        kursTwwo.add(Twwo1);
        kursTwwo.add(Twwo2);

        ArrayList<KursDto> kursBswm = new ArrayList<KursDto>();
        kursBswm.add(Bswm1);
        kursBswm.add(Bswm2);
        kursBswm.add(Bswm3);

        ArrayList<KursDto> kursPdzd = new ArrayList<KursDto>();
        kursPdzd.add(Pdzd1);
        kursPdzd.add(Pdzd2);

        ArrayList<KursDto> kursIpod = new ArrayList<KursDto>();
        kursIpod.add(Ipod1);
        kursIpod.add(Ipod2);

        ArrayList<KursDto> kursPsi = new ArrayList<KursDto>();
        kursPsi.add(Psi1);
        kursPsi.add(Psi2);

        ArrayList<KursDto> kursPbowi = new ArrayList<KursDto>();
        kursPbowi.add(Pbowi1);


        ModulDto mPd = new ModulDto(0, 30, "Praca dyplomowa I", false, false, kursPd);
        ModulDto mTwwo = new ModulDto(0, 45, "Technologie wspierające wytwarzanie oprogramowania", false, false,
                kursTwwo);
        ModulDto mBswm = new ModulDto(0, 90, "Bezpieczeństwo systemów webowych i mobilnych", false, false, kursBswm);
        ModulDto mPdzd = new ModulDto(0, 60, "Przetwarzanie dużych zbiorów danych", false, false, kursPdzd);
        ModulDto mIpod = new ModulDto(0, 45, "Inżynieria pozyskiwania i ochrony wiedzy z danych i baz danych", false,
                false, kursIpod);
        ModulDto mPsi = new ModulDto(0, 45, "Projektowanie systemów informatychnych", false, false, kursPsi);
        ModulDto mPbowi = new ModulDto(0, 30, "Podstawy biznesu i ochrona własności intelektualnej", false, false,
                kursPbowi);

        ArrayList<ModulDto> moduls = new ArrayList<ModulDto>();
        moduls.add(mPd);
        moduls.add(mTwwo);
        moduls.add(mBswm);
        moduls.add(mPdzd);
        moduls.add(mIpod);
        moduls.add(mPsi);
        moduls.add(mPbowi);

        ArrayList<PlanStudiowDto> plans = new ArrayList<>();

        plans.add(new PlanStudiowDto(250, new IdentyfikatorSemestruDto("Zima 2019/2020", "Informatyka", "Inżynieria " +
                "oprogramowania", 1), moduls));
        return plans;
    }
}
