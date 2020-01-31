package pl.edu.pwr.AssignmentsSystem.Prowadzacy.Entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.ProwadzacyDto;
import pl.edu.pwr.AssignmentsSystem.Prowadzacy.Usecase.ProwadzacyService;

import java.util.List;

@CrossOrigin
@RestController
public class ProwadzacyController {

    @Autowired
    private ProwadzacyService prowadzacyService;

    @GetMapping("/allProwadzacy")
    public List<ProwadzacyDto> getAllProwadzacy()
    {
        return prowadzacyService.getAllProwadzacy();
    }

    @GetMapping("/importUzytkownikow")
    public void importUzytkownikow()
    {
        prowadzacyService.importUzytkownikow();
    }
}
