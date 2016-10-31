package by.pvt.dumping.controller;

import by.pvt.dumping.constants.ConfigConstants;
import by.pvt.dumping.managers.ConfigManager;
import by.pvt.dumping.managers.MessageManager;
import by.pvt.dumping.service.ICategoryService;
import by.pvt.dumping.service.IProductService;
import by.pvt.dumping.service.IUserService;
import by.pvt.dumping.utils.MenuHelper;
import by.pvt.dumping.utils.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IUserService userService;
    @Autowired
    private Paginator paginator;
    @Autowired
    private MenuHelper menuHelper;
    @Autowired
    private ConfigManager configManager;
    @Autowired
    private MessageManager messageManager;

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String showMainPage() {
        return configManager.getProperty(ConfigConstants.ADMIN_PAGE_PATH);
    }

}
