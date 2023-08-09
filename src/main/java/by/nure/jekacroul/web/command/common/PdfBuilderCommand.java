package by.nure.jekacroul.web.command.common;

import by.nure.jekacroul.Path;
import by.nure.jekacroul.db.entity.User;
import by.nure.jekacroul.db.services.*;
import by.nure.jekacroul.utils.ReportBuilder;
import by.nure.jekacroul.web.command.ICommand;
import by.nure.jekacroul.db.services.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

/**
 * @author @author Evgeny Norkin
 */
public class PdfBuilderCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String forward = Path.COMMAND_MAIN;
        if (session.getAttribute("newUser") != null) {
            User user = (User) session.getAttribute("newUser");

            ReportBuilder.contractPDF(response, user);
        } else {
            long id = Long.parseLong(request.getParameter("user_id"));
            IUserService userService = new UserServiceImpl();
            IContactDetailsService detailsService = new ContactDetailsServiceImpl();
            IAccountService accountService = new AccountServiceImpl();

            User fullUser = userService.find(id);
            fullUser.setRoleId(fullUser.getRoleId());
            fullUser.setDetails(detailsService.find(fullUser.getDetails().getId()));
            fullUser.setAccount(accountService.find(fullUser.getAccount().getId()));
            fullUser.setTariffs(new HashSet<>(userService.findUserTariffs(fullUser)));
            request.setAttribute("fullUser", fullUser);

            ReportBuilder.contractPDF(response, fullUser);
        }
        return forward;
    }
}
