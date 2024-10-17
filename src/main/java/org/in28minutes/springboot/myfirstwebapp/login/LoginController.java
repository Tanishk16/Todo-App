//package org.in28minutes.springboot.myfirstwebapp.login;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//@Controller
//@SessionAttributes("name")
//public class LoginController {
//
////    @Autowired
//    private AuthenticationService authenticateService;
//
//    public LoginController(AuthenticationService authenticateService) {
//        super();
//        this.authenticateService = authenticateService;
//    }
//
//    //    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    //http://localhost:8080/login?name=Tanishk
//
//    //This is for only the get request
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String gotoLoginPage(ModelMap modelMap){
//        modelMap.put("name","in28minutes");
//        return "welcome";
//    }
//
//    // This is for the post request
//    @RequestMapping(value = "login",method = RequestMethod.POST)
//    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap){
//
//        if(authenticateService.authenticate(name,password)) {
//
//            modelMap.put("name", name);
//            return "welcome";
//        }
//        modelMap.put("errorMessage","Invalid Credential ! Please try again");
//        return "login";
//    }
//
//}
