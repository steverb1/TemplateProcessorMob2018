import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by steve on 4/13/18.
 */
public class TestTemplate
{

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void whenCodeSubstringIsMissing_throwsOutOfBounds() {
        TemplateProcessor processor = new TemplateProcessor();
        processor.process("longstringlongstring", "longish", "short");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void whenAltCodeSubstringIsMissing_throwsOutOfBounds()
    {
        TemplateProcessor processor = new TemplateProcessor();
        processor.process("long%CODE%string", "longish", "short");

    }

    @Test
    public void shouldExecute()
    {
        TemplateProcessor processor = new TemplateProcessor();
        String result = processor.process("long%CODE%string", "longish%ALTCODE%", "short");
        assertThat(result, is("longlongishlongi-sh%string"));
    }

}
