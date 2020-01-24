package pl.edu.pwr.AssignmentsSystem.Raporty.Entrypoints.Dto;


import pl.edu.pwr.AssignmentsSystem.Powierzenia.Entrypoints.Dto.PlanPowierzenDto;


import java.util.ArrayList;

public class RaportDto {

    ArrayList<PlanPowierzenDto> powierzenia;

    public RaportDto(ArrayList<PlanPowierzenDto> powierzenia) {
        this.powierzenia = powierzenia;
    }

    public ArrayList<PlanPowierzenDto> getPowierzenia() {
        return powierzenia;
    }

    public void setPowierzenia(ArrayList<PlanPowierzenDto> powierzenia) {
        this.powierzenia = powierzenia;
    }
}
