package andrey.service;

import andrey.model.Event;
import andrey.repository.EventRepository;
import andrey.repository.hibernate.HibernateEventRepositoryImpl;

import java.util.List;

public class EventService implements EventRepository {
    private final EventRepository eventRepo;

    public EventService(){
        eventRepo = new HibernateEventRepositoryImpl();
    }

    @Override
    public List<Event> getAll() {
        return eventRepo.getAll();
    }

    @Override
    public Event getById(Long aLong) {
        return eventRepo.getById(aLong);
    }

    @Override
    public void delete(Long aLong) {
        eventRepo.delete(aLong);
    }

    @Override
    public Event save(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event update(Event event) {
        return eventRepo.update(event);
    }
}
