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
        String altCode = reqId;

        // Substitute for %CODE%
        template = foo(template, altCode, CODE);
        String altcode = reqId.substring(0, 5) + "-" + reqId.substring(5, 8);

        // Substitute for %ALTCODE%
        return foo(template, altcode, ALTCODE);
    }

    private String foo(String template, String altCode, String code)
    {
        int templateSplitBegin = template.indexOf(code);
        int templateSplitEnd = templateSplitBegin + code.length();
        String templatePartOne = template.substring(0, templateSplitBegin);
        String templatePartTwo = template.substring(templateSplitEnd, template.length());

        template = templatePartOne + altCode + templatePartTwo;
        return template;
    }

}