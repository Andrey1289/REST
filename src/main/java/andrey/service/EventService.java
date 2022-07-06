package andrey.service;

import andrey.model.Event;
import andrey.repository.EventRepository;
import andrey.repository.hibernateImplRepository.HibernateEventImpl;

import java.util.List;

public class EventService implements EventRepository {
    private final HibernateEventImpl eventRepo;

    public EventService(){
        eventRepo = new HibernateEventImpl();
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
