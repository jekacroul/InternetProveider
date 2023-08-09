package by.nure.jekacroul.web.command.admin;

import by.nure.jekacroul.Path;
import by.nure.jekacroul.db.entity.Tariff;
import by.nure.jekacroul.db.services.ITariffService;
import by.nure.jekacroul.db.services.TariffServiceImpl;
import by.nure.jekacroul.web.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author @author Evgeny Norkin
 */
public class AddTariffCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name").trim();
        String price = request.getParameter("price").trim();
        String description = request.getParameter("description").trim();
        String serviceId = request.getParameter("serviceId");

        String resp = Path.COMMAND_MAIN;

        ITariffService service = new TariffServiceImpl();
        Tariff tariff = new Tariff();
        tariff.setName(name);
        tariff.setPrice(Double.parseDouble(price));
        tariff.setDescription(description);
        tariff.setServiceId(Long.parseLong(serviceId));

        service.save(tariff);
        try {
            response.sendRedirect(resp);
            resp = Path.COMMAND_REDIRECT;
        } catch (IOException e) {
            resp = Path.PAGE_ERROR_PAGE;
        }
        return resp;
    }
}
