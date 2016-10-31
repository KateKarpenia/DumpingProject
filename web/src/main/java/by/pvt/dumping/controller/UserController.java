package by.pvt.dumping.controller;

import by.pvt.dumping.constants.ConfigConstants;
import by.pvt.dumping.constants.MessageConstants;
import by.pvt.dumping.constants.Parameters;
import by.pvt.dumping.constants.UserType;
import by.pvt.dumping.entity.Category;
import by.pvt.dumping.entity.Product;
import by.pvt.dumping.entity.User;
import by.pvt.dumping.managers.ConfigManager;
import by.pvt.dumping.managers.MessageManager;
import by.pvt.dumping.service.ICategoryService;
import by.pvt.dumping.service.IProductService;
import by.pvt.dumping.service.IUserService;
import by.pvt.dumping.service.exceptions.ServiceException;
import by.pvt.dumping.utils.MenuHelper;
import by.pvt.dumping.utils.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Map;


@Controller
@SessionAttributes(value = {Parameters.CATEGORY_LIST, Parameters.USER, Parameters.USERTYPE, Parameters.PAGINATION_MENU, Parameters.PAGINATION_PARAMS, Parameters.LOCALE})
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;
    @Autowired
    private Paginator paginator;
    @Autowired
    private MenuHelper menuHelper;
    @Autowired
    private ConfigManager configManager;
    @Autowired
    private MessageManager messageManager;

    @ModelAttribute
    public Locale createDefaultLocale() {return new Locale("ru", "RU");}

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String initializeResources(HttpServletRequest request, ModelMap model) {
        String page;
        try {
            List<Category> categoryList = categoryService.findAll();
            model.addAttribute(Parameters.CATEGORY_LIST, categoryList);

            page = configManager.getProperty(ConfigConstants.MAIN_PAGE_PATH);
        } catch (ServiceException e) {
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.addAttribute(Parameters.ERROR_DATABASE, messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
        }
        return "redirect:/" + page;
    }

    @RequestMapping(value = {"/main"}, method = RequestMethod.GET)
    public String showMainPage(HttpServletRequest request, @RequestParam(value = Parameters.LANGUAGE, required = false) String language, ModelMap model) {

        changeLanguage(model, language);
        Map<String, Integer> paginationParams;
        String page;

        try {
            paginationParams = paginator.update(request, productService.count());
            model.addAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
            model.addAttribute(Parameters.PAGINATION_MENU,
                    menuHelper.createStringMenu(paginationParams));

            List<Product> productList = productService.findAll(paginationParams);
            model.addAttribute(Parameters.PRODUCT_LIST, productList);

            List<Category> categoryList = categoryService.findAll();
            model.addAttribute(Parameters.CATEGORY_LIST, categoryList);

            page = configManager.getProperty(ConfigConstants.MAIN_PAGE_PATH);
        }
        catch (ServiceException e) {
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.addAttribute(Parameters.ERROR_DATABASE,
                    messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
        }
        model.addAttribute(Parameters.CURRENT_PAGE, page);
        return page;
    }

    @RequestMapping(value = {"/category"}, method = RequestMethod.GET)
    public String showProductsCategoryPage(HttpServletRequest request, @RequestParam(value = Parameters.LANGUAGE, required = false) String language, ModelMap model) {

        changeLanguage(model, language);
        Map<String, Integer> paginationParams;
        HttpSession session = request.getSession();
        String page;
        User currentUser = (User) session.getAttribute(Parameters.USER);
        String selectedCategoryId = request.getParameter(Parameters.SELECTED_CATEGORY_ID);

        int id = 0;
        if (selectedCategoryId != null) {
            id = Integer.valueOf(request.getParameter(Parameters.SELECTED_CATEGORY_ID));
            session.setAttribute(Parameters.SELECTED_CATEGORY_ID, selectedCategoryId);
        } else if (session.getAttribute(Parameters.SELECTED_CATEGORY_ID) != null) {
            id = Integer.valueOf(session.getAttribute(Parameters.SELECTED_CATEGORY_ID).toString());
        }

        try {
            if (currentUser == null) {

                paginationParams = paginator.update(request, productService.countProductsInCategory(id));
//                model.addAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
                model.addAttribute(Parameters.PAGINATION_MENU,
                        menuHelper.createStringMenu(paginationParams));

                List<Product> productList = productService.getProductsInCategory(id, paginationParams);
                model.addAttribute(Parameters.PRODUCT_LIST, productList);

                page = configManager.getProperty(ConfigConstants.CATEGORY_VIEW_PAGE_PATH);
            } else {

                paginationParams = paginator.update(request,
                        productService.countProductsInCategoryByLogin(id, currentUser.getEmail()));
                model.addAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
                model.addAttribute(Parameters.PAGINATION_MENU,
                        menuHelper.createStringMenu(paginationParams));

                List<Product> productList = productService.getProductsInCategoryByLogin(id,
                        currentUser.getEmail(), paginationParams);
                model.addAttribute(Parameters.PRODUCT_LIST, productList);

                page = configManager.getProperty(ConfigConstants.CATEGORY_VIEW_PAGE_PATH);
            }
        }
        catch (ServiceException e) {
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.addAttribute(Parameters.ERROR_DATABASE,
                    messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
        }
        model.addAttribute(Parameters.CURRENT_PAGE, page);
        return page;
    }

    @RequestMapping(value = {"/bodytext"}, method = RequestMethod.GET)
    public String showBodyTextPage(HttpServletRequest request, @RequestParam(value = Parameters.LANGUAGE, required = false) String language, ModelMap model) {

        changeLanguage(model, language);
        HttpSession session = request.getSession();
        String page;
        String selectedProductId = request.getParameter(Parameters.SELECTED_PRODUCT_ID);
        User currentUser = (User) session.getAttribute(Parameters.USER);

        int id = 0;
        if (selectedProductId != null) {
            id = Integer.valueOf(request.getParameter(Parameters.SELECTED_PRODUCT_ID));
            session.setAttribute(Parameters.SELECTED_PRODUCT_ID, selectedProductId);
        } else if (session.getAttribute(Parameters.SELECTED_PRODUCT_ID) != null) {
            id = Integer.valueOf(session.getAttribute(Parameters.SELECTED_PRODUCT_ID).toString());
        }

        try {
            Product product = productService.find(id);
            model.addAttribute(Parameters.PRODUCT, product);
            if (currentUser == null) {
                User user = product.getUser();
                model.addAttribute(Parameters.USER, user);
                page = configManager.getProperty(ConfigConstants.PRODUCT_DETAIL_PAGE);
            } else {
                page = configManager.getProperty(ConfigConstants.PRODUCT_DETAIL_PAGE);
            }
        }
        catch (ServiceException e) {
            page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.addAttribute(Parameters.ERROR_DATABASE,
                    messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
        }

        return page;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(ModelMap model) {
        model.addAttribute(Parameters.USER, new User());
        return configManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest request,
                            @ModelAttribute(Parameters.USER) @Valid User userDTO,
                            BindingResult bindingResult,
                            ModelMap model) {

        Map<String, Integer> paginationParams;
        String page;
//        HttpSession session = request.getSession();
//        User currentUser = (User) session.getAttribute(Parameters.USER);

        if(!bindingResult.hasErrors()) {
            String login = userDTO.getEmail();
            try {
                if (userService.checkAuthentication(login, userDTO.getPassword())) {
                    User user = userService.find(login);
                    model.addAttribute(Parameters.USERTYPE, UserType.USER);
                    model.addAttribute(Parameters.USER, user);

                    paginationParams = paginator.update(request, productService.countProductsByLogin(login));
                    model.addAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
                    model.addAttribute(Parameters.PAGINATION_MENU,
                            menuHelper.createStringMenu(paginationParams));

                    List<Product> productList = productService.getProductsByLogin(login, paginationParams);
                    model.addAttribute(Parameters.PRODUCT_LIST, productList);
                    //change path
                    page = configManager.getProperty(ConfigConstants.MAIN_PAGE_PATH);

                } else {
                    model.addAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD,
                            messageManager.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD, request));
                    page = configManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
                }

//                if (currentUser != null) {
//                    login = currentUser.getEmail();
//                    paginationParams = paginator.update(request, productService.countProductsByLogin(login));
//                    model.addAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
//                    model.addAttribute(Parameters.PAGINATION_MENU,
//                            menuHelper.createStringMenu(paginationParams));
//
//                    List<Product> productList = productService.getProductsByLogin(login, paginationParams);
//                    request.setAttribute(Parameters.PRODUCT_LIST, productList);
////                    change path
//                    page = configManager.getProperty(ConfigConstants.MAIN_PAGE_PATH);
//                }
            } catch (ServiceException e) {
                model.addAttribute(Parameters.ERROR_DATABASE,
                        messageManager.getProperty(MessageConstants.ERROR_DATABASE, request));
                page = configManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);

            }
        } else {
            page = configManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
        }
        return page;
    }

    private void changeLanguage(ModelMap model, String language) {
        if (language != null) {
            if (language.equals("en")) {
                model.replace(Parameters.LOCALE, new Locale("en", "US"));
            } else {
                model.replace(Parameters.LOCALE, new Locale("ru", "RU"));
            }
        }
    }




}
