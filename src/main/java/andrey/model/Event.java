package andrey.model;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private File file;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User users;

    public Event() {
    }

    public Event(Long id, File file) {
        this.id = id;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", file=" + file +
                ", users=" + users +
                '}';
    }
}
