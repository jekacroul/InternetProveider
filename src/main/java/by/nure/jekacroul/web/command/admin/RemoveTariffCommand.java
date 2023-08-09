package by.nure.jekacroul.web.command.admin;

import by.nure.jekacroul.Path;
import by.nure.jekacroul.db.services.ITariffService;
import by.nure.jekacroul.db.services.TariffServiceImpl;
import by.nure.jekacroul.web.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author @author Evgeny Norkin
 */
public class RemoveTariffCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ITariffService service = new TariffServiceImpl();
        int tariffId = Integer.parseInt(request.getParameter("tariff_id"));
        service.remove(tariffId);
        return Path.COMMAND_MAIN;
    }
}
