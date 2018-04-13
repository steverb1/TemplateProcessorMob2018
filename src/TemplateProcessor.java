public class TemplateProcessor {

    public static final String CODE = "%CODE%";
    public static final String ALTCODE = "%ALTCODE%";

    @Deprecated
    public String process(String sourceTemplate, String reqId, String code) {

        return process(sourceTemplate, reqId);
    }

    public String process(String sourceTemplate, String reqId)
    {
        String template = sourceTemplate;

        // Substitute for %CODE%
        int templateSplitBegin = template.indexOf(CODE);
        int templateSplitEnd = templateSplitBegin + CODE.length();
        String templatePartOne = template.substring(0, templateSplitBegin);
        String templatePartTwo = template.substring(templateSplitEnd, template.length());

        template = templatePartOne + reqId + templatePartTwo;

        // Substitute for %ALTCODE%
        templateSplitBegin = template.indexOf(ALTCODE);
        templateSplitEnd = templateSplitBegin + ALTCODE.length();
        templatePartOne = template.substring(0, templateSplitBegin);
        templatePartTwo = template.substring(templateSplitEnd, template.length());

        String altcode = reqId.substring(0, 5) + "-" + reqId.substring(5, 8);
        return templatePartOne + altcode + templatePartTwo;
    }

}