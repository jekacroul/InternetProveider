package by.nure.jekacroul.web.command.admin;

import by.nure.jekacroul.Path;
import by.nure.jekacroul.db.entity.PackageServices;
import by.nure.jekacroul.db.entity.Tariff;
import by.nure.jekacroul.db.entity.User;
import by.nure.jekacroul.db.services.*;
import by.nure.jekacroul.db.services.*;
import by.nure.jekacroul.web.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author @author Evgeny Norkin
 */
public class MainCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IPackageService IPackageService = new PackageServiceImpl();
        ITariffService ITariffService = new TariffServiceImpl();
        IUserService IUserService = new UserServiceImpl();
        IContactDetailsService detailsService = new ContactDetailsServiceImpl();
        IAccountService IAccountService = new AccountServiceImpl();

        List<PackageServices> services = IPackageService.findAll();
        List<Tariff> internetTariffs = ITariffService.findAllById(1);
        List<Tariff> iptvTariffs = ITariffService.findAllById(2);
        List<Tariff> telephonyTariffs = ITariffService.findAllById(3);

        List<User> users = IUserService.findAll();
        List<User> fullUser = new ArrayList<>();
        for (User user : users) {
            user.setRoleId(user.getRoleId());
            user.setDetails(detailsService.find(user.getDetails().getId()));
            user.setAccount(IAccountService.find(user.getAccount().getId()));
            user.setTariffs(new HashSet<>(IUserService.findUserTariffs(user)));
            fullUser.add(user);
        }

        request.setAttribute("services", services);
        request.setAttribute("internetTariffs", internetTariffs);
        request.setAttribute("iptvTariffs", iptvTariffs);
        request.setAttribute("telephonyTariffs", telephonyTariffs);
        request.setAttribute("fullUser", fullUser);

        return Path.PAGE_MAIN;
    }
}

