//package by.pvt.dumping.controller;
//
//import by.pvt.dumping.constants.ConfigConstants;
//import by.pvt.dumping.constants.MessageConstants;
//import by.pvt.dumping.constants.Parameters;
//import by.pvt.dumping.entity.Category;
//import by.pvt.dumping.entity.Product;
//import by.pvt.dumping.managers.ConfigManager;
//import by.pvt.dumping.managers.MessageManager;
//import by.pvt.dumping.service.ICategoryService;
//import by.pvt.dumping.service.IProductService;
//import by.pvt.dumping.service.IUserService;
//import by.pvt.dumping.service.exceptions.ServiceException;
//import by.pvt.dumping.utils.Paginator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//@Controller
//public class MainController {
//
//    private Paginator paginator = Paginator.INSTANCE;
//
//    @Autowired
//    private IProductService productService;
//    @Autowired
//    private ICategoryService categoryService;
//    @Autowired
//    private IUserService userService;
//
//    @RequestMapping(value = {"/guest_look"}, method = RequestMethod.GET)
//    public String showMainPage(HttpServletRequest request) {
//
//        HttpSession session = request.getSession();
//        String page;
//
//        try {
//            session.setAttribute(Parameters.TOTAL_PAGES_QUANTITY, productService.count());
//
//            List<Product> productList = productService.findAll(paginator.update(request));
//            request.setAttribute(Parameters.PRODUCT_LIST, productList);
//            List<Category> categoryList = categoryService.findAll();
//            request.setAttribute(Parameters.CATEGORY_LIST, categoryList);
//            page = ConfigManager.INSTANCE.getProperty(ConfigConstants.INDEX_PAGE_PATH);
//        }
//        catch (ServiceException e) {
//            session.invalidate();
//            page = ConfigManager.INSTANCE.getProperty(ConfigConstants.ERROR_PAGE_PATH);
//            request.setAttribute(Parameters.ERROR_DATABASE,
//                    MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE, request));
//        }
//        return "guest_look";
//
//    }
//
//}
