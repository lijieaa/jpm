package ${packageName}.${moduleName}.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * ${functionName}Controller
 * @author ${functionAuthor}
 * @version ${functionVersion}
 */
@Controller
@RequestMapping("${moduleName}/${class_name}")
public class ${ClassName}Controller {
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public String list() {
        return "${moduleName}/${class_name}_list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "form")
    public String add() {
        return "${moduleName}/${class_name}_form";
    }

    @RequestMapping(method = RequestMethod.GET, value = "detail")
    public String detail() {
        return "${moduleName}/${class_name}_detail";
    }
}
