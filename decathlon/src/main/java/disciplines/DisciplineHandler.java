package disciplines;

import java.util.ArrayList;
import java.util.List;

public class DisciplineHandler {
    public static List<Discipline> getDisciplinesList() {
        List<Discipline> disciplineList = new ArrayList<>();
        disciplineList.add(new HundredMeters());
        disciplineList.add(new LongJump());
        disciplineList.add(new ShotPut());
        disciplineList.add(new HighJump());
        disciplineList.add(new FourHundredMeters());
        disciplineList.add(new HundredTenMetersHurdles());
        disciplineList.add(new DiscusThrow());
        disciplineList.add(new PoleVault());
        disciplineList.add(new JavelinThrow());
        disciplineList.add(new ThousandFiveHundredMeters());
        return disciplineList;
    }
}
