package pl.edu.pwr.AssignmentsSystem.Commons.Utils;

import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Kurs;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Modul;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanStudiow;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.KursDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.ModulDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanStudiowDto;

import java.util.stream.Collectors;

public class KursMapper {

    public static KursDto toKursDto(Kurs kurs) {
        return new KursDto(kurs.getId(), kurs.getFormaZajec(), kurs.getLiczbaGodzin(), kurs
                .getLiczbaGrup(), kurs.getNazwa());
    }

    public static ModulDto  toModulDto(Modul modul) {
        return new ModulDto(modul.getId(), modul.getLiczbaGodzin(), modul.getNazwa(), modul
                .isOgolnouczelniany(), modul.isWybieralny(), modul.getKursList().stream().map(KursMapper::toKursDto)
                .collect(Collectors.toList()));
    }

    public static PlanStudiowDto toPlanStudioDto(PlanStudiow planStudiow)
    {
        IdentyfikatorSemestruDto id = new IdentyfikatorSemestruDto(planStudiow.getCyklKsztalcenia(), planStudiow.getKierunekStudiow(), planStudiow.getSpecjalnosc(), planStudiow.getNumerSemestru());
        return new PlanStudiowDto(planStudiow.getLiczbaStudentow(), id, planStudiow.getModulList().stream().map(KursMapper::toModulDto).collect(Collectors.toList()));
    }
    public static PlanStudiow toPlanStudiow(PlanStudiowDto planStudiowDto)
    {
        PlanStudiow planStudiow = new PlanStudiow();
        planStudiow.setCyklKsztalcenia(planStudiowDto.getIdentyfikatorSemestru().getCyklKsztalcenia());
        planStudiow.setKierunekStudiow(planStudiowDto.getIdentyfikatorSemestru().getKierunekStudiow());
        planStudiow.setSpecjalnosc(planStudiowDto.getIdentyfikatorSemestru().getSpecjalnosc());
        planStudiow.setNumerSemestru(planStudiowDto.getIdentyfikatorSemestru().getNumerSemestru());
        planStudiow.setLiczbaStudentow(planStudiowDto.getLiczbaStudentow());
        planStudiow.setModulList(planStudiowDto.getModulDto().stream().map(KursMapper::toModul).collect(Collectors.toList()));
        return planStudiow;
    }
    public static Kurs toKurs(KursDto kursDto) {
        return new Kurs(kursDto.getId(), kursDto.getFormaZajec(), kursDto.getLiczbaGodzin(), kursDto.getNazwa(), null,0);
    }

    public static Modul  toModul(ModulDto modulDto) {
        Modul modul = new Modul(modulDto.getLiczbaGodzin(), modulDto.getNazwa(), modulDto
                .getOgolnouczelniany(), modulDto.getWybieralny(), null);
        modul.setKursList( modulDto.getKursy().stream().map(KursMapper::toKurs).collect(Collectors.toList()));
        return modul;
    }
}
