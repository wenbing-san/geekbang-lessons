package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/registerSubmit")
public class RegisterSubmitController implements PageController {

    private ServletContext servletContext;
    @POST
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        this.servletContext = request.getServletContext();
        //System.out.println("name = "+name);
        servletContext.log("name = "+name);
        servletContext.log("password = "+password);
        servletContext.log("email = "+email);
        servletContext.log("phoneNumber = "+phoneNumber);

//        UserService userService = new UserServiceImpl();
//        User user = userService.queryUserByNameAndEmail(name,email);
//        if (user != null){
//            return "registerError.jsp";
//        }else {
//            User registerUser = new User();
//            registerUser.setName(name);
//            registerUser.setEmail(email);
//            registerUser.setPassword(password);
//            registerUser.setPhoneNumber(phoneNumber);
//            userService.register(registerUser);
//        }

        return "registerSucceed.jsp";
    }
}
