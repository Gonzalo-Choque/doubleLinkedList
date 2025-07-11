import exercises.Exercises;
import org.junit.Assert;
import org.junit.Test;

public class ExercisesTest {

    Exercises exercises = new Exercises();

    @Test
    public void twoCharacteres_case_1() {
        Assert.assertEquals(exercises.twoCharacters("abc"), 0);
    }

    @Test
    public void twoCharacteres_case_2() {
        Assert.assertEquals(exercises.twoCharacters("abca"), 3);
    }

    @Test
    public void twoCharacteres_case_3() {
        Assert.assertEquals(exercises.twoCharacters("aabbccddee"), 4);
    }

    @Test
    public void twoCharacteres_case_4() {
        Assert.assertEquals(exercises.twoCharacters("dddaacccbfg"), 6);
    }
}
