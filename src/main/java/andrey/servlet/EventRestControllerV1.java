package andrey.servlet;

import andrey.model.Event;
import andrey.service.EventService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Events", urlPatterns = "/api/v1/events")
public class EventRestControllerV1 extends HttpServlet {

    private EventService eventService = new EventService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String parameterQuery =  req.getParameter("id");
            if(parameterQuery == null) {
                List<Event> eventList = eventService.getAll();
                writer.println(this.gson.toJson(eventList));
                System.out.println(eventList);
            } else {
                Event event = eventService.getById(Long.parseLong(parameterQuery));
                writer.println(this.gson.toJson(event));
                writer.println(resp.getHeaderNames());
                System.out.println(eventService.getAll());
            }

        }catch (Exception e){
            PrintWriter writer = resp.getWriter();
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            resp.sendError(500);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Event event = gson.fromJson(req.getReader(),Event.class);
        Event createdEvent = eventService.save(event);
        PrintWriter writer = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        writer.println(this.gson.toJson(createdEvent));

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Event event = gson.fromJson(req.getReader(),Event.class);
       Event updatingEvent =  eventService.update(event);
       PrintWriter writer = resp.getWriter();
       resp.setContentType("application/json");
       resp.setCharacterEncoding("UTF-8");
       writer.println(this.gson.toJson(updatingEvent));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        eventService.delete(id);
        PrintWriter writer = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.sendError(200);

    }
}